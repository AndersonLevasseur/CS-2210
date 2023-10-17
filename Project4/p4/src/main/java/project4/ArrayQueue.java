package project4;

/**
 * This class implements a queue to crete an ArrayQueue
 *
 * @author Anderson Levasseur
 * @version 1.0
 * @throws InvalidDataException
 * @throws QueueEmptyException
 * @File ArrayQueue.java
 * @Created October 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           16 October 2023 built out class
 * 
 * @Description
 *              This class creates an ArrayQueue by implementing a Queue. The
 *              queue can be found at Queue.java in this package
 * @see Queue.java
 * @see InvalidDataException.java
 * @see QueueEmptyException.java
 */

public class ArrayQueue<E> implements Queue<E> {
    private Object[] arrayQueue = new Object[5];
    // frontIndex actually pointing at front object
    // rearIndex actually pointing at rear object
    private int frontIndex, rearIndex, arraySize;

    /**
     * @param None - ArrayQueue Constructor, maybe not needed?
     * @return Nothing
     */
    public ArrayQueue() {
        frontIndex = 0;
        rearIndex = 0;
        arraySize = 5;
    }

    /**
     * Adds Item to ArrayQueue
     * 
     * @param element - Element to be added to this ArrayQueue, must be of same type
     *                as ArrayQueue and connot be null
     * @throws InvalidDataException throws when passed element is null
     * @see InvalidDataException.java
     * @return Nothing
     */
    public void enqueue(E element) throws InvalidDataException {
        // to account for 0 index
        if (size() == arraySize - 1) {
            resize();
        }
        if (element == null) {
            throw new InvalidDataException();
        }

        arrayQueue[rearIndex] = element;
        rearIndex++;
    }

    /**
     * Removes and returns the first item from ArrayQueue in the FIFO (First in
     * First Out) manner
     * 
     * @throws QueueEmptyException - When the ArrayQueue is empty
     * @see QueueEmptyException.java
     * @return The first item in the ArrayQueue
     */
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        Object element = arrayQueue[frontIndex];
        frontIndex++;
        return (E) element;
    }

    /**
     * Returns the first item in the ArrayQueue in the FIFO manner (First in First
     * Out)
     * 
     * @throws QueueEmptyException - When the ArrayQueue is empty
     * @see QueueEmptyException.java
     * @return The first item in the ArrayQueue
     */
    public E front() throws QueueEmptyException {
        if (size() == 0) {
            throw new QueueEmptyException();
        }
        return (E) arrayQueue[frontIndex];
    }

    /**
     * @return Integer represeting the number of items in the surrent state of the
     *         ArrayQueue
     */
    public int size() {
        return (rearIndex - frontIndex) % arraySize;
    }

    /**
     * Returns True if the ArrayQueue is empty and false if it has items in it
     * 
     * @return True or False
     */
    public boolean isEmpty() {
        return rearIndex == frontIndex;
    }

    private void resize() {
        Object[] temp = new Object[arraySize * 2];

        for (int i = frontIndex; i < arraySize + frontIndex; i++) {
            temp[i - frontIndex] = arrayQueue[i % arraySize];
        }

        frontIndex = 0;
        // could also call size() to amke things more readable, this is faster though
        rearIndex = arraySize - 1;
        arraySize *= 2;

        arrayQueue = temp;
    }
}