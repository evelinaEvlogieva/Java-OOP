package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] people = {new Person(10, "Pesho"),
            new Person(19, "Ani")};
    private Database database;

    @Before
    public void setDBFields() throws OperationNotSupportedException {
        this.database = new Database(people);
    }

    @Test
    public void DBCreationTestShouldCreateObjectWithValidParameters() {
        Person[] elements = this.database.getElements();
        Assert.assertEquals(people.length, elements.length);
    }

    @Test
    public void DBCreationTestShouldSetElementsInCorrectOrderAccordingToInitialParameters() {
        Person[] elements = this.database.getElements();
        Assert.assertArrayEquals(people, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void DBCreationTestShouldThrowExceptionWithNullParameters() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void DBCreationTestShouldThrowExceptionWitMoreThanSixteenParameters() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddingNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void shouldAddElement() throws OperationNotSupportedException {
        Person person = new Person(41, "Mimi");
        this.database.add(person);
        Person[] list = this.database.getElements();
        Person lastPerson = list[list.length - 1];
        Assert.assertEquals(person, lastPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenRemovingNullElement() throws OperationNotSupportedException {
        for (int i = 0; i < people.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }

    @Test
    public void shouldRemoveElement() throws OperationNotSupportedException {
        this.database.remove();
        Person[] elements = this.database.getElements();
        Person lastElement = elements[elements.length - 1];
        Assert.assertEquals(people[people.length - 2], lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameCantFindPersonWithGivenUsername() throws OperationNotSupportedException {
        this.database.findByUsername("PEPI");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameCantFindPersonByGivenNameBecauseOfCaseSensitiveMust() throws OperationNotSupportedException {
        this.database.findByUsername("ANI");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameCantFindPersonWithGivenId() throws OperationNotSupportedException {
        this.database.findById(120);
    }
}