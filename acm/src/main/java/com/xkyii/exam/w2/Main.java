package com.xkyii.exam.w2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 获取输入
        int count = Integer.parseInt(in.nextLine());
        int useTime[][] = new int[count][count];
        for (int i = 0; i < count; i++) {
            String[] splits = in.nextLine().split(" ");
            for (int j = 0; j < count; j++) {
                useTime[i][j] = Integer.parseInt(splits[j]);
            }
        }
        int k = Integer.parseInt(in.nextLine()) - 1;

        System.out.println(weightOf(k, count, useTime));
    }

    /**
     * 计算k容器启动权重
     * TODO: 缓存优化
     *
     * @param k 第k个容器
     * @param count 容器总数
     * @param useTime 时间表
     * @return 启动权重
     */
    private static int weightOf(int k, int count, int[][] useTime) {
        int m = 0;
        for (int j = 0; j < count; j++) {
            if (j == k) {
                continue;
            }
            if (useTime[k][j] != 0) {
                int w = weightOf(j, count, useTime);
                if (w > m) {
                    m = w;
                }
            }
        }
        return useTime[k][k] + m;
    }
}
