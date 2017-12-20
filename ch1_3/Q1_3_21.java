/**
 * @file 查找链表是否含有字符串key
 * @author iamswf@163.com
 * @date 2016-12-28
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_21 {
    private class Node {
        String item;
        Node next;
    }

    Node first;

    /**
     * 向链表中添加元素（从表头添加）
     * @param item 待添加元素
     */
    public void addNode(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    /**
     * 打印链表
     */
    public void printLink() {
        Node index = first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }

    /**
     * 查找链表是否含有字符串key
     *
     * @param key 目标字符串
     */
    public boolean find(String key) {
        Node index = first;
        while (index != null) {
            if (key.equals(index.item)) {
                return true;
            }
            index = index.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Q1_3_21 q = new Q1_3_21();
        q.addNode("ab");
        q.addNode("cd");
        q.printLink();
        StdOut.println(q.find("ab"));
        StdOut.println(q.find("CD"));
    }
}