import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int sum = calculator.sum(10, 20);
        assertEquals(30, sum);
        sum = calculator.sum(20, 20);
        assertEquals(40, sum);
    }
}