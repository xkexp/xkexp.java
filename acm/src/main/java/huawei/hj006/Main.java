package huawei.hj006;

import java.util.Scanner;

public class Main {
    /**
     * 质数因子
     * input : 180
     * output: 2 2 3 3 5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        final long MAX = (long) (2 * Math.pow(10, 9) + 14);
        if (n < 1 || n > MAX) {
            System.out.println("输入范围: (1, 2 * 10^9 + 14)");
            return;
        }

        int x = n;
        // 2-平方根除不尽视为质数
        int i = 2;
        while (i <= Math.sqrt(x)) {
            if (x % i == 0) {
                // 记录此质因数
                System.out.print(i);
                System.out.print(" ");
                x /= i;
            }
            else {
                i++;
            }
        }

        System.out.print(x);
    }
}
