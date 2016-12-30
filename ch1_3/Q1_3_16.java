import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 测试运行方式 java Q1_3_16 dates.txt
public class Q1_3_16 {
    public static void main(String[] args) {
        Date[] dates = Date.readDates(args[0]);
        for (int i = 0, len = dates.length; i < len; i++) {
            StdOut.println(dates[i]);
        }
    }
}