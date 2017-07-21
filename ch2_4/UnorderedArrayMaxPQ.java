package ch2_4;

import edu.princeton.cs.algs4.StdOut;

public class UnorderedArrayMaxPQ<T extends Comparable<T>> {
    private T[] pq;      // elements
    private int n;       // number of elements

    @SuppressWarnings("unchecked")
    public UnorderedArrayMaxPQ(int capacity) {
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
        pq[n++] = x;
    }

    public T delMax() {
        int max = 0;
        for (int i = 1; i < n; i++)
            if (less(max, i)) max = i;
        exch(max, n-1);
        return pq[--n];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }
}