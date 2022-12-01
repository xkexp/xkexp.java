package huawei.hj035;

import java.util.Scanner;

public class Main {
    /**
     * 蛇形矩阵
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // 矩阵
        int[][] ret = new int[N][N];
        int count = N * (N+1) / 2;
        int x = 0;
        int y = 0;
        ret[x][y] = 1;
        for (int i=2; i<=count; i++) {
            // 尝试填充右上角
            x++;
            y--;
            // 如果进入y负区间,则转化到y轴
            if (y == -1) {
                y = x;
                x = 0;
            }
            ret[y][x] = i;
        }

        // 输出
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-i; j++) {
                System.out.print(ret[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
