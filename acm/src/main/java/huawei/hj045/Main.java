package huawei.hj045;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 名字的漂亮度
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        for (int u=0; u<count; u++) {

            char[] line = in.nextLine().trim().toCharArray();
            int[] counts = new int[line.length];

            int index = 0;
            for (int i=0; i<line.length; i++) {
                char c = line[i];
                if (c == 0) {
                    continue;
                }
                for (int j=i+1; j<line.length; j++) {
                    if (line[i] == line[j]) {
                        counts[index]++;
                        line[j] = 0;
                    }
                }
                counts[index]++;
                index++;
            }

            Arrays.sort(counts);

            int total = 0;
            for (int i=line.length-1, score = 26; i>=line.length-index; i--, score--) {
                total += counts[i] * score;
            }

//            System.out.println(new String(line));
            System.out.println(total);
        }


    }
}
