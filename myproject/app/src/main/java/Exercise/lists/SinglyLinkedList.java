package Exercise.lists;

import java.util.function.Predicate;

public class SinglyLinkedList<T> implements IListable<T> {

    /**
     * private Node class to link data
     */
    private class Node {
        Node next;
        T data;

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }

        public Node() {
        }
    }

    private int itemCount = 0;
    private Node head = null;
    private Node tail = null;

    /**
     * Constructor initializes head and tail as well as setting head.next to tail
     */
    public SinglyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param data element to be appended to this list
     */
    @Override
    public void add(T data) {
        tail.data = data;
        tail.next = new Node();
        tail = tail.next;
        itemCount++;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param data  element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T data) throws IndexOutOfBoundsException {

        if (index > size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i <= index; i++) {

            if (index == i) {
                curr.next = new Node(curr.next, data);
                itemCount++;
                return;
            }

            curr = curr.next;
        }
    }

    /**
     * Inserts the specified element at the first position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param data element to be inserted as first element
     */
    @Override
    public void addFirst(T data) {
        head.next = new Node(head.next, data);
        itemCount++;
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param data element to be appended to this list
     */
    @Override
    public void addLast(T data) throws IndexOutOfBoundsException {
        add(data);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &ge; size())
     */
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

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param data  element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &ge; size())
     */
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

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices)
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &ge; size())
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        itemCount--;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = new Node();
        head.next = tail;
        itemCount = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return itemCount;
    }

    /**
     * Returns if the list is empty.
     *
     * @return if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns all elements toString() methods concatenated (one per line).
     *
     * @return all elements toString() methods concatenated (one per line).
     */
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

    /**
     * Searches through list and finds all elements with mating pattern.
     * @param predicate The pattern to be searched.
     * @return filtered SinglyLinkedList with all elements from the original list with matching pattern.
     */
    public IListable<T> filter(Predicate<T> predicate) {

        SinglyLinkedList<T> filteredList = new SinglyLinkedList<>();
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
