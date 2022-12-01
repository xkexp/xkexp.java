package huawei.hj040;

import java.util.Scanner;

public class Main {
    /**
     * 统计字符
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();

        // 英文, 空格, 数字, 其他
        int[] counts = new int[4];
        for (int i=0; i<line.length; i++) {
            char c = line[i];
            if ('a' <= c && c <= 'z') {
                counts[0]++;
            }
            else if ('A' <= c && c <= 'Z') {
                counts[0]++;
            }
            else if (c == ' ') {
                counts[1]++;
            }
            else if ('0' <= c && c <= '9') {
                counts[2]++;
            }
            else {
                counts[3]++;
            }
        }

        for (int i=0; i<4; i++) {
            System.out.println(counts[i]);
        }
    }
}
