package ch2_4;

import edu.princeton.cs.algs4.StdOut;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // elements
    private int n; // number of elements

    public UnorderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    
}
