package huawei.hj055;

import java.util.Scanner;

public class Main {
    /**
     * 挑7
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(check7(in.nextInt()));
    }

    private static int check7(int n) {
        if (n < 7) {
            return 0;
        }

        int ret = 0;
        for (int i=7; i<=n; i++) {
            if (i % 7 == 0) {
                ret++;
                continue;
            }

            int k = i;
            while (k > 0) {
                if (k % 10 == 7) {
                    ret++;
                    break;
                }
                k /= 10;
            }
        }

        return ret;
    }
}
