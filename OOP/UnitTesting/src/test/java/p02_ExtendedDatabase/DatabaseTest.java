package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Person Ivan = new Person(1, "Ivan");
    private static final Person Petar = new Person(2, "Petar");
    private static final Person Todor = new Person(3, "Todor");
    private static final Person [] PERSON = {Ivan, Petar, Todor};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(Ivan, Petar, Todor);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullThrowsEx() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddElements() throws OperationNotSupportedException {
        Person person = new Person(4, "Dani");
        database.add(person);
        Person [] people = database.getElements();
        assertEquals(people[people.length - 1], person);
        assertEquals(people.length, PERSON.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveNullThrowsEx() throws OperationNotSupportedException {
        for (int i = 0; i < PERSON.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemoveEl() throws OperationNotSupportedException {
        Person [] peopleBeforeRemove = database.getElements();
        database.remove();
        Person [] peopleAfterRemove = database.getElements();
        assertEquals(peopleBeforeRemove.length - 1, peopleAfterRemove.length);

        assertEquals(peopleAfterRemove[peopleAfterRemove.length - 1],
                peopleBeforeRemove[peopleBeforeRemove.length - 2]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExWhenNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExWhenMissing() throws OperationNotSupportedException {
        database.findByUsername("Sasho");
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername(Ivan.getUsername());
        assertEquals(person.getUsername(), Ivan.getUsername());
        assertEquals(person.getId(), Ivan.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsExWhenMissing() throws OperationNotSupportedException {
        database.findById(6);
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
      Person person = database.findById(Ivan.getId());
      assertEquals(person.getId(), Ivan.getId());
      assertEquals(person.getUsername(), Ivan.getUsername());
    }
}