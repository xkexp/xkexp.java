package huawei.hj009;

import java.util.Scanner;

public class Main {
    /**
     * 提取不重复的整数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();

        int ret = 0;
        int mask = 0;
        while (input > 0) {
            int a = input % 10;
            int shift = (1 << a);
            if ((mask & shift) == shift) {
                input /= 10;
                continue;
            }
            mask |= shift;

            input /= 10;

            ret = ret * 10 + a;
        }

        System.out.println(ret);
    }
}
