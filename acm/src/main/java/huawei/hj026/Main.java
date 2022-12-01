package huawei.hj026;

import java.util.Scanner;

public class Main {
    /**
     * 字符串排序
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        int length = line.length();

        char[] chars = line.toCharArray();
        char[] norms = line.toUpperCase().toCharArray();
        char[] ret = new char[length];

        for (int i=0; i<length; i++) {
            char ci = chars[i];
            if (('A' <= ci && ci <= 'Z') || ('a' <= ci && ci <= 'z')) {
                char min = 'Z' + 1;
                int minIndex = 0;
                for (int j = 0; j < length; j++) {
                    char cj = norms[j];
                    if ('A' <= cj && cj <= 'Z') {
                        if (min > cj) {
                            min = cj;
                            minIndex = j;
                        }
                    }
                }

                ret[i] = chars[minIndex];
                norms[minIndex] = 0;
            } else {
                ret[i] = chars[i];
                norms[i] = 0;
            }
        }

        for (int i=0; i<length; i++) {
            System.out.print(ret[i]);
        }
    }
}
