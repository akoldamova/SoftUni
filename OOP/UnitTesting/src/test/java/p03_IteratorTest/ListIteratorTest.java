package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String [] elements = {"a", "b", "c"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExcWhenNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldAdd() throws OperationNotSupportedException {
        new ListIterator(elements);
    }

    @Test
    public void testHasNext(){
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
        listIterator.move();
    }

    @Test
    public void testMove(){
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintThrowsExWhenEmpty() throws OperationNotSupportedException {
        String [] empty = new String[0];
        ListIterator listIterator1 = new ListIterator(empty);
        listIterator1.print();
    }

    @Test
    public void testPrint(){
        assertEquals(elements[0], listIterator.print());
        listIterator.move();
        assertEquals(elements[1], listIterator.print());
        listIterator.move();
        assertEquals(elements[2], listIterator.print());
    }
}