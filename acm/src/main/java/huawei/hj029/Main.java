package huawei.hj029;

import java.util.Scanner;

public class Main {
    /**
     * 字符串加解密 (15m)
 2OA92AptLq5G1lW8564qC4nKMjv8C
 B5WWIj56vu72GzRja7j5
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String plain = in.nextLine();
        String crypt = in.nextLine();

        System.out.println(encode(plain));
        System.out.println(decode(crypt));
    }

    private static String encode(String plain) {
        int length = plain.length();
        char[] chars = new char[length];

        for (int i=0; i<length; i++) {
            chars[i] = encode(plain.charAt(i));
        }

        return new String(chars);
    }

    private static char encode(char c) {
        if (c == 'z') {
            return 'A';
        }
        else if (c == 'Z') {
            return 'a';
        }
        else if ('a' <= c && c < 'z') {
            return (char) (c - 31);
        }
        else if ('A' <= c && c < 'Z') {
            return (char) (c + 33);
        }
        else if (c == '9') {
            return '0';
        }
        else if ('0' <= c && c < '9') {
            return (char) (c + 1);
        }
        else {
            return c;
        }
    }

    private static String decode(String crypt) {
        int length = crypt.length();
        char[] chars = new char[length];

        for (int i=0; i<length; i++) {
            chars[i] = decode(crypt.charAt(i));
        }

        return new String(chars);
    }

    private static char decode(char c) {
        if (c == 'A') {
            return 'z';
        }
        else if (c == 'a') {
            return 'Z';
        }
        else if ('a' < c && c <= 'z') {
            return (char) (c - 33);
        }
        else if ('A' < c && c <= 'Z') {
            return (char) (c + 31);
        }
        else if (c == '0') {
            return '9';
        }
        else if ('0' < c && c <= '9') {
            return (char) (c - 1);
        }
        else {
            return c;
        }
    }
}
