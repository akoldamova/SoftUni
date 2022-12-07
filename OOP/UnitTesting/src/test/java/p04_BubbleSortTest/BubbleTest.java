package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort(){
        int [] numbers = {1, 4, 20, 6, -5, 0, -20};
        int [] expected = {-20, -5, 0, 1, 4, 6, 20};
        Bubble.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

}