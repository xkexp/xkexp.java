package huawei.hj059;

import java.util.Scanner;

public class Main {
    /**
     * 找出字符串中第一个只出现一次的字符
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();

        int[] t = new int[256];

        for (int i=0; i<s.length; i++) {
            t[s[i]]++;
        }

        boolean none = true;
        for (int i=0; i<s.length; i++) {
            if (t[s[i]] == 1) {
                System.out.print(s[i]);
                none = false;
                break;
            }
        }

        if (none) {
            System.out.print(-1);
        }
    }
}
