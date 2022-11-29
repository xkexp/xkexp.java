package huawei.hj003;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    /**
     * input : 3
     *       : 2
     *       : 2
     *       : 1
     * output: 1
     *       : 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Integer> set = new TreeSet<>();
        int count = in.nextInt();
        for (int i=0; i<count; i++) {
            set.add(in.nextInt());
        }

        for (Integer i: set) {
            System.out.println(i);
        }
    }
}