/**
 * @file insertAfter()
 * @author iamswf@163.com
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_25 {
    Node<Integer> first;

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
     * 在indexNode下个节点插入targetNode节点
     * @param indexNode  index
     * @param targetNode target
     */
    public void insertAfter(Node<Integer> indexNode, Node<Integer> targetNode) {
        if (indexNode == null || targetNode == null) return;
        targetNode.next = indexNode.next;
        indexNode.next = targetNode;
    }

    public static void main(String[] args) {
        Q1_3_25 q = new Q1_3_25();
        q.addNode(1);
        q.addNode(2);
        q.addNode(3);
        q.printLink();
        Node<Integer> indexNode = q.search(3);
        Node<Integer> targetNode = new Node<Integer>();
        targetNode.item = 25;
        q.insertAfter(indexNode, targetNode);
        q.printLink();
    }
}