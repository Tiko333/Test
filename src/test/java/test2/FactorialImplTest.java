package test2;

import org.junit.Assert;
import org.junit.Test;

public class FactorialImplTest {

    @Test
    public void getFactorialTest() {
        FactorialImpl factorial = new FactorialImpl();

        Assert.assertEquals(6, factorial.getFactorial(3));
        Assert.assertEquals(120, factorial.getFactorial(5));
    }

    @Test
    public void getFactorialFailTest() {
        FactorialImpl factorial = new FactorialImpl();

        Assert.assertNotEquals(50, factorial.getFactorial(7));
        Assert.assertNotEquals(120, factorial.getFactorial(11));
    }
}