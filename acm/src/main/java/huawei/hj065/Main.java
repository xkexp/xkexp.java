package huawei.hj065;

import java.util.Scanner;

public class Main {
    /**
     * 查找两个字符串a,b中的最长公共子串
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        if (a.length() > b.length()) {
            System.out.println(analyse(b, a));
        }
        else {
            System.out.println(analyse(a, b));
        }
    }

    private static String analyse(String min, String max) {
        int pos = 0;
        int count = 0;
        for (int i=0; i<min.length(); i++) {
            for (int j=i+1; j<min.length()+1; j++) {
                String sub = min.substring(i, j);
                if (max.contains(sub) && (count < (j-i))) {
                    pos = i;
                    count = j - i;
                }
            }
        }

        if (count == 0) {
            return "";
        }

        return min.substring(pos, pos+count);
    }

    private static String withDp(String s1, String s2) {
        // 记录长度
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLen = 0, startIdx = 0;
        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > maxLen) {
                        maxLen = dp[i+1][j+1];
                        startIdx = i - maxLen;
                    }
                }
            }
        }
        return s1.substring(startIdx + 1, startIdx+maxLen+1);
    }
}
