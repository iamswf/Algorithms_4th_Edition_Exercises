import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 测试运行方式 java Q1_3_17 transactions.txt
public class Q1_3_17 {
    public static void main(String[] args) {
        Transaction[] transactions = Transaction.readTransactions(args[0]);
        for (int i = 0, len = transactions.length; i < len; i++) {
            StdOut.println(transactions[i]);
        }
    }
}