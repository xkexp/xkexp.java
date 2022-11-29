package huawei.hj002;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    /**
     * input : ABCabc
     *       : A
     * output: 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        char c = Character.toUpperCase(in.nextLine().charAt(0));

        int count = 0;
        for (int i=0; i<s.length(); i++) {

            if (c == Character.toUpperCase(s.charAt(i))) {
                count++;
            }
        }

        System.out.print(count);
    }
}
