package huawei.hj048;

import java.util.Scanner;

public class Main {
    /**
     * 从单向链表中删除指定值的节点
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] split = line.split("\\s");
        // 获取输入
        int count = Integer.parseInt(split[0])-1;
        int first = Integer.parseInt(split[1]);
        int[] nexts = new int[count];
        int[] values = new int[count];
        int index = 2;
        for (int i=0; i<count; i++) {
            nexts[i] = Integer.parseInt(split[index++]);
            values[i] = Integer.parseInt(split[index++]);
        }
        int remove = Integer.parseInt(split[index]);

        // 构造一个链表
        Node root = new Node();
        root.value = first;

        // 插入数据
        Node node;
        for (int i=0; i<count; i++) {
            int v = values[i];
            node = root;
            while (node != null) {
                if (node.value == v) {
                    Node n = new Node();
                    n.value = nexts[i];
                    n.next = node.next;
                    node.next = n;
                    break;
                }
                node = node.next;
            }
        }

        // 删除数据
        node = root;
        if (node.value == remove) {
            root = root.next;
        }
        else {
            while (node.next != null) {
                if (node.next.value == remove) {
                    node.next = node.next.next;
                    break;
                }
                else {
                    node = node.next;
                }
            }
        }

        node = root;
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null) {
                System.out.print(" ");
            }
            node = node.next;
        }
    }

    static class Node {
        int value;
        Node next;
    }
}
