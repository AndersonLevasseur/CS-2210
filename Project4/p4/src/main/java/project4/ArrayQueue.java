package project4;

 
public class ArrayQueue<E> implements Queue<E> {
    private Object[] arrayQueue = new Object[5];
    // frontIndex actually pointing at front object
    // rearIndex actually pointing at rear object
    private int frontIndex, rearIndex, arraySize;

    public ArrayQueue() {
        frontIndex = 0;
        rearIndex = 0;
        arraySize = 5;
    }

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

    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        Object element = arrayQueue[frontIndex];
        frontIndex++;
        return (E) element;
    }

    public E front() throws QueueEmptyException {
        if (size() == 0) {
            throw new QueueEmptyException();
        }
        return (E) arrayQueue[frontIndex];
    }

    public int size() {
        return (rearIndex - frontIndex) % arraySize;
    }

    public boolean isEmpty() {
        return rearIndex == frontIndex;
    }

    private void resize() {
        Object[] temp = new Object[arraySize * 2];

        for (int i = frontIndex; i < arraySize + frontIndex; i++) {
            temp[i - frontIndex] = arrayQueue[i % arraySize];
        }

        frontIndex = 0;
        //could also call size() to amke things more readable, this is faster though
        rearIndex = arraySize - 1;
        arraySize *= 2;

        arrayQueue = temp;
    }
}