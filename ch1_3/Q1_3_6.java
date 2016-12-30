import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_6 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
        }
        for (String s: q) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        // 出对入栈 进行队列反序操作
        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty()) {
            stack.push(q.dequeue());
        }
        while (!stack.isEmpty()) {
            q.enqueue(stack.pop());
        }
        for (String s: q) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}