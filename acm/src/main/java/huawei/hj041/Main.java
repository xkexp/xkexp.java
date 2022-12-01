package huawei.hj041;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    /**
     * 称砝码
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 获取输入
        int count = in.nextInt();
        int[] marray = new int[count];
        int[] xarray = new int[count];
        for (int i = 0; i<count; i++) {
            marray[i] = in.nextInt();
        }
        for (int i=0; i<count; i++) {
            xarray[i] = in.nextInt();
        }

        Set<Integer> ret = new HashSet<>();
        for (int i=0; i<count; i++) {
            int m = marray[i]; // 重量
            int x = xarray[i]; // 数量
            // 同重量的可能
            Set<Integer> s1 = new HashSet<>();
            for (int j=1; j<=x; j++) {
                s1.add(m*j);
            }

            ret = merge(s1, ret);
        }

        ret.add(0);

        System.out.println(ret.size());
    }

    private static Set<Integer> merge(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> ret = new HashSet<>();
        ret.addAll(s1);
        ret.addAll(s2);

        for (Integer x: s1) {
            for (Integer y: s2) {
                ret.add(x+y);
            }
        }
        return ret;
    }
}
