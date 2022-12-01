package huawei.hj027;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 查找兄弟单词
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        String[] strings = new String[count];
        for (int i=0; i<count; i++) {
            strings[i] = in.next();
        }
        String word = in.next();
        int index = in.nextInt() - 1;

        List<String> ret = new ArrayList<>(count);
        for (String s: strings) {
            if (isBrother(word, s)) {
                ret.add(s);
            }
        }

        Collections.sort(ret);

        System.out.println(ret.size());
        if (index < ret.size()) {
            System.out.println(ret.get(index));
        }
    }

    private static boolean isBrother(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }

        int length = a.length();
        if (length != b.length()) {
            return false;
        }

        if (a.equals(b)) {
            return false;
        }

        char[] chars = b.toCharArray();
        for (int i=0; i<length; i++) {
            char c = a.charAt(i);

            for (int j=0; j<length; j++) {
                if (c == chars[j]) {
                    chars[j] = 0;
                    break;
                }
            }
        }

        for (int i=0; i<length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
