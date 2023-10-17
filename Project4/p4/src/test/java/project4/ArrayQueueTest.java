package project4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest {
    ArrayQueue<Integer> testInt;
    ArrayQueue<Double> testDouble;

    @BeforeEach
    public void setup() {
        testDouble = new ArrayQueue<>();
        testInt = new ArrayQueue<>();

    }

    @Test
    public void Int_ArrayQueue() {
        testInt.enqueue(9);
        assertSame(9, testInt.front());
    }

    @Test
    public void Double_ArrayQueue() {
        Double l = 9.0;
        testDouble.enqueue(l);
        assertSame(l, testDouble.front());
    }

    @Test
    public void Int_ArrayQueue_enqueues() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertEquals(2, testInt.size());
        assertSame(n, testInt.front());
    }

    @Test
    public void Int_ArrayQueue_dequeues() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertSame(n, testInt.dequeue());
        assertEquals(1, testInt.size());
    }

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

    @Test
    public void Int_ArrayQueue_size_finds_size() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.enqueue(2);
        assertEquals(2, testInt.size());
    }

    @Test
    public void Int_ArrayQueue_isEmpty_works() {
        Integer n = 1;
        testInt.enqueue(n);
        testInt.dequeue();
        assertEquals(true, testInt.isEmpty());
    }

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

    @Test
    public void Dequeue_throws_when_empty() {
        assertThrows(QueueEmptyException.class, () -> {
            testInt.dequeue();
        });
    }

    @Test
    public void Front_throws_when_empty() {
        assertThrows(QueueEmptyException.class, () -> {
            testInt.front();
        });
    }

    @Test
    public void Enqueue_throws_when_invalid_data_type() {
        assertThrows(InvalidDataException.class, () -> {
            testInt.enqueue(null);
        });
    }

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

}
