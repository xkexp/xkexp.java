package huawei.hj051;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 输出单向链表中倒数第k个结点
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            // 获取输入
            int count = Integer.parseInt(in.nextLine());
            int[] values = Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(in.nextLine());
            assert (count == values.length);
            assert (k < count);

            // 构造链表
            ListNode root = new ListNode(0);
            ListNode node = root;
            for (int i=0; i<count; i++) {
                node.next = new ListNode(values[i]);
                node = node.next;
            }

            ListNode fast = root.next;
            for (int i=0; i<k; i++) {
                fast = fast.next;
            }

            ListNode slow = root.next;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(slow.value);
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int k) {
            this.value = k;
        }
    }
}
