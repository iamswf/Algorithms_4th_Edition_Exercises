/**
 * @file remove()
 * @author iamswf@163.com
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_27 {
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

    public static void main(String[] args) {
        Q1_3_27 q = new Q1_3_27();
        q.addNode(100);
        q.addNode(2);
        q.addNode(2);
        q.addNode(3);
        q.printLink();
        int maxValue = q.max();
        StdOut.println(maxValue);
    }
}