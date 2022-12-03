package huawei.hj069;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = Integer.parseInt(in.nextLine());
        int y = Integer.parseInt(in.nextLine());
        int z = Integer.parseInt(in.nextLine());

        int[][] A = new int[x][y];
        int[][] B = new int[y][z];
        int[][] C = new int[x][z];

        for (int i = 0; i < x; i++) {
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j < y; j++) {
                A[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < y; i++) {
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j < z; j++) {
                B[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                int n = 0;
                for (int k = 0; k < y; k++) {
                    n += A[i][k] * B[k][j];
                }
                C[i][j] = n;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                System.out.print(C[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
