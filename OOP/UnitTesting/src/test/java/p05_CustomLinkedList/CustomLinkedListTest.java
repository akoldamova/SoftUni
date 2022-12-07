package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;

    @Before
    public void setUp(){
        list = new CustomLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsExWhenNegativeIndex(){
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsExWithBiggerIndex(){
        list.get(6);
    }

    @Test
    public void testGet(){
        String expexted = "b";
        assertEquals(expexted, list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsExWhenIndexNegative(){
        list.set(-1, "d");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsExWhenBiggerIndex(){
        list.set(3, "d");
    }

    @Test
    public void testSet(){
        list.set(0, "d");
        assertEquals("d", list.get(0));
    }

    @Test
    public void testAdd(){
        int prevousSize = list.getCount();
        list.add("d");
        int currentSize = list.getCount();
        assertEquals("d", list.get(3));
        assertEquals(prevousSize + 1, currentSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExWhenNegativeIndex(){
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExWhenBiggerIndex(){
        list.removeAt(3);
    }

    @Test
    public void testRemoveAtRemoves(){
        int prevousSize = list.getCount();
        list.removeAt(1);
        int currentSize = list.getCount();
        assertEquals("c", list.get(1));
        assertEquals(prevousSize - 1, currentSize);
    }

    @Test
    public void testIndexOfReturnsCorrectIndexWhenFound(){
        assertEquals(1, list.indexOf("b"));
    }

    @Test
    public void testIndexOfReturnNegativeWhenIndexNotFound(){
        assertEquals(-1, list.indexOf("d"));
    }

    @Test
    public void testContainsReturnsTrueWhenFound(){
        assertTrue(list.contains("b"));
    }

    @Test
    public void testContainsReturnsFalseWhenNotFound(){
        assertFalse(list.contains("d"));
    }
}