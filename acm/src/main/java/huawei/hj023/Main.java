package huawei.hj023;

import java.util.Scanner;

public class Main {

    /**
     * 删除字符串中出现次数最少的字符
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        if (line == null || line.isEmpty()) {
            return;
        }

        int[] counts = new int[26];

        int length = line.length();

        // 记录每个字母出现的次数
        for (int i=0; i<length; i++) {
            char c = line.charAt(i);
            int index = c - 97;

            counts[index]++;
        }

        // 记录最小的那个
        int min = length;
        for (int i=0; i<counts.length; i++) {
            if (counts[i] > 0 && min > counts[i]) {
                min = counts[i];
            }
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i=0; i<length; i++) {
            char c = line.charAt(i);
            int index = c - 97;

            if (counts[index] > 0 && counts[index] == min) {
                // ignore
            }
            else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
