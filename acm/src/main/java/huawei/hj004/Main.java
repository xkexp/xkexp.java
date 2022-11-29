package huawei.hj004;

import java.util.Scanner;

public class Main {
    /**
     * input : abc
     * output: abc00000
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        if (s == null || s.isEmpty()) {
            return;
        }

        final int STEP = 8;

        int len = s.length();
        int count = len/STEP;

        for (int i=0; i<count; i++) {
            System.out.println(s.substring(i*STEP, (i+1)*STEP));
        }

        int remain = len % STEP;
        if (remain > 0) {
            StringBuilder sb = new StringBuilder(STEP);
            sb.append(s, len-remain, len);
            for (int i=0; i<STEP-remain; i++) {
                sb.append("0");
            }
            System.out.println(sb);
        }
    }
}
