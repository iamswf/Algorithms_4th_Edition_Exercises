import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_9 {
    public static void main(String[] args) {
        String line = StdIn.readLine();
        String[] values = line.split("\\s+");
        Stack<String> numStack = new Stack<String>(); // 操作数栈
        Stack<String> opStack = new Stack<String>(); // 运算符栈
        for (int i = 0, len = values.length; i < len; i++) {
            if (values[i].equals("+")
                || values[i].equals("-")
                || values[i].equals("*")
                || values[i].equals("/")) {
                opStack.push(values[i]); // 运算符入栈
            }
            else if (values[i].equals(")")) {
                // 操作数出栈
                String d1 = numStack.pop();
                String d2 = numStack.pop();
                String op = opStack.pop();
                // 操作数与运算符组合
                String newComb = "( " + d2 + " " + op + " " + d1 + " )";
                // 组合完成后入栈
                numStack.push(newComb);
            }
            else  {
                numStack.push(values[i]); // 操作数入栈
            }
        }
        StdOut.println(numStack.pop());
    }
}