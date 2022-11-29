package huawei.hj005;

import java.util.Scanner;

public class Main {
    /**
     * 进制转换
     * input : 0xAA
     * output: 170
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().toLowerCase();

        if (s.startsWith("0x")) {
            s = s.substring(2);
        }

        System.out.println(Integer.parseInt(s, 16));
    }
}
