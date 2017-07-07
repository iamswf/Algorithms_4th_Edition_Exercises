package ch2_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Q2_1_12 {
    public static int compNum = 0;
    public static int exchNum = 0;

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // for (int i = h; i < a.length; i++) {
            //     for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
            //         exch(a, j, j - h);
            //     }
            // }
            for (int i = h; i < a.length; i++) {
                int j = i;
                while (j >= h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                        j -= h;
                    }
                    else {
                        break;
                    }
                }
            }
            h = h/3;
        }
        StdOut.println("N = " + N);
        StdOut.println(compNum / N);
        StdOut.println(exchNum / N);
        compNum = 0; // reset compNum
        exchNum = 0; // reset exchNum
    }

    private static boolean less(Comparable v, Comparable w) {
        compNum ++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        exchNum ++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void randomInputSort() {
        // 将T个长度为N的数组排序
        for (int n = 0; n < 5; n++) {
            int N = 100 *  (int)Math.pow(10, n);
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            sort(a);
            assert isSorted(a);
        }
    }

    public static void main(String[] args) {
        randomInputSort();
    }
}


