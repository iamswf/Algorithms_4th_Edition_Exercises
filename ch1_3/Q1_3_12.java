import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 类Stack中实现的方法：public static <T> Stack<T> copy(Stack<T> s)
public class Q1_3_12 {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("first");
        s.push("second");
        s.push("third");
        Stack<String> copy = Stack.copy(s);
        while (!copy.isEmpty()) {
            StdOut.println(copy.pop());
        }
    }
}