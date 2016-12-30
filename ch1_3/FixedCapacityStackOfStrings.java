import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// 定容字符串栈
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N; // size
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public boolean isFull() {
        return N == a.length;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }

    // 测试用例
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(14);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.push(item);
        }
        StdOut.println("(" + s.size() + " left on stack)");
        StdOut.println("isFull: " + s.isFull());
    }
}
