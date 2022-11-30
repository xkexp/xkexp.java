package huawei.hj019;

import java.util.*;

public class Main {
    /**
     * 简单错误记录
     * input :
 D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 E:\je\rzuwnjvnuz 633
 C:\km\tgjwpb\gy\atl 637
 F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
 E:\ns\mfwj\wqkoki\eez 648
 D:\cfmwafhhgeyawnool 649
 E:\czt\opwip\osnll\c 637
 G:\nt\f 633
 F:\fop\ywzqaop 631
 F:\yay\jc\ywzqaop 631
 D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
     * output:
 rzuwnjvnuz 633 1
 atl 637 1
 rwyfvzsopsuiqjnr 647 1
 eez 648 1
 fmwafhhgeyawnool 649 1
 c 637 1
 f 633 1
 ywzqaop 631 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Log> logs = new LinkedList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("")) {
                continue;
            }

            Log log = new Log();

            String[] s = line.split("\\s");
            log.line = Integer.parseInt(s[1]);
            log.file = parseFile(s[0]);
            log.count = 1;

            boolean isExisted = false;
            for (Log l: logs) {
                // 如果已经存在,数量加一
                if (l.line == log.line && l.file.equals(log.file)) {
                    l.count++;
                    isExisted = true;
                }
            }

            // 添加到链表最前面
            if (!isExisted) {
                logs.add(log);
            }
        }

        int size = logs.size();
        int count = Math.min(size, 8);
        for (int i=size-count; i<size; i++) {
            System.out.println(logs.get(i));
        }
    }

    private static String parseFile(String f) {
        if (f == null || f.isEmpty()) {
            return "";
        }
        String[] split = f.split("\\\\");
        String last = split[split.length-1];
        if (last.length() > 16) {
            return last.substring(last.length()-16);
        }
        return last;
    }

    static class Log {
        /**
         * 文件名
         */
        String file;
        /**
         * 行
         */
        int line;
        /**
         * 数量
         */
        int count;

        @Override
        public String toString() {
            return String.format("%s %d %d", file, line, count);
        }
    }
}
