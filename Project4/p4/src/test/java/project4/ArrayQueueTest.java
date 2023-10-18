package project4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the ArrayQueue class
 *
 * @author Anderson Levasseur
 * @version 1.0
 * @File ArrayQueueTest.java
 * @Created October 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           17 October 2023 built tests
 * 
 * @Description
 *              This class tests the ArrayQueue class using Junit5.
 * @see ArrayQueue.java
 */
public class ArrayQueueTest {
    ArrayQueue<Integer> testInt;
    ArrayQueue<Double> testDouble;

    /**
     * Instantiates a new ArrayQueue of type integer before every test
     */
    @BeforeEach
    public void setup() {
        testInt = new ArrayQueue<>();

    }

    /**
     * Tests that ArrayQueue will work with integers
     */
    @Test
    public void Int_ArrayQueue() {
        testInt.enqueue(9);
        assertSame(9, testInt.front());
    }

    /**
     * Tests that ArrayQueue will also work with double
     */

    @Test
    public void Double_ArrayQueue() {
        testDouble = new ArrayQueue<>();
        Double l = 9.0;
        testDouble.enqueue(l);
        assertSame(l, testDouble.front());
    }

    /**
     * Tests that ArrayQueue will enqueue multiply items, and that the length
     * matches the fact that there were enqueues and that the front item is the
     * first item that was pushed to the arrayQueue
     */

    @Test
    public void Int_ArrayQueue_enqueues() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertEquals(2, testInt.size());
        assertSame(n, testInt.front());
    }

    /**
     * Tests that ArrayQueue dequeues and returns the correct item also checks that
     * the size changes to be what it should
     */

    @Test
    public void Int_ArrayQueue_dequeues() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertSame(n, testInt.dequeue());
        assertEquals(1, testInt.size());
    }

    /**
     * Tests that ArrayQueue front method returns the first item queued, but doesn't
     * change the length
     */
    @Test
    public void Int_ArrayQueue_front_returns_first_element() {
        testInt.enqueue(1);
        testInt.enqueue(2);
        testInt.enqueue(3);
        testInt.dequeue();
        Integer n = 5;
        testInt.enqueue(n);
        testInt.dequeue();
        testInt.dequeue();
        assertSame(n, testInt.front());
    }

    /**
     * Tests that ArrayQueue front method returns the first item queued after a
     * dequeue, but doesn't change the length
     */
    @Test
    public void Int_ArrayQueue_front_returns_first_element_after_dequeue() {
        testInt.enqueue(1);
        testInt.enqueue(2);
        testInt.enqueue(3);
        testInt.dequeue();
        Integer n = 5;
        testInt.enqueue(n);
        testInt.dequeue();
        testInt.dequeue();
        assertSame(n, testInt.front());
    }

    /**
     * Tests that array size returns two when two elements are queued
     */
    @Test
    public void Int_ArrayQueue_size_finds_size() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertEquals(2, testInt.size());
    }

    /**
     * Tests that size returns zero when queue is empty
     */
    @Test
    public void Int_ArrayQueue_size_finds_size_when_empty() {
        assertEquals(0, testInt.size());
    }

    /**
     * Tests that size returns zero when queue is empty
     */
    @Test
    public void Int_ArrayQueue_size_finds_size_when_full() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);
        assertEquals(5, testInt.size());
    }

    /**
     * Tests that isEmpty returns true when ArrayQueue after one enqueue and one
     * dequeue
     */
    @Test
    public void Int_ArrayQueue_isEmpty_after_enqueue_and_dequeue() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.dequeue();
        assertEquals(true, testInt.isEmpty());
    }

    /**
     * Tests that isEmpty returns true when ArrayQueue is empty
     */
    @Test
    public void Int_ArrayQueue_isEmpty_on_empty_arrayQueue() {
        assertEquals(true, testInt.isEmpty());
    }

    /**
     * Tests that isEmpty returns false when ArrayQueue is full
     */
    @Test
    public void Int_ArrayQueue_isEmpty_when_ArrayQueue_full() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);
        testInt.enqueue(n);

        assertEquals(false, testInt.isEmpty());
    }

    /**
     * Tests that isEmpty returns false on a list that isn't empty
     */
    @Test
    public void Int_ArrayQueue_isEmpty_after_enqueue() {
        Integer n = 1;
        testInt.enqueue(n);
        assertEquals(false, testInt.isEmpty());
    }

    /**
     * Tests that arrayQueue automatically resizes when full
     */
    @Test
    public void Int_ArrayQueue_resizes_properly_when_needed() {
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;
        Integer six = 6;
        Integer sev = 7;

        testInt.enqueue(one);
        testInt.enqueue(two);
        testInt.enqueue(three);
        testInt.enqueue(four);
        testInt.enqueue(five);
        testInt.enqueue(six);
        testInt.enqueue(sev);
        assertEquals(7, testInt.size());
        assertSame(one, testInt.dequeue());
        assertSame(two, testInt.dequeue());
        assertSame(three, testInt.dequeue());
        assertSame(four, testInt.dequeue());
        assertSame(five, testInt.dequeue());
        assertSame(six, testInt.dequeue());
        assertSame(sev, testInt.dequeue());

    }

    /**
     * Tests that ArrayQueue will resize and when the array firstIndex isn't index
     * it will reorder it
     */
    @Test
    public void Int_ArrayQueue_resizes_when_scrambled() {
        for (int i = 0; i < 33; i++) {
            testInt.enqueue(i);
            testInt.dequeue();
            testInt.enqueue(i + 1);
        }

        for (int i = 17; i < 33; i++) {
            assertSame(i, testInt.dequeue());
            assertSame(i, testInt.dequeue());
        }
    }

    /**
     * Tests that dequeue throws when the ArrayQueue isEmpty
     */
    @Test
    public void Dequeue_throws_when_empty() {
        assertThrows(QueueEmptyException.class, () -> {
            testInt.dequeue();
        });
    }

    /**
     * Tests that front throws a QueueEmptyException when the ArrayQueue is empty
     */
    @Test
    public void Front_throws_when_empty() {
        assertThrows(QueueEmptyException.class, () -> {
            testInt.front();
        });
    }

    /**
     * Tests that Enqueue throws when null data is passed into the ArrayQueue
     */
    @Test
    public void Enqueue_throws_when_invalid_data_type() {
        assertThrows(InvalidDataException.class, () -> {
            testInt.enqueue(null);
        });
    }
}
