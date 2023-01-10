package com.xkyii.exam.w3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        // 数组长度
        int n = Integer.parseInt(line1[0]);
        // 优雅阈值
        int k = Integer.parseInt(line1[1]);
        // 数组
        int[] numbers = new int[n];
        String[] line2 = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line2[i]);
        }

        // [i, j]如果是优雅数, 则[i, j+x]都是优雅数
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(i, j, k, numbers)) {
                    m += (n - j);
                    break;
                }
            }
        }
        System.out.println(m);
    }

    /**
     * 检查numbers子数组[i, j]是否k-优雅数组
     * @param i 起始序号
     * @param j 结束序号
     * @param k 优雅数
     * @param numbers 数组
     * @return 是否k-优雅数组
     */
    public static boolean check(int i, int j, int k, int[] numbers) {
        int m = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int p = i; p < j+1; p++) {
            int key = numbers[p];
            int v = map.getOrDefault(key, 0) + 1;
            map.put(key, v);
            if (v > m) {
                m = v;
            }
            if (m >= k) {
                return true;
            }
        }
//        System.out.printf("i=%d, j=%d, k=%d, b=%b%n", i, j, k, m>=k);
        return m >= k;
    }
}
