package huawei.hj038;

import java.util.Scanner;

public class Main {
    /**
     * 求小球落地5次后所经历的路程和第5次反弹的高度
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final int t = 5;
        System.out.println(total(t) * n);
        System.out.println(single(t) * n);
    }

    /**
     *    1 + (1/2)*2 + (1/4)*2 + ...
     * =  1 + (1/2 + 1/4 + ...)*2
     * =  1 + (1 - 1/pow(2, i-3))*2
     * =  3 - 1/pos(2, i-2)
     */
    private static float total(int n) {
        return 3 - (1 / (float) Math.pow(2, n - 2));
    }

    private static float single(int n) {
        return 1 / (float) Math.pow(2, n);
    }
}
