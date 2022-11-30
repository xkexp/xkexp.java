package huawei.hj015;

import java.util.Scanner;

public class Main {
    /**
     * 求int型正整数在内存中存储时1的个数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int ret = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ret++;
            }
            n >>= 1;
        }

        System.out.println(ret);
    }
}
