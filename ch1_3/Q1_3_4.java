import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_4 {
    public static void main(String[] args) {
        String s = StdIn.readString();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char item = s.charAt(i);
            if (item == '(' || item == '[' || item == '{') {
                stack.push(item);
            }
            else if ((item == ')' && stack.pop() != '(')
                    || (item == ']' && stack.pop() != '[')
                    || (item == '}' && stack.pop() != '{')) {
                StdOut.println(false);
                return;
            }
        }
        StdOut.println(true);
    }
}
