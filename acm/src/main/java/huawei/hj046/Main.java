package huawei.hj046;

import java.util.Scanner;

public class Main {
    /**
     * 截取字符串
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(in.nextLine().substring(0, in.nextInt()));
    }
}
