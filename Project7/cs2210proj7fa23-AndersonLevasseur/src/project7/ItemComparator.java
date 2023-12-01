package project7;

import java.util.Objects;

/**
 * Compares items when both the key and element are integers
 */
public class ItemComparator implements Comparator {

    public ItemComparator() {
    }

    public boolean isLessThan(Object obj1, Object obj2) throws InvalidObjectException {
        if (!isComparable(obj1) || !isComparable(obj2)) {
            throw new InvalidObjectException("Object not an item");
        }

        Item it1;
        Item it2;
        it1 = (Item) obj1;
        it2 = (Item) obj2;

        if (Objects.equals(it1.key(), it2.key())) {
            return (Integer) it1.element() < (Integer) it2.element();
        }
        return (Integer) it1.key() < (Integer) it2.key();

    }

    public boolean isLessThanOrEqualTo(Object obj1, Object obj2) throws InvalidObjectException {
        return (!isLessThan(obj2, obj1));
    }

    public boolean isGreaterThan(Object obj1, Object obj2)
            throws InvalidObjectException {
        return (isLessThan(obj2, obj1));
    }

    public boolean isGreaterThanOrEqualTo(Object obj1, Object obj2)
            throws InvalidObjectException {
        return (!isLessThan(obj1, obj2));
    }

    public boolean isEqual(Object obj1, Object obj2)
            throws InvalidObjectException {
        return ((!isLessThan(obj1, obj2)) && (!isLessThan(obj2, obj1)));
    }

    public boolean isComparable(Object obj) {
        return (obj instanceof Item) && (((Item) obj).key() instanceof Integer);
    }

}
