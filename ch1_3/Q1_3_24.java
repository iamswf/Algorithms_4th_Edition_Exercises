/**
 * @file removeAfter()
 * @author Sun Wenfei(sunwenfei@baidu.com)
 * @date 2016-12-28
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_24 {
    Node<Integer> first; // Node.java中定义

    /**
     * 向链表中添加元素
     * @param item 待添加元素
     */
    public void addNode(int item) {
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
    public Node<Integer> search(int item) {
        Node<Integer> index = first;
        while (index != null) {
            if (index.item == item) {
                return index;
            }
            index = index.next;
        }
        return null;
    }

    /**
     * 删除node节点后序所有节点
     * @param  node 删除位置
     * @return      删除的节点
     */
    public void removeAfter(Node<Integer> node) {
        if (node == null || node.next == null) {
            return;
        }
        node.next = null;
    }

    public static void main(String[] args) {
        Q1_3_24 q = new Q1_3_24();
        q.addNode(1);
        q.addNode(2);
        q.addNode(3);
        q.addNode(4);
        q.printLink();
        Node<Integer> targetNode = q.search(2);
        q.removeAfter(targetNode);
        q.printLink();
    }
}