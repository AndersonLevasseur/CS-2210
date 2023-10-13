package project4;

import java.lang.reflect.Array;

// import 
public class ArrayQueue<E> implements Queue {
    private Array<E> arrayQueue = new Array<E>();
    //frontIndex actually pointing at front object
    //rearIndex actually pointing at rear object
    private int frontIndex, rearIndex, arraySize;

    public ArrayQueue () {
        arrayQueue = new Array<E>(5);
        frontIndex = 0;
        rearIndex = 0;
        arraySize = 5;
    }

    public void enqueue(E element) throws InvalidDataException {
        //to account for 0 index
        if (size() == arraySize - 1) {
            resize();
        }
        arrayQueue[rearIndex] = element;
        rearIndex++;
    }

    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        E element = arrayQueue[frontIndex];
        frontIndex++;
        return element;
    }

    public E front() throws QueueEmptyException {
        return arrayQueue[frontIndex];
    }

    public int size() {
        return (rearIndex - frontIndex) % arraySize;
    }

    public boolean isEmpty() {
        return rearIndex == frontIndex;
    }

    private void resize() {
        Array<E> temp = new Array<E>(arraySize*2);
        
        for (int i = frontIndex; i < arraySize + frontIndex; i++) {
            temp[i - frontIndex] = arrayQueue[i % arraySize];
        }

        frontIndex = 0;
        rearIndex = arraySize;
        arraySize *= 2;
    }
}