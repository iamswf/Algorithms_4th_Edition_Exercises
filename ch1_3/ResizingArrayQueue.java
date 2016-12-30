import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

// FIFO，能够动态调整数组大小的实现
public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] a; // 队列数组 
    private int first;
    private int last;
    private void resize(int max) {
        // 将大小为(last - first) < max的队列移动到大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        int j = 0;
        for (int i = first; i < last; i++) {
            temp[j++] = a[i];
        }
        a = temp;
        last = last - first;
        first = 0;
    }
    private class ArrayIterator implements Iterator<Item> {
        // 支持先进先出的迭代器
        private int i = first;
        public boolean hasNext() {
            return first < last;
        }
        public Item next() {
            return a[i++];
        }
        public void remove() {

        }
    }
    public ResizingArrayQueue() {
        a = (Item[]) new Object[1];
        first = 0;
        last = 0; 
    }
    public boolean isEmpty() {
        return first == last;
    }
    public int size() {
        return last - first;
    }
    public void enqueue(Item item) {
        // 入队
        if (last == a.length) {
            resize(2 * size());
        }
        a[last++] = item;
    }
    public Item dequeue() {
        // 出队
        Item item = a[first];
        a[first] = null; // 避免对象游离
        first++;
        if (size() == a.length / 4) {
            resize(2 * size());
        }
        return item;
    }
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
}
