import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Q1_3_3 {
    public static boolean isValid(int[] seq) {
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0; // index从0到9递增，入栈用
        for (int i = 0, len = seq.length; i < len; i++) {
            while (stack.isEmpty() || stack.top() < seq[i]) {
                stack.push(index);
                index++;
            }
            if (stack.top() > seq[i]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] values = line.split("\\s+");
            int[] nums = new int[10];  
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(values[i]);
            }
            if (isValid(nums)) {
                StdOut.println(true);
            }
            else {
                StdOut.println(false);
            }
        }
    }
}
