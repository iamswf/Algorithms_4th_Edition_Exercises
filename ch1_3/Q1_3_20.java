/**
 * @file 如果存在，删除链表第k个元素
 * @author iamswf@163.com
 * @date 2016-12-07
 */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_20 {
    private class Node {
        int item;
        Node next;
    }

    Node first;

     /**
     * 向链表中添加元素（从表头添加）
     * @param  item 待添加元素
     */
    public void addNode(int item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Node delete(int k) {
        if (k <= 0) return null;
        if (first == null) return null;
        // k == 1时
        if (k == 1) {
            Node kthNode = first;
            first = first.next;
            return kthNode;
        }
        // k > 1 时，找到第(k - 1)个节点
        Node current = first;
        for (int i = 1; i <= k - 2; i++) {
            current = current.next;
            if (current.next == null) return null; // 链表长度小于k的情况
        }
        Node kthNode = current.next;
        current.next = current.next.next;
        return kthNode;
    }

    public void printLink() {
        Node index = first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }

    public static void main(String[] args) {
        Q1_3_20 q = new Q1_3_20();
        int linkLength = 4;
        for (int i = 0; i < linkLength; i++) {
            q.addNode(i);
        }
        q.printLink();
        Node n = q.delete(1);
        if (n != null) {
            StdOut.println("删除的节点: " + n.item);
        }
        else {
            StdOut.println("删除的节点不存在!");
        }
        q.printLink();
    }
}