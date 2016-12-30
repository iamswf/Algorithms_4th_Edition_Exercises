import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 与Q1_3_9算法基本一样
public class Q1_3_10 {
    public static void main(String[] args) {
        String line = StdIn.readLine();
        // line = "( ( 1 + 2 ) * ( 3 - 4 ) )";
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
                // 操作数与运算符组合成后序表达式
                String newComb = "( " + d2 + " " + d1 + " " + op + " )";
                // 组合完成后入栈
                numStack.push(newComb);
            }
            else if (!values[i].equals("(")) {
                numStack.push(values[i]); // 操作数入栈
            }
        }
        StdOut.println(numStack.pop());
    }
}