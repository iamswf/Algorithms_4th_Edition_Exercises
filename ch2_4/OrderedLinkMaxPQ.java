package ch2_4;

import edu.princeton.cs.algs4.StdOut;

// 基于有序链表和栈实现
public class OrderedLinkMaxPQ<T extends Comparable<T>> {
    private Node first;
    private int n;
    private class Node {
        T item;
        Node next;
    }

    public OrderedLinkMaxPQ() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null; // 或: n == 0
    }

    public int size() {
        return n;
    }

    // 添加元素到对应位置 而不一定是栈顶
    public void insert(T item) {
        if (first == null) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            n++;
        }
        else {
            // find the node less than item or is null
            Node current = first;
            while (current != null
                && (current.item.compareTo(item) > 0)) {
                current = current.next;
            }
            // insert item provious current
            if (current == first) {
                Node oldFirst = first;
                first = new Node();
                first.item = item;
                first.next = oldFirst;
                n++;
            }
            else {
                Node prevCurrent = first;
                while (prevCurrent.next != current) {
                    prevCurrent = prevCurrent.next;
                }
                prevCurrent.next = new Node();
                prevCurrent.next.item = item;
                prevCurrent.next.next = current;
                n++;
            }
        }
    }

    // 从栈顶删除元素（栈顶元素为最大元素）
    public T delMax() {
        if (first == null) return null;
        T max = first.item;
        first = first.next;
        n--;
        return max;
    }

    public static void main(String[] args) {
        OrderedLinkMaxPQ<String> pq = new OrderedLinkMaxPQ<String>();
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }
}
