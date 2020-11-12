import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.*;

public class CubeTest {
    @Before
    public void beforeTest() {
        System.out.println("Befor");
    }

    @Test
    public void cubeTestCase() {
        Cube c = new Cube();
        assertEquals(c.cube(1), 1);
        assertEquals(c.cube(2), 8);
    }

    @After
    public void afterTest() {
        System.out.println("After");
    }
}