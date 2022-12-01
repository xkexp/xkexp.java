package huawei.hj033;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    /**
     * 整数与IP地址间的转换
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String address = in.nextLine();
        long ip = in.nextLong();

        // x.x.x.x -> int
        {
            String[] split = address.split("\\.");
            long ret = 0;
            for (int i=0; i<4; i++) {
                short n = Short.parseShort(split[i]);
                ret <<= 8;
                ret += n;
            }

            System.out.println(ret);
        }

        // int -> x.x.x.x
        {
            String[] ret = new String[4];
            for (int i=0; i<4; i++) {
                ret[i] = String.valueOf((ip >> ((3-i)*8)) & 0xFF);
            }
            System.out.println(String.join(".", ret));
        }
    }
}
