package ch2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // 切分
        sort(a, lo, j - 1); // 递归将左半部分a[lo, ..., j - 1]排序
        sort(a, j + 1, hi); // 递归将又半部分a[j + 1, ..., hi]排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi;
        while (i < j) {
            while (less(a[i], a[lo])) {
                i ++;
                if (i == hi) break;
            }
            while (less(a[lo], a[j])) {
                j --;
                if (j == lo) break;
            }
            if (i < j) {
                exch(a, i, j);
            }
        }
        exch(a, lo, j); // a[lo, ..., j - 1] <= a[j] <= a[j + 1, ..., hi]达成
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
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

    public static void main(String[] args) {
        // 从标准输入中读取字符串，并排序输出
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

