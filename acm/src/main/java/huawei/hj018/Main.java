package huawei.hj018;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    /**
     * 识别有效的IP地址和掩码并进行分类统计
     * input :  10.70.44.68~255.254.255.0
     *          1.0.0.1~255.0.0.0
     *          192.168.0.2~255.255.255.0
     *          19..0.~255.255.255.0
     * output: 1 0 1 0 0 2 1
     *
     * input :  0.201.56.50~255.255.111.255
     *          127.201.56.50~255.255.111.255
     * output: 0 0 0 0 0 0 0
     *
     * Ctrl + D 结束输入
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] ret = new int[7];

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line == null || line.isEmpty()) {
                return;
            }
            String[] split = line.split("\\~");
            long ip = parseIp(split[0]);
            // 错误ip
            if (ip < 0) {
                ret[5]++;
                continue;
            }

            // ip类型
            int ipType = getIpType(ip);
            // 忽略无效ip
            if (ipType < 0) {
                continue;
            }

            long mask = parseIp(split[1]);
            // 错误mask
            if (!isValidMask(mask)) {
                ret[5]++;
                continue;
            }

            // 在错误和忽略逻辑之后处理ip类型
            ret[ipType]++;

            // ip私有类型
            if (isPrivateIp(ip)) {
                ret[6]++;
            }
        }

        String s = Arrays.stream(ret).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(s);
    }

    /**
     * 将IP解析为unsigned int
     * -1 : 无效ip
     */
    private static long parseIp(String s) {
        String[] split = s.split("\\.");

        int ret = 0;
        try {
            for (int i=0; i<4; i++) {
                ret <<= 8;
                int n = Integer.parseInt(split[i]);
                if (n < 0) {
                    return -1;
                }
                if (n > 255) {
                    return -1;
                }
                ret ^= n;
            }
        }
        catch (Exception e) {
            return -1;
        }

        return ret & 0xFFFFFFFFL;
    }

    /**
     * 获得IP类型
     * -1 - 忽略
     *  0 - A类
     *  1 - B类
     *  2 - C类
     *  3 - D类
     *  4 - E类
     */
    private static int getIpType(long ip) {
        if (0x01000000L <= ip && ip <= 0x7EFFFFFFL) {
            return 0;
        }
        else if (0x80000000L <= ip && ip <= 0xBFFFFFFFL) {
            return 1;
        }
        else if (0xC0000000L <= ip && ip <= 0xDFFFFFFFL) {
            return 2;
        }
        else if (0xE0000000L <= ip && ip <= 0xEFFFFFFFL) {
            return 3;
        }
        else if (0xF0000000L <= ip && ip <= 0xFFFFFFFFL) {
            return 4;
        }
        else {
            return -1;
        }
    }

    /**
     * 是否私网ip
     */
    private static boolean isPrivateIp(long ip) {
        if (0x0A000000L <= ip && ip <= 0x0AFFFFFFL) {
            return true;
        }
        else if (0xAC100000L <= ip && ip <= 0xAC1FFFFFL) {
            return true;
        }
        else if (0xC0A80000L <= ip && ip <= 0xC0A8FFFFL) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 是否有效的掩码
     */
    private static boolean isValidMask(long mask) {
        if (mask == 0) {
            return false;
        }
        if (mask == 0xFFFFFFFFL) {
            return false;
        }

        boolean flag1 = false;

        String binary = Integer.toBinaryString((int) mask);
        for (int i=binary.length()-1; i>=0; i--) {
            char c = binary.charAt(i);
            if (c == '0') {
                if (flag1) {
                    return false;
                }
            }
            else { // '1'
                flag1 = true;
            }
        }

        return true;
    }
}
