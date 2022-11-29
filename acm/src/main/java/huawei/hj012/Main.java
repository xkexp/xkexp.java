package huawei.hj012;

import java.util.Scanner;

public class Main {
    /**
     * 字符串反转
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int count = s.length();
        for (int i=0; i<count; i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') {
                System.out.println("请输入小写字符串.");
                return;
            }
        }

        StringBuilder sb = new StringBuilder(count);
        for (int i=count-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}
