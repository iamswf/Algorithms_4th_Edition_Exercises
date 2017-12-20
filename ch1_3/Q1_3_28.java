/**
 * @file remove()
 * @author iamswf@163.com
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_28 {
    Node<Integer> first;

    /**
     * 向链表中添加元素
     * @param item 待添加元素
     */
    public void addNode(Integer item) {
        Node<Integer> oldFirst = first;
        first = new Node<Integer>();
        first.item = item;
        first.next = oldFirst;
    }

    /**
     * 打印链表
     */
    public void printLink() {
        Node<Integer> index = first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }

    /**
     * 查找节点
     */
    public Node<Integer> search(Integer item) {
        Node<Integer> index = first;
        while (index != null) {
            if (index.item == item) {
                return index;
            }
            index = index.next;
        }
        return null;
    }

    public int max() {
        if (first == null) return 0;
        int value = first.item;
        Node<Integer> index = first.next;
        while (index != null) {
            if (index.item > value) {
                value = index.item;
            }
            index = index.next;
        }
        return value;
    }

    public int biggerValue(int value, Node<Integer> node) {
        if (node == null) {
            return value;
        }
        if (node.item > value) {
            return biggerValue(node.item, node.next);
        }
        return biggerValue(value, node.next);
    }

    public int recMax() {
        return biggerValue(0, first);
    }

    public static void main(String[] args) {
        Q1_3_28 q = new Q1_3_28();
        q.addNode(100);
        q.addNode(2);
        q.addNode(2);
        q.addNode(3);
        q.printLink();
        int recMaxValue = q.recMax();
        StdOut.println(recMaxValue);
    }
}