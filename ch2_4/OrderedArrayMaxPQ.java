package ch2_4;

import edu.princeton.cs.algs4.StdOut;

public class OrderedArrayMaxPQ<T extends Comparable<T>> {
    private T[] pq;     // elements
    private int n;      // number of elements

    @SuppressWarnings("unchecked")
    public OrderedArrayMaxPQ(int capacity) {
        Comparable[] c = new Comparable[capacity];
        pq = (T[]) c;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(T x) {
        int i = n - 1;
        while (i >= 0) {
            if (less(pq[i], x)) {
                break;
            }
            pq[i + 1] = pq[i];
            i--;
        }
        pq[i + 1] = x;
        n++;
    }

    public T delMax() {
        return pq[--n];
    }

    public boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMax());
        }
    }
}