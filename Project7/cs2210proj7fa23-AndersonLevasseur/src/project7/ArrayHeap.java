package project7;

import java.util.Random;

/**
 * Title:        Project #7
 * Description: A heap that is stored in an array
 * Copyright:    Copyright (c) 2001
 * Company: Cedarville university
 *
 * @author Anderson Levasseur
 * @version 1.0
 */

public class ArrayHeap extends ArrayBinaryTree implements Heap {

    Comparator heapComp;

    public ArrayHeap(Comparator newComp) {
        this(newComp, DEFAULT_SIZE);
    }

    public ArrayHeap(Comparator newComp, int newSize) {
        super(newSize);
        heapComp = newComp;
    }

    // you may want to expand main; it is just provided as a sample
    public static void main(String[] args) {
        Comparator itemComp = new ItemComparator();
        Heap myHeap = new ArrayHeap(itemComp, 7);

        myHeap.add(Integer.valueOf(14), Integer.valueOf(14));
        myHeap.add(Integer.valueOf(17), Integer.valueOf(17));
        myHeap.add(Integer.valueOf(3), Integer.valueOf(3));
        myHeap.add(Integer.valueOf(2), Integer.valueOf(21));
        myHeap.add(Integer.valueOf(8), Integer.valueOf(8));
        myHeap.add(Integer.valueOf(7), Integer.valueOf(18));
        myHeap.add(Integer.valueOf(1), Integer.valueOf(1));
        myHeap.add(Integer.valueOf(19), Integer.valueOf(11));
        myHeap.add(Integer.valueOf(17), Integer.valueOf(17));
        myHeap.add(Integer.valueOf(25), Integer.valueOf(6));

        System.out.println(myHeap.size());
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            myHeap.add(Integer.valueOf(rand.nextInt(1)), Integer.valueOf(rand.nextInt()));
        }
        while (!myHeap.isEmpty()) {

            Item removedItem = (Item) myHeap.removeRoot();
            System.out.print("Key:   " + removedItem.key() + "     ");
            System.out.println("Removed " + removedItem.element());

        }
        System.out.println("All nodes removed");
    }

    /**
     * Places the given position in the correct spot in the heap
     *
     * @param currPos
     */
    public void bubbleUp(Position currPos) {
        ArrayPosition key = (ArrayPosition) currPos;
        while (!isRoot(key)
                && heapComp.isLessThan(key.element(), super.parent(key).element())) {
            // swap elements
            Object tmpEl = key.element();
            key.setElement(super.parent(key).element());
            ((ArrayPosition) super.parent(key)).setElement(tmpEl);
            key = (ArrayPosition) super.parent(key);
        }
    }

    /**
     * resizes the btArray to include the next layer of the heap
     */
    public void resize() {
        ArrayPosition[] newArr = new ArrayPosition[(size * 2) + 1];
        System.arraycopy(super.btArray, 0, newArr, 0, super.btArray.length);
        super.btArray = newArr;
    }

    /**
     * Creates a Item from newKey and newElement then creates an arrayPostion
     * from the Item and an index then adds it to the bottom of the heap
     *
     * @param newKey
     * @param newElement
     * @throws InvalidObjectException
     */
    public void add(Object newKey, Object newElement) throws InvalidObjectException {
        if (!heapComp.isComparable(new Item(newKey, newElement))) {
            throw new InvalidObjectException("Key not comparable");
        }
        if (size == super.btArray.length) {
            resize();
        }
        Item newItem = new Item(newKey, newElement);
        ArrayPosition newPos = new ArrayPosition(super.size, newItem);
        super.btArray[super.size] = newPos;
        super.size++;
        bubbleUp(newPos);
    }

    /**
     * Returns the smallest between rightChild, LeftChild and parent given parent
     *
     * @param oldKey
     * @return the smallest of parent and children
     */
    public Object lowest(Object oldKey) throws InvalidObjectException {
        Position par = (Position) oldKey;
        Position lChild = super.leftChild(par);
        Position rChild = super.rightChild(par);

        if (rChild == null) {
            if (heapComp.isLessThan(lChild.element(), par.element())) {
                return lChild;
            }
            return par;
        }

        if (heapComp.isLessThan(rChild.element(), lChild.element())
                && heapComp.isLessThan(rChild.element(), par.element())) {
            return rChild;
        } else if (heapComp.isLessThan(lChild.element(), par.element())
                && heapComp.isLessThanOrEqualTo(lChild.element(), rChild.element())) {
            return lChild;
        } else {
            return par;
        }
    }

    /**
     * Starting at the given key, compares with children and swap with
     * the lowest value
     *
     * @param pos
     */
    public void bubbleDown(Position pos) {
        ArrayPosition key = (ArrayPosition) pos;
        while (super.isInternal(key) && lowest(key) != key) {
            Object tmpEl = key.element();
            Position child;
            if (lowest(key) == super.leftChild(key)) {
                child = super.leftChild(key);
            } else {
                child = super.rightChild(key);
            }

            key.setElement(child.element());
            ((ArrayPosition) child).setElement(tmpEl);
            key = (ArrayPosition) child;
        }
    }

    /**
     * @return the item of root
     * @throws EmptyHeapException
     */
    public Object removeRoot() throws EmptyHeapException {
        Item root = (Item) super.root().element();
        ((ArrayPosition) super.root()).setElement(super.btArray[size - 1].element());
        bubbleDown(root());
        size--;

        return root;
    }
}
