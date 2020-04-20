package test2;

public class Runner2 {

    public static void main(String[] args) {
        Scanner scanner = new ConsoleScanner();

        double m = scanner.getNumber();
        double r = scanner.getNumber();

        Compute compute = new Compute(new FactorialImpl());
        System.out.println("m! / (r! * (m - r)!) = " + compute.compute(m, r));
    }
}
