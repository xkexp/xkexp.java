package huawei.hj028;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int INVALID = -1;

    /**
     * 匈牙利算法
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 奇数
        List<Integer> odds = new ArrayList<>();
        // 偶数
        List<Integer> evens = new ArrayList<>();

        int count = Integer.parseInt(in.nextLine());
        String[] s = in.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(s[i]);
            if (n % 2 == 0) {
                evens.add(n);
            }
            else {
                odds.add(n);
            }
        }

        // 结果
        int ret = 0;
        // 偶数的伴侣
        int[] evenMates = new int[evens.size()];
        Arrays.fill(evenMates, INVALID);
        // 遍历计算
        for (int i = 0; i < odds.size(); i++) {
            boolean[] visit = new boolean[evens.size()];
            if (find(i, odds, evens, evenMates, visit)) {
                ret++;
            }
        }

        System.out.println(ret);
    }

    /**
     * 寻找奇数在偶数列表的伴侣
     * @param oddIndex 奇数序号
     * @param evens 偶数列表
     * @param evenMates 偶数的伴侣
     * @param visit 本轮偶数是否已经被匹配过
     * @return 是否找到伴侣
     */
    private static boolean find(int oddIndex, List<Integer> odds, List<Integer> evens, int[] evenMates, boolean[] visit) {
        Integer odd = odds.get(oddIndex);
        for (int j = 0; j < evens.size(); j++) {
            if (visit[j]) {
                continue;
            }
            Integer even = evens.get(j);
//            System.out.println(String.format("odd: %d, even: %d", odd, even));
            // 可以成为伴侣
            if (isPrime(odd + even)) {
                // 本轮搜索每个偶数只能匹配一次，且先到先得
                visit[j] = true;
                // 如果偶数还没有伴侣
                Integer mate = evenMates[j];
                if (mate == INVALID) {
                    evenMates[j] = oddIndex;
                    return true;
                }
                // 对方已经有伴侣,让他换一个
                if (find(mate, odds, evens, evenMates, visit)) {
                    evenMates[j] = oddIndex;
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * 判断是否素数
     * @param n 被判断的数
     * @return 是否素数
     */
    private static boolean isPrime(Integer n) {
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
//                System.out.printf("isPrime false: %d %d%n", n, i);
                return false;
            }
        }
        return true;
    }
}
