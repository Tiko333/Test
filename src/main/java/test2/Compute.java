package test2;

public class Compute {

    private Factorial factorial;

    public Compute(Factorial factorial) {
        this.factorial = factorial;
    }

    public double compute(double m, double r) {
        return factorial.getFactorial(m) / (factorial.getFactorial(r) * factorial.getFactorial(m - r));
    }
}
