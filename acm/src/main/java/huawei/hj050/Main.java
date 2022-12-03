package huawei.hj050;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * 表达式求值
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] chars = in.nextLine().toCharArray();
            System.out.println(eval(chars, 0, chars.length-1));
        }
    }

    private static int eval(char[] s, int left, int right) {
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = left; i <= right; i++) {
            char c = s[i];
            // 数字
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 内部表达式
            if (isLeftBracket(c)) {
                int j = i+1;
                int layer = 1; // 已经匹配到一个了
                while (j <= right) {
                    if (isLeftBracket(s[j])) {
                        layer++;
                    }
                    else if (isRightBracket(s[j])) {
                        layer--;
                        // 对应的匹配
                        if (layer == 0) {
                            break;
                        }
                    }
                    j++;
                }
                num = eval(s, i+1, j-1);
                i = j;
            }

            // 终结一次操作
            if (!isDigit(c) || i == right) {
                switch (op) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(stack.pop() * num);
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                    default:
                        break;
                }

                // 记录下个操作符
                op = c;
                // 重置临时数
                num = 0;
            }

            // 忽略其他
            else {

            }
        }

        int sum = stack.stream().mapToInt(x -> x).sum();
        return sum;
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isLeftBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isRightBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }
}
