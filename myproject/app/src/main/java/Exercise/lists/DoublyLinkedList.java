package Exercise.lists;

import java.util.function.Predicate;

public class DoublyLinkedList<T> implements IListable<T> {

    /**
     * private Node class to link data
     */
    private class Node {
        Node next;
        Node previous;

        T data;

        public Node(Node next, Node previous, T data) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }

        public Node() {
        }
    }

    private int itemCount = 0;
    private Node head = null;
    private Node tail = null;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.previous = tail;

        head.previous = null;
        tail.next = null;
    }

    @Override
    public void add(T data) {

        Node node = new Node();
        node.previous = tail;

        tail.data = data;
        tail.next = node;
        tail = tail.next;

        itemCount++;
    }

    @Override
    public void add(int index, T data) throws IndexOutOfBoundsException {

        if (index > size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i <= index; i++) {

            if (index == i) {
                Node node = new Node(curr, curr.previous, data);
                curr.previous.next = node;
                curr.previous = node;
                itemCount++;
                return;
            }

            curr = curr.next;
        }
    }

    @Override
    public void addFirst(T data) {
        Node node = new Node();
        node.data = data;

        node.next = head.next;
        head.next = node;

        node.previous = head;
        node.next.previous = node;

        itemCount++;
    }

    @Override
    public void addLast(T data) {
        add(data);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    @Override
    public void set(int index, T data) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }

        curr.data = data;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        curr.next.previous = curr;
        itemCount--;
    }

    @Override
    public void clear() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.previous = head;

        head.previous = null;
        tail.next = null;

        itemCount = 0;
    }

    @Override
    public int size() {
        return itemCount;
    }

    @Override
    public boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head.next;

        while (curr != tail) {
            sb.append(curr.data.toString());
            sb.append("\n");
            curr = curr.next;
        }

        return sb.toString();
    }

    @Override
    public IListable<T> filter(Predicate<T> predicate) {
        DoublyLinkedList<T> filteredList = new DoublyLinkedList<>();
        Node tmp = head.next;

        while (tmp.next != null) {
            if (predicate.test(tmp.data)) {
                filteredList.add(tmp.data);
            }
            tmp = tmp.next;
        }

        return filteredList;
    }
}
