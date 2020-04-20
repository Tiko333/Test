package test2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComputeTest {

    @Mock
    private FactorialImpl factorial;

    @Test
    public void run() {
        Compute compute = new Compute(factorial);

        Mockito.when(factorial.getFactorial(5)).thenReturn(120);
        Mockito.when(factorial.getFactorial(2)).thenReturn(2);
        Mockito.when(factorial.getFactorial(3)).thenReturn(6);

        double compute1 = compute.compute(5, 2);
        Assert.assertEquals(10, compute1, 1e-8);
    }
}