import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first; // 对头节点链接
    private Node last; // 对尾节点链接
    private int N; // 对长度
    private class Node {
        // 定义节点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null; // 或: N == 0
    }
    public int size() {return N;}
    public void enqueue(Item item) {
        // 向链表尾部添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        // 在对头特殊处理之后再执行N--
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
            // oldlast = null; // 无需担心对象游离，因为oldlast是局部变量，enqueue方法执行完自动释放引用
        }
        N++;
    }
    public Item dequeue() {
        // 从链表头部删除元素
        Item item = first.item;
        first = first.next;
        N--;
        // 在尾部特殊处理之前先执行N--
        if (isEmpty()) {
            last = null;
        }
        return item;
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
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
           //  if (!item.equals("-")) {
           //      q.enqueue(item);
           //  }
           //  else if (!q.isEmpty()) {
           //      StdOut.print(q.dequeue() + " ");
           //  }
           q.enqueue(item);
        }
        for (String item: q) {
            StdOut.print(item + " ");
        }
    }
}
