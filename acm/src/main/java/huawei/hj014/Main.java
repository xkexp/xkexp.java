package huawei.hj014;

import java.util.*;

public class Main {
    /**
     * 字符串排序
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] array = new String[count];
        for (int i=0; i<count; i++) {
            array[i] = in.next();
        }

        Arrays.sort(array);

        for (int i=0; i<count; i++) {
            System.out.println(array[i]);
        }
    }
}
