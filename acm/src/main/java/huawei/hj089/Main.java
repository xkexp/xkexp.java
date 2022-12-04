package huawei.hj089;

import java.util.Scanner;

public class Main {
    /**
     * 自动售货系统
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Shop shop = new Shop();
        for (String s : line.split(";")) {
            try {
                switch (s.charAt(0)) {
                    case 'r': shop.r(s.substring(2)); break;
                    case 'p': shop.p(Integer.parseInt(s.substring(2))); break;
                    case 'b': shop.b(s.substring(2)); break;
                    case 'c': shop.c(); break;
                    case 'q': shop.q(Integer.parseInt(s.substring(2))); break;
                    default: break;
                }
            }
            catch (Exception e) {
                System.out.println("E010:Parameter error");
            }
        }
    }

    /**
     * 商城
     */
    static class Shop {
        /**
         * 商品列表
         */
        Item[] items = new Item[] {
            new Item("A1", 2),
            new Item("A2", 3),
            new Item("A3", 4),
            new Item("A4", 5),
            new Item("A5", 8),
            new Item("A6", 6),
        };

        /**
         * 钱币列表
         */
        Money[] monies = new Money[] {
            new Money(1),
            new Money(2),
            new Money(5),
            new Money(10),
        };

        /**
         * 用户余额(假定只有一个用户)
         */
        int balance;

        /**
         * 初始化
         */
        public void r(String s) {
//            System.out.println("r " + s);

            String[] split = s.split("[-\\s]");
            for (int i = 0; i < items.length; i++) {
                items[i].count = Integer.parseInt(split[i]);
            }
            for (int i = 0; i < monies.length; i++) {
                monies[i].count = Integer.parseInt(split[i+items.length]);
            }

            System.out.println("S001:Initialization is successful");
        }

        /**
         * 投币
         * @param n 面额
         */
        public void p(int n) {
//            System.out.println("p " + n);

            // 校验面额有效性
            int index = -1;
            for (int i = 0; i < monies.length; i++) {
                if (n == monies[i].number) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("E002:Denomination error");
                return;
            }

            // 校验余额
            if (n > 2 && n > getMoneyAmountOf1And2()) {
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }

            if (isItemsEmpty()) {
                System.out.println("E005:All the goods sold out");
                return;
            }

            balance += n;
            monies[index].count++;
            System.out.println(String.format("S002:Pay success,balance=%d", balance));
        }

        /**
         * 购买
         * @param s 商品名
         */
        public void b(String s) {
//            System.out.println("b " + s);
            boolean isExist = false;
            for (int i = 0; i < items.length; i++) {
                Item item = items[i];
                if (s.equals(item.name)) {
                    isExist = true;
                    if (item.count == 0) {
                        System.out.println("E007:The goods sold out");
                        break;
                    }
                    if (balance < item.price) {
                        System.out.println("E008:Lack of balance");
                        break;
                    }

                    balance -= item.price;
                    item.count--;
                    System.out.println(String.format("S003:Buy success,balance=%d", balance));
                }
            }

            if (!isExist) {
                System.out.println("E006:Goods does not exist");
            }
        }

        /**
         * 退币
         */
        public void c() {
//            System.out.println("c");

            if (balance <= 0) {
                System.out.println("E009:Work failure");
                return;
            }

            int b = balance;
            Money[] temp = new Money[] { new Money(1), new Money(2), new Money(5), new Money(10) };
            for (int i = monies.length-1; i >= 0 ; i--) {
                Money m = monies[i];
                Money t = temp[i];
                while (b >= m.number && m.count > 0) {
                    b -= m.number;
                    m.count--;
                    t.count++;
                }
            }

            balance = 0;

            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i]);
            }
        }

        /**
         * 查询
         * @param type 0-查询商品信息, 1-查询存钱盒信息
         */
        public void q(int type) {
//            System.out.println("q " + type);
            if (type == 0) {
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            }
            else if (type == 1) {
                for (int i = 0; i < monies.length; i++) {
                    System.out.println(monies[i]);
                }
            }
            else {
                // never come here.
            }
        }

        /**
         * 获取面额为1和2的总额
         * @return
         */
        private int getMoneyAmountOf1And2() {
            return monies[0].amount() + monies[1].amount();
        }

        /**
         * 是否所有物品为空
         */
        private boolean isItemsEmpty() {
            boolean b = true;
            for (int i = 0; i < items.length; i++) {
                // 物品存在
                if (items[i].count > 0) {
                    return false;
                }
            }
            return b;
        }
    }

    /**
     * 商品
     */
    static class Item {
        /**
         * 商品名
         */
        String name;
        /**
         * 单价
         */
        int price;
        /**
         * 数量
         */
        int count;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s %d %d", name, price, count);
        }
    }

    /**
     * 钱币
     */
    static class Money {
        /**
         * 面额
         */
        int number;
        /**
         * 数量
         */
        int count;

        public Money(int number) {
            this.number = number;
        }

        public int amount() {
            return number * count;
        }

        @Override
        public String toString() {
            return String.format("%d yuan coin number=%d", number, count);
        }
    }
}
