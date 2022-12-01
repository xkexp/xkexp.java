package huawei.hj020;

import java.util.Scanner;

public class Main {

    private static final String OK = "OK";
    private static final String NG = "NG";

    /**
     * 密码验证合格程序
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String password = in.nextLine();

            if (!checkLength(password)) {
                System.out.println(NG);
                continue;
            }

            if (!checkType(password)) {
                System.out.println(NG);
                continue;
            }

            if (!checkDuplicate(password)) {
                System.out.println(NG);
                continue;
            }

            System.out.println(OK);
        }
    }

    private static boolean checkLength(String password) {
        return (password != null && password.length() > 8);
    }

    private static boolean checkType(String password) {
        int length = password.length();

        // 字符种类大于3
        int[] flags = new int[4];
        for (int i=0; i<length; i++) {
            char c = password.charAt(i);
            if ('A' <= c && c <= 'Z') {
                flags[0] = 1;
            }
            else if ('a' <= c && c <= 'z') {
                flags[1] = 1;
            }
            else if ('0' <= c && c <= '9') {
                flags[2] = 1;
            }
            else {
                flags[3] = 1;
            }
        }
        return (flags[0] + flags[1] + flags[2] + flags[3] >= 3);
    }

    private static boolean checkDuplicate(String password) {
        int length = password.length();

        // 不能有连续两个字符重复
        for (int i=0; i<length-4; i++) {
            for (int j=i+2; j<length-2; j++) {
                if ((password.charAt(i) == password.charAt(j))
                    && (password.charAt(i+1) == password.charAt(j+1))
                    && (password.charAt(i+2) == password.charAt(j+2))
                    ) {
                    return false;
                }
            }
        }
        return true;
    }
}
