/**
 * @file circular linked list queue
 * @author Sun Wenfei(sunwenfei@baidu.com)
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class CircularQueue<T> implements Iterable<T> {

    private Node<T> last;

    public CircularQueue() {
        last = null;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<T>();
        node.item = item;

        if (last == null) {
            last = node;
            node.next = node;
        }
        else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T item = last.next.item;
        if (last.next == last) {
            last = null;
        }
        else {
            last.next = last.next.next;
        }
        return item;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private Node<T> index;

        public Iter() {
            if (last == null) {
                index = null;
            }
            else {
                index = last.next;
            }
        }

        public boolean hasNext() {
            return index != null;
        }

        public T next() {
            T item = index.item;
            if (index == last) {
                index = null;
            }
            else {
                index = index.next;
            }
            return item;
        }
    }

    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            StdOut.println(it.next());
        }
        StdOut.println("dequeue:");
        String s;
        while ((s = queue.dequeue()) != null) {
            StdOut.println(s);
        }
    }
}