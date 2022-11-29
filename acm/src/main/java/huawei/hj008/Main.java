package huawei.hj008;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    /**
     * 合并表记录
     * 输入：
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     *
     * 输出：
     * 0 3
     * 1 2
     * 3 4
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // TreeMap对key排序,(HashMap没有)
        Map<Integer, Integer> map = new TreeMap<>();

        int count = in.nextInt();
        for (int i=0; i<count; i++) {
            int k = in.nextInt();
            int v = in.nextInt();
            map.put(k, map.getOrDefault(k, 0) + v);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.print(entry.getValue());
            System.out.print("\n");
        }

    }
}
