package huawei.hj034;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 图片整理
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        Arrays.sort(line);

        System.out.println(line);
    }
}
