package huawei.hj028;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 素数伴侣
     * TODO: 超时
     *
     * input
 22
 20923 22855 2817 1447 29277 19736 20227 22422 24712 27054 27050 18272 5477 27174 13880 15730 7982 11464 27483 19563 5998 16163
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] numbers = new int[count];
        for (int i=0; i<count; i++) {
            numbers[i] = in.nextInt();
        }

        int ret = analyse(0, count, numbers, new boolean[count]);
        System.out.println(ret);
    }

    private static int analyse(int depth, int count, int[] numbers, boolean[] flags) {
        int maxi = depth;
        for (int i=0; i<count; i++) {
            if (!flags[i]) {
                int maxj = maxi;
                for (int j=i+1; j<count; j++) {
                    if (!flags[j]) {
                        if (isMate(numbers[i], numbers[j])) {
                            boolean[] copyFlags = Arrays.copyOf(flags,count);
                            copyFlags[i] = true;
                            copyFlags[j] = true;
                            int d = analyse(depth + 1, count, numbers, copyFlags);
                            if (maxj < d) {
                                maxj = d;
                            }
                        }
                    }
                }

                if (maxi < maxj) {
                    maxi = maxj;
                }
            }
        }

        return maxi;
    }

    private static boolean isMate(int a, int b) {
        return isEven(a + b);
    }

    private static boolean isEven(int n) {
        // 2-平方根除不尽视为质数
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
//                n /= i;
                return false;
            }
            else {
                i++;
            }
        }

        return true;
    }

}
