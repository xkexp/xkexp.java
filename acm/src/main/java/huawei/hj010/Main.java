package huawei.hj010;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    /**
     * 字符个数统计
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        Set<Character> set = new HashSet<>();
        int count = s.length();
        for (int i = 0; i < count; i++) {
            char c = s.charAt(i);
            if (c < 0 || c > 127) {
                continue;
            }
            if (!set.contains(c)) {
                set.add(c);
            }
        }

        System.out.println(set.size());
    }
}
