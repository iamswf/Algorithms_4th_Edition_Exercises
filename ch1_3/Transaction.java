import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Transaction implements Comparable<Transaction> {
    private final String name;
    private final Date date;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.name = who;
        this.date = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] s = transaction.split("\\s+");
        if (s.length != 3) {
            throw new IllegalArgumentException("Argument illegal: " + transaction);
        }
        name = s[0];
        date = new Date(s[1]);
        this.amount = Double.parseDouble(s[2]);
    }

    public String who() {
        return name;
    }

    public Date when() {
        return date;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return name + " " + date + " " + amount;
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (!this.name.equals(that.name)) return false;
        if (!this.date.equals(that.date)) return false;
        if (this.amount != that.amount) return false;
        return true;
    }

    public int compareTo(Transaction that) {
        if (this.amount > that.amount) return 1;
        else if (this.amount < that.amount) return -1;
        else return 0;
    }

    public static Transaction[] readTransactions(String s) {
        In in = new In(s);
        Queue<Transaction> q = new Queue<Transaction>();
        while (!in.isEmpty()) {
            q.enqueue(new Transaction(in.readLine())); // in.readLine()格式为 sunwenfei 9/24/2016 4800.5
        }
        int N = q.size();
        Transaction[] result = new Transaction[N];
        for (int i = 0; i < N; i++) {
            result[i] = q.dequeue();
        }
        return result;
    }

    // 测试用例
    public static void main(String[] args) {
        Transaction[] t = new Transaction[4];
        t[0] = new Transaction("Turing 6/17/1990 644.08");
        t[1] = new Transaction("Tarjan 3/26/2002 4121.85");
        t[2] = new Transaction("Knuth 6/14/1999 288.34");
        t[3] = new Transaction("Dijkstra 8/22/2007 2678.40");
        StdOut.println("Unsorted:");
        for (int i = 0; i < t.length; i++) {
            StdOut.println(t[i]);
        }
        Arrays.sort(t);
        StdOut.println("Sorted:");
        for (int i = 0; i < t.length; i++) {
            StdOut.println(t[i]);
        }
    }
}