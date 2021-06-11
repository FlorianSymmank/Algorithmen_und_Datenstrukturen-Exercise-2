package Exercise.lists;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void add() {

        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();
        Random rnd = new Random();
        int size = 500;
        int[] expected = new int[size];

        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            expected[i] = rndInt;
            actual.add(rndInt);
        }

        for (int i = 0; i < size; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }

        assertEquals(size, actual.size());
    }

    @Test
    public void addFirst() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();
        Random rnd = new Random();
        int size = 500;
        int[] expected = new int[size];

        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            expected[size - i - 1] = rndInt;
            actual.addFirst(rndInt);
        }

        for (int i = 0; i < size; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }

        assertEquals(size, actual.size());
    }

    @Test
    public void getThrowsIndexOutOfBoundsException() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        // no Item -> any get should throw
        boolean thrown = false;
        try {
            actual.get(0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // no Item -> any get should throw
        thrown = false;
        try {
            actual.get(-1);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // one item -> any index > 0 should throw
        thrown = false;
        actual.add(0);
        try {
            actual.get(1);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void get() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        Random rnd = new Random();
        int size = 500;
        int[] expected = new int[size];

        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            expected[i] = rndInt;
            actual.add(rndInt);
        }

        for (int i = 0; i < size; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }
    }

    @Test
    public void setThrowsIndexOutOfBoundsException() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        // no Item -> any set should throw
        boolean thrown = false;
        try {
            actual.set(0, 0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // no Item -> any set should throw
        thrown = false;
        try {
            actual.set(-1, 0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // no Item -> any set should throw
        thrown = false;
        try {
            actual.set(1, 0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        actual.add(1);

        // one Item -> index > 0 should throw
        thrown = false;
        try {
            actual.set(1, 0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // one Item -> index 0 should not throw
        thrown = false;
        try {
            actual.set(0, 0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(!thrown);
    }

    @Test
    public void set() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        Random rnd = new Random();
        int size = 500;
        int[] expected = new int[size];

        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            expected[i] = rndInt;
            actual.add(rndInt);
        }

        for (int i = 0; i < 50; i++) {
            int rndIndex = rnd.nextInt(size);
            int rndInt = rnd.nextInt();
            expected[rndIndex] = rndInt;
            actual.set(rndIndex, rndInt);
        }

        for (int i = 0; i < size; i++) {
            assertEquals(expected[i], (int) actual.get(i));
        }

        assertEquals(expected.length, actual.size());
    }

    @Test
    public void removeThrowsIndexOutOfBoundsException() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        // no Item -> any remove should throw
        boolean thrown = false;
        try {
            actual.remove(0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // no Item -> any remove should throw
        thrown = false;
        try {
            actual.remove(-1);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // no Item -> any remove should throw
        thrown = false;
        try {
            actual.remove(1);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        actual.add(1);

        // one Item -> index > 0 should throw
        thrown = false;
        try {
            actual.remove(1);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(thrown);

        // one Item -> index 0 should not throw
        thrown = false;
        try {
            actual.remove(0);
        } catch (IndexOutOfBoundsException exception) {
            thrown = true;
        }
        assertTrue(!thrown);
        assertEquals(0, actual.size());
    }

    @Test
    public void remove() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        Random rnd = new Random();
        int size = 500;
        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            actual.add(rndInt);
        }

        int expected = rnd.nextInt(50);
        for (int i = 0; i < expected; i++) {
            actual.remove(i);
        }

        assertEquals(expected, size - actual.size());
    }

    @Test
    public void clear() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        Random rnd = new Random();
        int size = 500;
        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            actual.add(rndInt);
        }

        actual.clear();
        assertEquals(0, actual.size());
    }

    @Test
    public void size() {
        DoublyLinkedList<Integer> actual = new DoublyLinkedList<Integer>();

        Random rnd = new Random();
        int size = 500;
        for (int i = 0; i < size; i++) {
            int rndInt = rnd.nextInt();
            actual.add(rndInt);
        }

        assertEquals(size, actual.size());
    }
}