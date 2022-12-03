package huawei.hj032;

import java.util.Scanner;

public class Main {
    /**
     * 密码截取
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().trim().toCharArray();
        int length = line.length;

        int ret = 2;
        for (int i=0; i<length; i++) {
            for (int j=i+2; j<length; j++) {
                // 忽略串长度已经比已知小的
                if (j - i < ret) {
                    continue;
                }

                if (check(line, i, j)) {
                    ret = j - i + 1;
                }
            }
        }

        System.out.println(ret);
    }

    private static boolean check(char[] line, int i, int j) {
        int m = 0;
        while ((j-m) - (i+m) > 0) {
            // 对称位置不相等
            if (line[i+m] != line[j-m]) {
                return false;
            }
            m++;
        }

        return true;
    }
}
