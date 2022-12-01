package huawei.hj030;

import java.util.Scanner;

public class Main {
    /**
     * 字符串合并处理
     * 60m
     *      1. 看错了反转
     *      2. f之后的字母不用处理
     *
     * input:
Eqr v9oEb12U2ur4xu7rd931G1f50qDo
     * output:
8084842CAE9B9G7D7BUFooqqrrrvuxu
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next() + in.next();
        int length = word.length();

        char[] chars = word.toCharArray();
        for (int i=0; i<length; i++) {
            // 分奇偶排序
            for (int j=i+2; j<length; j+=2) {
                if (chars[i] > chars[j]) {
                    // 交换
                    chars[i] ^= chars[j];
                    chars[j] ^= chars[i];
                    chars[i] ^= chars[j];
                }
            }
        }

//        System.out.println(new String(chars));

        for (int i=0; i<length; i++) {
            char c = chars[i];
            if ('a' <= c && c <= 'f') {
                chars[i] = reverse(c - 'a' + 10);
            }
            else if ('A' <= c && c <= 'F') {
                chars[i] = reverse(c - 'A' + 10);
            }
            else if ('0' <= c && c <= '9') {
                chars[i] = reverse(c - '0');
            }
        }

        System.out.println(new String(chars));
    }

    private static char reverse(int n) {
        // 反转
        int m = 0;
        for (int i=0; i<4; i++) {
            // 第i位不为0, 就填充到3-i的位置上
            if ((n & (1 << i)) != 0) {
                m += 1 << (3 - i);
            }
        }

        if (0 <= m && m <= 9) {
            return (char) ('0' + m);
        }
        else if (10 <= m && m <= 16) {
            return (char) ('A' + m - 10);
        }

        return ' ';
    }

}
