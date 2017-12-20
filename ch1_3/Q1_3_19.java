/**
 * @file 删除链表尾节点，设首节点为first
 * @author iamswf@163.com
 * @date 2016-12-07
 */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_19 {
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

    public Node deleteLastNode() {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            Node lastNode = first;
            first = null;
            return lastNode;
        }
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        Node lastNode = current.next;
        current.next = null;
        return lastNode;
    }

    public static void main(String[] args) {
        Q1_3_19 q = new Q1_3_19();
        int linkLength = 5;
        for (int i = 0; i < linkLength; i++) {
            q.addNode(i);
        }
        Node index = q.first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
        Node n = q.deleteLastNode();
        if (n != null) {
            StdOut.println("删除的元素: " + n.item);
        }
        else {
            StdOut.println("链表本身为空链表，未删除任何元素!");
        }
        index = q.first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }
}