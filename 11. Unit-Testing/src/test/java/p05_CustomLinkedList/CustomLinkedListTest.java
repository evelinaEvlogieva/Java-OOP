package p05_CustomLinkedList;

import org.junit.Before;

import static org.junit.Assert.*;

public class CustomLinkedListTest<T> {
    private CustomLinkedList<T> list;

    @Before
    public void setUp()  {
        this.list = new CustomLinkedList<>();
    }
}