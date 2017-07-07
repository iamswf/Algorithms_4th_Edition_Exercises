import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class ThreeSumFast {
    // 先排序再统计
    public static int fastCount(int[] a) {
        // 先排序
        Arrays.sort(a);
        int cnt = 0;
        // 使用二分查找统计和为0的数对
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Arrays.binarySearch(a, -(a[i] + a[j])) > j) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    // 暴力统计
    public static int slowCount(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch timer1 = new Stopwatch();
        StdOut.println(fastCount(a));
        double time1 = timer1.elapsedTime();
        StdOut.printf("%.2f seconds\n", time1);

        Stopwatch timer2 = new Stopwatch();
        StdOut.println(slowCount(a));
        double time2 = timer2.elapsedTime();
        StdOut.printf("%.2f seconds\n", time2);
    }
}