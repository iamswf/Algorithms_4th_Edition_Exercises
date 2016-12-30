/**
 * @file remove()
 * @author Sun Wenfei(sunwenfei@baidu.com)
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_26<T> {
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
     * 查找节点
     */
    public Node<T> search(T item) {
        Node<T> index = first;
        while (index != null) {
            if (index.item == item) {
                return index;
            }
            index = index.next;
        }
        return null;
    }

    /**
     * 在indexNode下个节点插入targetNode节点
     * @param indexNode  index
     * @param targetNode target
     */
    public void insertAfter(Node<T> indexNode, Node<T> targetNode) {
        if (indexNode == null || targetNode == null) return;
        targetNode.next = indexNode.next;
        indexNode.next = targetNode;
    }

    /**
     * 删除链表中所有含有item的节点
     */
    public void remove(T item) {
        // process first node
        while (first != null && item.equals(first.item)) {
            first = first.next;
        }
        // first has been elimited
        Node<T> index = first;
        while (index != null && index.next != null) {
            if (item.equals(index.next.item)) {
                index.next = index.next.next;
            }
            else {
                index = index.next;
            }
        }
    }

    public static void main(String[] args) {
        Q1_3_26<String> q = new Q1_3_26<String>();
        q.addNode("ab");
        q.addNode("cd");
        q.addNode("ab");
        q.addNode("cd");
        q.printLink();
        q.remove("ab");
        q.printLink();
    }
}