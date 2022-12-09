package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTest {

    Excavation excavation;
    Archaeologist archaeologist;

    @Before
    public void setUp(){
        excavation = new Excavation("Name", 20);
        archaeologist = new Archaeologist("Ivan", 40);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistThrowsExWhenNoCapacity(){
        Excavation fullExcavation = new Excavation("Name", 0);
        Archaeologist archaeologist1 = new Archaeologist("Ivan", 40);
        fullExcavation.addArchaeologist(archaeologist1);
    }

    @Test
    public void testAddArcheologistAddsArcheologist(){
        int previousSize = excavation.getCount();
        excavation.addArchaeologist(archaeologist);
        assertEquals(previousSize + 1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistNotAddWhenArcheologistAlreadyExists(){
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArcheologistRemoves(){
        excavation.addArchaeologist(archaeologist);
        int previousSize = excavation.getCount();
        assertTrue(excavation.removeArchaeologist("Ivan"));
        assertEquals(previousSize - 1, excavation.getCount());
    }

    @Test
    public void testRemoveArcheologistReturnsFalseWhenNotFound(){
        excavation.addArchaeologist(archaeologist);
        assertFalse(excavation.removeArchaeologist("Petar"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsExWhenNegative(){
        new Excavation("Name", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsExWhenNull(){
        new Excavation(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsExWhenIsSpace(){
        new Excavation(" ", 2);
    }
}