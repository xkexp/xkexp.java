package huawei.hj036;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] key = in.nextLine().trim().toUpperCase().toCharArray();
        String txt = in.nextLine();

        // 初始密码本
        int[] book = new int[26+key.length];
        for (int i=0; i<book.length; i++) {
            if (i < key.length) {
                book[i] = -1;
            }
            else {
                book[i] = i - key.length;
            }
        }

        int index = 0;
        for (int i=0; i<key.length; i++) {
            // 去重时可能将值置空
            if (key[i] == 0) {
                continue;
            }

            // 去重
            for (int j=i+1; j<key.length; j++) {
                if (key[j] == 0) {
                    continue;
                }
                if (key[i] == key[j]) {
                    key[j] = 0;
                }
            }

            int v = key[i] - 'A';
            // 填入密码本
            book[index++] = v;
            // 去掉原始密码本的对应值
            book[key.length + v] = -1;
        }

        // 最终密码本
        index = 0;
        for (int i=0; i<26+key.length; i++) {
            if (book[i] == -1) {
                continue;
            }

            book[index++] = book[i];
        }

//        for (int i=0; i<26; i++) {
//            System.out.print((char) (book[i] + 'A'));
//        }

        for (int i=0; i<txt.length(); i++) {
            char c = txt.charAt(i);
            if ('a' <= c && c <= 'z') {
                System.out.print((char) ('a' + book[c - 'a']));
            }
            else if ('A' <= c && c <= 'Z') {
                System.out.print((char) ('A' + book[c - 'A']));
            }
            else {
                System.out.print(c);
            }
        }
    }
}
