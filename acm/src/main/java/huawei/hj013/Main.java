package huawei.hj013;


import java.util.Scanner;

public class Main {
    /**
     * 句子逆序
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        if (s == null || s.isEmpty()) {
            return;
        }

        String[] split = s.split("\\s");

        for (int i=split.length-1; i>0; i--) {
            System.out.print(split[i]);
            System.out.print(" ");
        }

        System.out.println(split[0]);
    }
}
