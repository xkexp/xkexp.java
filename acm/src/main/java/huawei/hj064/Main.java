package huawei.hj064;

import java.util.Scanner;

public class Main {
    /**
     * MP3光标位置
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = Integer.parseInt(in.nextLine());
        String command = in.nextLine();

        Mp3List ml = new Mp3List(count);
        for (int i=0; i<command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'U' || c == 'u') {
                ml.up();
            }
            else if (c == 'D' || c == 'd') {
                ml.down();
            }
        }

        System.out.println(ml.showList());
        System.out.println(ml.showCurrent());
    }

    static class Mp3List {

        /**
         * 列表窗口大小
         */
        final static int WINDOW_SIZE = 4;

        /**
         * 列表(序号)
         */
        int[] indexes;

        /**
         * 光标当前位置(索引)[0, n]
         */
        int cursor_index;

        /**
         * 展示列表的首索引 [0, (n-4)]
         */
        int show_index;

        public Mp3List(int n) {
            this.indexes = new int[n];
            for (int i=0; i<n; i++) {
                this.indexes[i] = i+1;
            }
            this.cursor_index = 0;
            this.show_index = 0;
        }

        /**
         * 向上移动光标
         */
        public void up() {
            if (cursor_index == 0) {
                cursor_index = indexes.length - 1;
                if (indexes.length > WINDOW_SIZE) {
                    show_index = indexes.length - WINDOW_SIZE;
                }
            }
            else {
                cursor_index--;
                if (show_index > cursor_index) {
                    show_index = cursor_index;
                }
            }
        }

        /**
         * 向下移动光标
         */
        public void down() {
            if (cursor_index == indexes.length - 1) {
                cursor_index = 0;
                show_index = 0;
            }
            else {
                cursor_index++;
                if (show_index < cursor_index - WINDOW_SIZE + 1) {
                    show_index = cursor_index - WINDOW_SIZE + 1;
                }
            }
        }

        public String showList() {
            StringBuilder sb = new StringBuilder();

            for (int i=0; i<WINDOW_SIZE; i++) {
                if (i+show_index < indexes.length) {
                    sb.append(indexes[i+show_index]);
                    sb.append(" ");
                }
            }

            return sb.toString();
        }

        public int showCurrent() {
            return indexes[cursor_index];
        }
    }
}
