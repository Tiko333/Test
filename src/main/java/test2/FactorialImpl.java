package test2;

public class FactorialImpl implements Factorial{
    @Override
    public int getFactorial(double number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }
}
