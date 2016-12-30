import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 十进制转二进制
public class Q1_3_5 {
    public static void main(String[] args) {
        int num = StdIn.readInt();
        Stack<Integer> stack = new Stack<Integer>();
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        for (int d: stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }
}