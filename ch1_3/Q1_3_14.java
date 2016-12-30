import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_14 {
    public static void main(String[] args) {
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
        q.enqueue("first");
        q.enqueue("second");
        q.enqueue("third");
        while (!q.isEmpty()) {
            StdOut.println(q.dequeue());
        }
    }
}