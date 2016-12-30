import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 与Q1_3_10算法基本一样
public class Q1_3_11 {
    public static void main(String[] args) {
        String line = StdIn.readLine();
        line = "1 2 3 4 5 * + 6 * * +"; // 277
        String[] values = line.split("\\s+");
        Stack<Integer> numStack = new Stack<Integer>(); // 操作数栈
        for (int i = 0, len = values.length; i < len; i++) {
            if (values[i].equals("+")) {
                int value = numStack.pop() + numStack.pop();
                numStack.push(value);
            }
            else if (values[i].equals("-")) {
                int value = numStack.pop() - numStack.pop();
                numStack.push(value);
            }
            else if (values[i].equals("*")) {
                int value = numStack.pop() * numStack.pop();
                numStack.push(value);
            }
            else if (values[i].equals("/")) {
                int value = numStack.pop() / numStack.pop();
                numStack.push(value);
            }
            else {
                numStack.push(Integer.parseInt(values[i]));
            }
        }
        StdOut.println(numStack.pop());
    }
}