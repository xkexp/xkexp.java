package huawei.hj001;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    /**
     * input : hello newcoder
     * output: 8
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int i = s.lastIndexOf(' ');
        System.out.print(s.length() - i - 1);
    }
}