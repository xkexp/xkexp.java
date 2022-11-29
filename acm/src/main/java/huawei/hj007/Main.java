package huawei.hj007;

import java.util.Scanner;

public class Main {
    /**
     * 取近似值
     * input : 5.5
     * output: 6
     *
     * input : 5.499
     * output: 5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double n = in.nextDouble();

        if (n <= 0) {
            System.out.print("n > 0");
            return;
        }


        double m = n - Math.floor(n);
        if (m >= 0.5) {
            System.out.print((int) Math.ceil(n));
        }
        else {
            System.out.print((int) Math.floor(n));
        }
    }
}
