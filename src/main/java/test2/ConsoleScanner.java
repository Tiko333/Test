package test2;

import java.util.Scanner;

public class ConsoleScanner implements test2.Scanner {

    private int m = 0;

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int r = 0;

        if (m == 0) {
            System.out.print("Input m: ");
            m = Integer.valueOf(scanner.nextLine());
            return m;
        } else {
            System.out.print("Input r: ");
            r = Integer.valueOf(scanner.nextLine());

            while (r >= m) {
                System.out.println("r must be lower than m=" + m);

                System.out.print("Input r: ");
                r = Integer.valueOf(scanner.nextLine());
            }

            return r;
        }
    }

}
