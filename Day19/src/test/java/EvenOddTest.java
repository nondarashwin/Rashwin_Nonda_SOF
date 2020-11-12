import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class EvenOddTest extends TestCase {
    @Test
    public void testEvenOdd() {
        EvenOdd evenOdd = new EvenOdd();
        assertEquals("Even", evenOdd.evenOdd(2));
    }

    @Test
    public void testEvenOdd1() {
        EvenOdd evenOdd = new EvenOdd();
        assertEquals("Even", evenOdd.evenOdd(4));
    }

    @Test
    public void testEvenOdd2() {
        EvenOdd evenOdd = new EvenOdd();
        assertEquals("Odd", evenOdd.evenOdd(1));
    }

    @Test
    public void testEvenOdd3() {
        EvenOdd evenOdd = new EvenOdd();
        assertEquals("Odd", evenOdd.evenOdd(5));
    }

    @Test
    public void testEvenOdd4() {
        EvenOdd evenOdd = new EvenOdd();
        assertEquals("Impossible", evenOdd.evenOdd(-1));
    }

    @Test
    public void testNumbers() {
        EvenOdd evenOdd = new EvenOdd();
        assertArrayEquals(new String[]{"yes", "no"}, evenOdd.strinngConcat(new String[]{"yes"}, new String[]{"no"}));
    }

    @Test
    public void testNumbers1() {
        EvenOdd evenOdd = new EvenOdd();
        assertArrayEquals(new String[]{"yes", "no", "noooo"}, evenOdd.strinngConcat(new String[]{"yes"}, new String[]{"no", "noooo"}));
    }

    @Test
    public void testNumbers2() {
        EvenOdd evenOdd = new EvenOdd();
        assertArrayEquals(new String[]{"no", "noooo"}, evenOdd.strinngConcat(new String[]{}, new String[]{"no", "noooo"}));
    }
}