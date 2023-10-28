package hw5;


/**
 * @author Anderson Levasseur
 * @author Zachary Benjamin
 * @author Noah Karg
 * @author Ethan Burdett

 * @version 42.0
 * @File NodeListStack.java
 * @Created October 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           24 October 2023 built class
 * 
 * @see LinkedPositionList.java
 */
public class NodeListStack <E> extends LinkedPositionalList<E>  {
    LinkedPositionalList data;

    public NodeListStack() {
        data = new LinkedPositionalList();
    }

    
    public int size() {
        return data.size();    
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void push(E object) {
        data.addFirst(object);
    }

    public E pop() throws StackEmptyException  {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return (E) data.remove(data.first());
    }

    public E top() throws StackEmptyException  {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return (E) data.first().getElement();
    }
}
