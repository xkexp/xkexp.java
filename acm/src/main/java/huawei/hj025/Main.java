package huawei.hj025;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * 数据分类处理
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 获得序列I
        List<String> I = new ArrayList<>();
        {
            int count = in.nextInt();
            for (int i=0; i<count; i++) {
                I.add(String.valueOf(in.nextInt()));
            }
        }

        // 获得序列R
        Set<Integer> R = new TreeSet<>();
        {
            int count = in.nextInt();
            for (int i=0; i<count; i++) {
                R.add(in.nextInt());
            }
        }

        // 分析数据
        List<Items> itemsList = new ArrayList<>();
        for (Integer r: R) {
            String s = String.valueOf(r);
            List<Item> items = new ArrayList<>();
            for (int i=0; i<I.size(); i++) {
                String value = I.get(i);
                if (value.contains(s)) {
                    items.add(new Item(i, value));
                }
            }

            if (!items.isEmpty()) {
                itemsList.add(new Items(s, items));
            }
        }

        // 输出
        if (itemsList.isEmpty()) {
            return;
        }
        System.out.print(itemsList.stream().mapToInt(Items::getCount).sum());
        System.out.print(" ");
        System.out.println(itemsList.stream().map(Items::toString).collect(Collectors.joining(" ")));
    }

    static class Item {
        int index;
        String value; // I

        public Item(int index, String value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%d %s", index, value);
        }
    }

    static class Items {
        String value; // R
        List<Item> items;

        public int getCount() {
            return 2 + items.size() * 2;
        }

        public Items(String value, List<Item> itemList) {
            this.value = value;
            this.items = itemList;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append(" ");
            sb.append(items.size());
            sb.append(" ");
            sb.append(items.stream().map(Item::toString).collect(Collectors.joining(" ")));
            return sb.toString();
        }
    }
}
