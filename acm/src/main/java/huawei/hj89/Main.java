package huawei.hj89;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    /**
     * 24点运算
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().toUpperCase();
        if (line.contains("JOKER")) {
            System.out.println("ERROR");
            return;
        }

        // 获得输入
        String[] s = line.split(" ");
        assert (s.length == 4);
        for (int i = 0; i < 4; i++) {
            cards[i] = card2Number(s[i]);
        }

        if (!dfs(0, 0)) {
            System.out.println("NONE");
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i>0) {
                System.out.print(ops[i]);
            }
            System.out.print(dict[result[i]]);
        }
    }

    private static int card2Number(String s) {
        if (Objects.equals(s, "A")) {
            return 1;
        }
        else if (Objects.equals(s, "10")) {
            return 10;
        }
        else if (Objects.equals(s, "J")) {
            return 11;
        }
        else if (Objects.equals(s, "Q")) {
            return 12;
        }
        else if (Objects.equals(s, "K")) {
            return 13;
        }
        else {
            return Integer.parseInt(s);
        }
    }

    final static String[] dict = { "0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    // 记录的牌
    private static boolean[] visit = new boolean[4];
    // 读入的牌
    private static int[] cards = new int[4];
    // 记录结果
    private static int[] result = new int[4];
    // 记录每一步的操作
    private static char[] ops = new char[4];

    // 搜索
    private static boolean dfs(int index, int sum) {
        // 终结
        if (index >= 4) {
            return (sum == 24);
        }

        for (int i = 0; i < 4; i++) {
            if (!visit[i]) {
                visit[i] = true;

                if (dfs(index+1, ((index == 0) ? 0 : sum) + cards[i])) {
                    ops[index] = '+';
                    result[index] = cards[i];
                    return true;
                }
                if (dfs(index+1, ((index == 0) ? 0 : sum) - cards[i])) {
                    ops[index] = '-';
                    result[index] = cards[i];
                    return true;
                }
                if (dfs(index+1, ((index == 0) ? 1 : sum) * cards[i])) {
                    ops[index] = '*';
                    result[index] = cards[i];
                    return true;
                }
                if (((index == 0) ? 1 : sum) % cards[i] == 0) {
                    if (dfs(index+1, ((index == 0) ? 1 : sum) / cards[i])) {
                        ops[index] = '/';
                        result[index] = cards[i];

                        return true;
                    }
                }

                visit[i] = false;
            }
        }

        return false;
    }
}