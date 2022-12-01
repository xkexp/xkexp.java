package huawei.hj037;

import java.util.Scanner;

public class Main {
    /**
     * 统计每个月兔子的总数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextInt()));
    }

    private static int calc(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        // 1. 兔子不会死,上个月的兔子都在
        // 2. 其中上上个月的兔子是有生育能力的,每兔生一只
        return calc(n - 1) + calc(n - 2);
    }
}
