package huawei.hj016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 购物单
     * TODO: 动态规划问题
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 总钱数
        int n = in.nextInt();
        // 最多物品个数
        int m = in.nextInt();

        List<Item> items = new ArrayList<>();
        for (int i=0; i<m; i++) {
            Item item = new Item();
            item.v = in.nextInt();
            item.p = in.nextInt();
            item.q = in.nextInt();
            items.add(item);
        }

    }

    static class Item {
        // 价格
        int v;

        // 重要度
        int p;

        // 类别(0-主件,其他-附件)
        int q;

        // 满意度
        int getM() {
            return v * p;
        }
    }
}
