package huawei.hj017;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * 坐标移动
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Pattern pattern = Pattern.compile("([WASD])(\\d{1,2})");
        String[] split = line.split(";");
        int x = 0;
        int y = 0;
        for (String s: split) {
            Matcher m = pattern.matcher(s);
            if (!m.matches()) {
                continue;
            }

            char direction = m.group(1).charAt(0);
            int step = Integer.parseInt(m.group(2));

            switch (direction) {
                case 'W':
                    y += step;
                    break;
                case 'S':
                    y -= step;
                    break;
                case 'A':
                    x -= step;
                    break;
                case 'D':
                    x += step;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d,%d%n", x, y);
    }
}
