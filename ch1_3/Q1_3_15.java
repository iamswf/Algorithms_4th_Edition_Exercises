import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) { // <C-d>结束输入流
            String s = StdIn.readString();
            q.enqueue(s);
        }
        while (q.size() > k) {
            q.dequeue();
        }
        StdOut.println(q.dequeue());
    }
}