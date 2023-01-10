package huawei.hj044;

import java.util.Scanner;

/**
 * Sudoku
 * TODO: 广度优先搜索
 *
 * input:
 0 9 2 4 8 1 7 6 3
 4 1 3 7 6 2 9 8 5
 8 6 7 3 5 9 4 1 2
 6 2 4 1 9 5 3 7 8
 7 5 9 8 4 3 1 2 6
 1 3 8 6 2 7 5 9 4
 2 7 1 5 3 8 6 4 9
 3 8 6 9 1 4 2 5 7
 0 4 5 2 7 6 8 3 1
 * output:
 5 9 2 4 8 1 7 6 3
 4 1 3 7 6 2 9 8 5
 8 6 7 3 5 9 4 1 2
 6 2 4 1 9 5 3 7 8
 7 5 9 8 4 3 1 2 6
 1 3 8 6 2 7 5 9 4
 2 7 1 5 3 8 6 4 9
 3 8 6 9 1 4 2 5 7
 9 4 5 2 7 6 8 3 1
 */
public class Main {

    static final int WIDTH = 9;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 九宫格
        int sudoku[][] = new int[WIDTH][WIDTH];

        // 获取输入
        for (int i = 0; i < WIDTH; i++) {
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j < WIDTH; j++) {
                sudoku[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(sudoku);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(sudoku[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 深度搜索
     * @param sudoku 九宫格
     */
    private static boolean dfs(int[][] sudoku) {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k = 0; k < 9; k++) {
                        if (check(i, j, k+1, sudoku)) {
                            sudoku[i][j] = k+1;
                            if (dfs(sudoku)) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(int i, int j, int v, int[][] sudoku) {
        for (int k = 0; k < WIDTH; k++) {
            // 行
            if (v == sudoku[i][k]) {
                return false;
            }
            // 列
            if (v == sudoku[k][j]) {
                return false;
            }
        }

        // 单元格
        int x = (i / 3) * 3;
        int y = (j / 3) * 3;
        for (int m = x; m < x + 3; m++) {
            for (int n = y; n < y + 3; n++) {
                if (v == sudoku[m][n]) {
                    return false;
                }
            }
        }

        return true;
    }
}
