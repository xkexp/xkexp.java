package huawei.hj011;

import java.util.Scanner;

public class Main {
    /**
     * 数字颠倒
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        if (input < 0) {
            System.out.println("输入区间: [0, 2^30 -1]");
            return;
        }

        if (input == 0) {
            System.out.println(input);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (input > 0) {
            sb.append(input % 10);
            input /= 10;
        }

        System.out.println(sb);
    }
}
