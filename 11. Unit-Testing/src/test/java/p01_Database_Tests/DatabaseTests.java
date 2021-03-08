package p01_Database_Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer[] numbers = {1, 2, 3, 4, 5, 6};
    private Database database;

    @Before
    public void setDatabaseField() throws OperationNotSupportedException {
        this.database = new Database(numbers);
    }

    @Test
    public void DBCreationTestShouldCreateObjectWithValidParameters() {
        Integer[] elements = this.database.getElements();

        Assert.assertEquals(numbers.length, elements.length);
    }

    @Test
    public void DBCreationTestShouldSetElementsInCorrectOrderAccordingToInitialParameters() {
        Integer[] elements = this.database.getElements();
        Assert.assertArrayEquals(numbers, elements);
    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void DBCreationTestShouldThrowExceptionWithNullParameters() throws OperationNotSupportedException {
//     new Database();
//    }


    @Test(expected = OperationNotSupportedException.class)
    public void DBCreationTestShouldThrowExceptionWitMoreThanSixteenParameters() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddingNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void shouldAddElementAtFirstEmptyIndex() throws OperationNotSupportedException {
        this.database.add(42);

        Integer[] elements = this.database.getElements();

        int lastElement = elements[elements.length - 1];

        Assert.assertEquals(42, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenRemovingNullElement() throws OperationNotSupportedException {
        for (int i = 0; i < numbers.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }

    @Test
    public void shouldRemoveLastElement() throws OperationNotSupportedException {
        this.database.remove();

        Integer[] elements = this.database.getElements();

        Integer lastElement = elements[elements.length - 1];

        Assert.assertEquals(numbers[numbers.length - 2], lastElement);
    }
}
