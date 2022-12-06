package huawei.hj028;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
        // 遍历计算
        for (int i = 0; i < odds.size(); i++) {
            if (find(i, 0, odds, evens, evenMates)) {
                ret++;
            }
        }

        System.out.println(ret);
    }

    /**
     * 寻找奇数在偶数列表的伴侣
     * @param oddIndex 奇数序号
     * @param evenIndex 偶数序号
     * @param evens 偶数列表
     * @param evenMates 偶数的伴侣
     * @return 是否找到伴侣
     */
    private static boolean find(int oddIndex, int evenIndex, List<Integer> odds, List<Integer> evens, int[] evenMates) {
        Integer odd = odds.get(oddIndex);
        for (int j = evenIndex; j < evens.size(); j++) {
            Integer even = evens.get(j);
            // 可以成为伴侣
            if (isPrime(odd + even)) {
                // 如果偶数还没有伴侣
                Integer mate = evenMates[j];
                if (mate == 0) {
                    evenMates[j] = oddIndex;
                    return true;
                }
                // 对方已经有伴侣,让他换一个,evenIndex及之前的都判断过了,从evenIndex开始
                if (find(mate, evenIndex+1, odds, evens, evenMates)) {
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
                return false;
            }
        }
        return true;
    }
}
