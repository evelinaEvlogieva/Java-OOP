package p04_BubbleSortTest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BubbleTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldSortElements() {
        int[] array = {42, 13, 7, 58};
        int[] expectedArray = {42, 13, 7, 58};

        Bubble.sort(array);

        Arrays.sort(expectedArray);

        assertArrayEquals(expectedArray, array);
    }
}