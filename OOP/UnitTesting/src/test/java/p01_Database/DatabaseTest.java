package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Integer [] NUMBERS = {1, 2, 3, 4};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatesValidDb() throws OperationNotSupportedException {
        Integer [] dbElements = database.getElements();
        assertArrayEquals(NUMBERS, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExWhenEmpty() throws OperationNotSupportedException {
        Integer [] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExWithMoreThan16el() throws OperationNotSupportedException {
        Integer [] array = new Integer[17];
        new Database(array);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullThrowsEx() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddElement() throws OperationNotSupportedException {
        database.add(10);
        Integer [] dbElements = database.getElements();
        assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(10));
        assertEquals(dbElements.length, NUMBERS.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveNullThrowsEx() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemoveEl() throws OperationNotSupportedException {
        Integer [] beforeRemove = database.getElements();
        database.remove();
        Integer [] afterRemove = database.getElements();
        assertEquals(beforeRemove.length - 1, afterRemove.length);

        int secondLastElement = afterRemove[afterRemove.length - 1];
        int lastElement = beforeRemove[beforeRemove.length - 2];
        assertEquals(secondLastElement, lastElement);
    }
}