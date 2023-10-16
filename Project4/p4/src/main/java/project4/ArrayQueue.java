package project4;


// import 
public class ArrayQueue<E> implements Queue<E> {
    private Object[] arrayQueue = new Object[5];
    //frontIndex actually pointing at front object
    //rearIndex actually pointing at rear object
    private int frontIndex, rearIndex, arraySize;

    public ArrayQueue () {
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
        Object element = arrayQueue[frontIndex];
        frontIndex++;
        return (E) element;
    }

    public E front() throws QueueEmptyException {
        return (E) arrayQueue[frontIndex];
    }

    public int size() {
        return (rearIndex - frontIndex) % arraySize;
    }

    public boolean isEmpty() {
        return rearIndex == frontIndex;
    }

    private void resize() {
        Object[] temp = new Object[arraySize*2];
        
        for (int i = frontIndex; i < arraySize + frontIndex; i++) {
            temp[i - frontIndex] = arrayQueue[i % arraySize];
        }

        frontIndex = 0;
        rearIndex = arraySize;
        arraySize *= 2;
    }
}