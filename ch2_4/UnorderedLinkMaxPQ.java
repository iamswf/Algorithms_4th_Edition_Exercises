package ch2_4;

import edu.princeton.cs.algs4.StdOut;

// 基于无序链表和栈实现
public class UnorderedLinkMaxPQ<T extends Comparable<T>> {
    private Node first;
    private int n;
    private class Node {
        T item;
        Node next;
    }

    public UnorderedLinkMaxPQ() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null; // 或: n == 0
    }

    public int size() {
        return n;
    }

    // 添加元素到栈顶
    public void insert(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    // 删除最大元素 而不一定是从栈顶删除元素
    public T delMax() {
        if (first == null) return null;
        // find max node
        Node maxNode = first;
        Node current = first.next;
        while (current != null) {
            if (current.item.compareTo(maxNode.item) > 0) {
                maxNode = current;
            }
            current = current.next;
        }
        if (maxNode == first) {
            first = first.next;
            n--;
        }
        else {
            Node prevMax = first;
            while (prevMax.next != maxNode) {
                prevMax = prevMax.next;
            }
            prevMax.next = prevMax.next.next;
            n--;
        }
        return maxNode.item;
    }

    public static void main(String[] args) {
        UnorderedLinkMaxPQ<String> pq = new UnorderedLinkMaxPQ<String>();
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }
}
