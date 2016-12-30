import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first; // 链表首节点
    int N; // Bag大小
    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {
        // 和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public boolean isEmpty() {
        return first == null; // 或: N == 0
    }
    public int size() {
        return N;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }

    // 测试用例
    public static void main(String[] args) {
        Bag<String> b = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            b.add(item);
        }
        for (String s: b) {
            StdOut.print(s + " ");
        }
    }
}
