package huawei.hj022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 0) {
                break;
            }

            System.out.println(calc(num));
        }
    }

    public static int calc(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int x = n / 3;
        int y = n % 3;
        return x + calc(x+y);
    }
}
