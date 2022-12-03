package huawei.hj057;

import java.util.Scanner;

public class Main {
    /**
     * 高精度整数加法
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int length = Math.max(s1.length(), s2.length());

        // 反转并补零
        // 如: s1=1234, s2=56, 则a=4321, b=6500
        char[] a = reverse(s1, length);
        char[] b = reverse(s2, length);

//        System.out.println(new String(a));
//        System.out.println(new String(b));

        char[] ret = new char[length+1];

        int k = 0; // 进位
        for (int i=0; i<length; i++) {
            int x = a[i] - '0';
            int y = b[i] - '0';
            int z = x + y + k;
            if (z > 9) {
                k = 1;
                z -= 10;
            }
            else {
                k = 0;
            }
            ret[i] = (char) (z + '0');
        }

        // 最高位
        ret[length] = (char) (k + '0');

        // 输出
        if (ret[length] == '1') {
            System.out.print(ret[length]);
        }
        for (int i=length-1; i>=0; i--) {
            System.out.print(ret[i]);
        }
    }

    private static char[] reverse(String s, int length) {
        int slen = s.length();
        assert (length >= slen);

        char[] ret = new char[length];

        int j = 0;
        for (int i=slen-1; i>=0; i--, j++) {
            ret[i] = s.charAt(j);
        }

        while (j < length) {
            ret[j++] = '0';
        }

        return ret;
    }
}
