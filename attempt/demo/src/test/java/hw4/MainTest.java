package hw4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void Test_maxExecRec() {
        Integer[] a = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(a, 5));

        Integer[] b = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(b, 5));

        Integer[] c = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(c, 5));

        Integer[] d = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(d, 5));

        Integer[] e = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(e, 5));

        Integer[] f = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(f, 5));

        Integer[] g = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(g, 5));

        Integer[] h = { 1, 2, 3, 4, 5 };
        assertSame(5, Main.maxElmntRec(h, 5));
    }

    @Test
    public void Test_stoiRec() {
        String in = "12345";
        int out = 12345;
        assertEquals(out, Main.stoiRec(in, 0));
    }

    @Test
    public void Test_fastRec() {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 4, 3, 2, 1 };

        assertArrayEquals(a, Main.fastRec(b, 0));

        int[] c = { 1, 2, 7, 2, 3, 3, 4 };
        int[] d = { 4, 3, 3, 2, 7, 2, 1 };

        assertArrayEquals(c, Main.fastRec(d, 0));

    }

    @Test
    public void Test_fasterRec() {
        LinkedList<Object> l = new LinkedList<Object>();
        l.push(1);
        l.push(2);
        l.push(3);
        l.push(4);
        l.push(5);
        l.push(6);
        l.push(7);

        LinkedList<Object> ll = new LinkedList<Object>();
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
        
        LinkedList<Object> al = new LinkedList<Object>();

        assertEquals(ll, Main.fasterRec(l, al));
    }

}
