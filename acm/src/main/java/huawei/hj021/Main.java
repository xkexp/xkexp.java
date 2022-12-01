package huawei.hj021;

import java.util.Scanner;

public class Main {
    /**
     * 简单密码
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String password = in.nextLine();

        if (password == null || password.isEmpty()) {
            return;
        }

        String encoded = encode(password);
        System.out.println(encoded);
    }

    private static String encode(String password) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<password.length(); i++) {
            sb.append(encode(password.charAt(i)));
        }

        return sb.toString();
    }

    private static char encode(char c) {
        switch (c) {
            case 'a':
            case 'b':
            case 'c':
                return '2';
            case 'd':
            case 'e':
            case 'f':
                return '3';
            case 'g':
            case 'h':
            case 'i':
                return '4';
            case 'j':
            case 'k':
            case 'l':
                return '5';
            case 'm':
            case 'n':
            case 'o':
                return '6';
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return '7';
            case 't':
            case 'u':
            case 'v':
                return '8';
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return '9';
            case 'Z':
                return 'a';
            default:
                return encode2(c);
        }
    }

    /**
     * A - Y
     */
    private static char encode2(char c) {
        int delta = 'a' - 'A' + 1;
        if ('A' <= c && c < 'Z') {
            return (char) (c + delta);
        }
        return c;
    }

}
