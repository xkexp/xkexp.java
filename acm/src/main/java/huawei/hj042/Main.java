package huawei.hj042;

import java.util.Scanner;

public class Main {
    /**
     * 学英语
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Digit(in.nextLong()));

//        System.out.println(new Digit(1));
//        System.out.println(new Digit(11));
//        System.out.println(new Digit(111));
//        System.out.println(new Digit(121));
//        System.out.println(new Digit(601));
//        System.out.println(new Digit(60830));

//        System.out.println(new Digit(1000));
//        System.out.println(new Digit(2011));
    }

    static class Digit {
        long original;
        private Seg seg0; //
        private Seg seg1; // 千段
        private Seg seg2; // 百万段
        private Seg seg3; // 亿段

        public Digit(long x) {
            original = x;

            seg0 = new Seg((int) (x % 1000));
            x /= 1000;
            if (x == 0) {
                return;
            }

            seg1 = new Seg((int) (x % 1000));
            x /= 1000;
            if (x == 0) {
                return;
            }

            seg2 = new Seg((int) (x % 1000));
            x /= 1000;
            if (x == 0) {
                return;
            }

            seg3 = new Seg((int) (x % 1000));
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();

            boolean higher = false;

            if (seg3 != null && !seg3.isZero()) {
                sb.append(seg3);
                sb.append(" billion");
                higher = true;
            }

            if (seg2 != null && !seg2.isZero()) {
                if (higher) {
                    sb.append(" ");
                }
                else {
                    higher = true;
                }
                sb.append(seg2);
                sb.append(" million");
            }

            if (seg1 != null && !seg1.isZero()) {
                if (higher) {
                    sb.append(" ");
                }
                else {
                    higher = true;
                }
                sb.append(seg1);
                sb.append(" thousand");
            }

            if (seg0 != null && !seg0.isZero()) {
                if (higher) {
                    sb.append(" ");
                }
                sb.append(seg0);
            }

            return sb.toString();
        }
    }

    static String[] Segs0 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                               "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    static String[] Segs1 = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    static class Seg {
        private int x0; // 个位 1-19
        private int x1; // 十位 2-9
        private int x2; // 百位 0-9

        public Seg(int x) {
            assert (x >= 0);
            assert (x < 1000);
            if (x == 0) {
                return;
            }

            x2 = x / 100;
            x %= 100;

            if (x < 20) {
                x0 = x;
                x1 = 0;
            }
            else {
                x1 = x / 10;
                x0 = x % 10;
            }
        }

        public boolean isZero() {
            return (x0 == 0) && (x1 == 0) && (x2 == 0);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (x2 > 0) {
                sb.append(Segs0[x2]);
                sb.append(" hundred");
            }
            if (x2 > 0 && (x1 > 0 || x0 > 0)) {
                sb.append(" and");
            }
            if (x1 > 0) {
                if (x2 > 0) {
                    sb.append(" ");
                }
                sb.append(Segs1[x1]);
            }
            if (x0 > 0) {
                if (x2 > 0 || x1 > 0) {
                    sb.append(" ");
                }
                sb.append(Segs0[x0]);
            }

            return sb.toString();
        }
    }
}
