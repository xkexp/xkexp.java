package huawei.hj039;

import java.util.Scanner;

public class Main {
    final static int INVALID = -1;
    final static int ERROR = 1;
    final static int YES = 0;
    final static int NO = 2;

    /**
     * 判断两个IP是否属于同一子网
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String sm = in.nextLine();
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            long mask = a2i(sm);
            if (!isValidMask(mask)) {
                System.out.println(ERROR);
                continue;
            }
            long ip1 = a2i(s1);
            if (ip1 == INVALID) {
                System.out.println(ERROR);
                continue;
            }
            long ip2 = a2i(s2);
            if (ip2 == INVALID) {
                System.out.println(ERROR);
                continue;
            }

            if ((ip1 & mask) == (ip2 & mask)) {
                System.out.println(YES);
            }
            else {
                System.out.println(NO);
            }
        }
    }

    private static long a2i(String line) {
        String[] split = line.split("\\.");
        if (split.length != 4) {
            return INVALID;
        }

        long ret = 0;
        for (int i=0; i<4; i++) {
            int n = Integer.parseInt(split[i]);
            if (n < 0 || n > 255) {
                return INVALID;
            }

            if (i > 0) {
                ret <<= 8;
            }
            ret += (n & 0xFF);
        }

        return ret;
    }

    /**
     * 是否有效的掩码
     */
    private static boolean isValidMask(long mask) {
        if (mask <= 0) {
            return false;
        }
        if (mask == 0xFFFFFFFFL) {
            return false;
        }

        boolean flag1 = false;

        String binary = Integer.toBinaryString((int) mask);
        if (binary.length() != 32) {
            return false;
        }
        for (int i=binary.length()-1; i>=0; i--) {
            char c = binary.charAt(i);
            if (c == '0') {
                if (flag1) {
                    return false;
                }
            }
            else { // '1'
                flag1 = true;
            }
        }

        return true;
    }
}
