package Exercise.lists;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Random;

public class SinglyLinkedListTest {

    @Test
    public void add() {

        SinglyLinkedList<Integer> actual = new SinglyLinkedList<Integer>();
        Random rnd = new Random();
        int size = 500;
        int[] expected = new int[size];

        for(int i = 0; i < size; i++){
            int rndInt = rnd.nextInt();
            expected[i] = rndInt;
            actual.add(rndInt);
        }

        for(int i = 0; i < size; i++){
            assertEquals(expected[i], (int)actual.get(i));
        }
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void size() {
    }

    @Test
    public void testToString() {
    }
}