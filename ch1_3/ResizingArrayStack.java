import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

// 下压栈，能够动态调整数组大小的实现
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;
    public ResizingArrayStack() {
        a = (Item[]) new Object[1];
        N = 0;
    }
    private void resize(int max) {
        // 将大小为N <= max的栈移动到一个新的大小为max的数组中
        Item [] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        // 将元素压入栈顶
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }
    public Item pop() {
        // 从栈顶删除元素
        Item item = a[--N];
        a[N] = null; // 避免对象游离
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        // 支持后进先出的迭代器
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove() {

        }
    }

    // 测试用例
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.push(item);
        }
        StdOut.println("(" + s.size() + " left on stack)");
        for (String item : s) {
            StdOut.println(item);
        }
    }
}
