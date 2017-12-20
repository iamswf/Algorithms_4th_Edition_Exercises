/**
 * @file reverse()
 * @author iamswf@163.com
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_30<T> {
    Node<T> first;

    /**
     * 向链表中添加元素
     * @param item 待添加元素
     */
    public void addNode(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldFirst;
    }

    /**
     * 打印链表
     */
    public void printLink() {
        Node<T> index = first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }

    /**
     * 反转链表
     */
    public Node<T> reverse() {
        if (first == null) return null;
        Node<T> index1 = first;
        Node<T> reverse = null;
        while (first != null) {
            Node<T> temp = first.next;
            first.next = reverse;
            reverse = first;
            first = temp;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Q1_3_30<String> q = new Q1_3_30<String>();
        q.addNode("a");
        q.addNode("b");
        q.addNode("c");
        q.addNode("d");
        q.addNode("e");
        q.printLink();
        Node<String> reverse = q.reverse();
        Node<String> index = reverse;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }
}