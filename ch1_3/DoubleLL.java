/**
 * @file double linked list
 * @author iamswf@163.com
 * @date 2016-12-29
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DoubleLL<T> {
    private DoubleNode<T> first;
    private DoubleNode<T> last;

    public DoubleLL() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public DoubleNode<T> getFirst() {
        return first;
    }

    public void setFirst(DoubleNode<T> first) {
        this.first = first;
    }

    public DoubleNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleNode<T> last) {
        this.last = last;
    }

    // nested class
    public static class DoubleNode<E> {
        public E item;
        public DoubleNode<E> prev;
        public DoubleNode<E> next;
    }

    public DoubleNode<T> search(T item) {
        DoubleNode<T> index = first;
        while (index != null) {
            if (index.item == item) {
                return index;
            }
            index = index.next;
        }
        return null;
    }

    public void printLink() {
        DoubleNode<T> index = first;
        while (index != null) {
            StdOut.println(index.item);
            index = index.next;
        }
    }

    public static <E> void insertAtBegin(DoubleLL<E> dll, E item) {
        DoubleNode<E> node = new DoubleNode<E>();
        node.item = item;
        DoubleNode<E> first = dll.getFirst();
        node.prev = null;
        node.next = first;
        if (first == null) {
            dll.setLast(node);
        }
        else {
            first.prev = node;
        }
        dll.setFirst(node);
    }

    public static <E> void insertAtEnd(DoubleLL<E> dll, E item) {
        DoubleNode<E> node = new DoubleNode<E>();
        node.item = item;
        DoubleNode<E> last = dll.getLast();
        node.prev = last;
        node.next = null;
        if (last == null) {
            dll.setFirst(node);
        }
        else {
            last.next = node;
        }
        dll.setLast(node);
    }

    public static <E> void insertBefore(DoubleLL<E> dll, DoubleNode<E> node, E item) {
        if (dll.isEmpty() || node == null) return;

        DoubleNode<E> newNode = new DoubleNode<E>();
        newNode.item = item;

        newNode.prev = node.prev;
        if (node.prev != null) {
            node.prev.next = newNode;
        }

        newNode.next = node;
        node.prev = newNode;

    }

    public static <E> void insertAfter(DoubleLL<E> dll, DoubleNode<E> node, E item) {
        if (dll.isEmpty() || node == null) return;

        DoubleNode<E> newNode = new DoubleNode<E>();
        newNode.item = item;

        newNode.next = node.next;
        if (node.next != null) {
            node.next.prev = newNode;
        }

        newNode.prev = node;
        node.next = newNode;
    }

    public static <E> E removeAtBegin(DoubleLL<E> dll) {
        if (dll.isEmpty()) return null;

        DoubleNode<E> first = dll.getFirst();
        E item = first.item;
        if (first.next == null) {
            dll.setFirst(null);
            dll.setLast(null);
        }
        else {
            first.next.prev = null;
            dll.setFirst(first.next);
        }
        return item;
    }

    public static <E> E removeAtEnd(DoubleLL<E> dll) {
        if (dll.isEmpty()) return null;

        DoubleNode<E> last = dll.getLast();
        E item = last.item;
        if (last.prev == null) {
            dll.setFirst(null);
            dll.setLast(null);
        }
        else {
            last.prev.next = null;
            dll.setLast(last.prev);
        }
        return item;
    }

    public static <E> E remove(DoubleLL<E> dll, DoubleNode<E> node) {
        if (dll.isEmpty() || node == null) return null;

        // remove first
        if (node.prev == null) {
            return removeAtBegin(dll);
        }

        // remove last
        if (node.next == null) {
            return removeAtEnd(dll);
        }

        E item = node.item;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return item;
    }

    public static void main(String[] args) {
        DoubleLL<String> dll = new DoubleLL<String>();

        StdOut.println("insertAtBegin:");
        DoubleLL.insertAtBegin(dll, "a");
        DoubleLL.insertAtBegin(dll, "b");
        DoubleLL.insertAtBegin(dll, "c");
        DoubleLL.insertAtBegin(dll, "d");
        DoubleLL.insertAtBegin(dll, "e");
        dll.printLink();

        StdOut.println("insertAtEnd:");
        DoubleLL.insertAtEnd(dll, "f");
        DoubleLL.insertAtEnd(dll, "g");
        DoubleLL.insertAtEnd(dll, "h");
        DoubleLL.insertAtEnd(dll, "i");
        DoubleLL.insertAtEnd(dll, "j");
        dll.printLink();

        StdOut.println("insertBefore:");
        DoubleNode<String> g = dll.search("g");
        DoubleLL.insertBefore(dll, g, "G");
        dll.printLink();

        StdOut.println("insertAfter:");
        DoubleNode<String> h = dll.search("h");
        DoubleLL.insertAfter(dll, h, "H");
        dll.printLink();

        StdOut.println("removeAtBegin:");
        String first = DoubleLL.removeAtBegin(dll);
        StdOut.println("begin item: " + first);
        dll.printLink();

        StdOut.println("removeAtEnd:");
        String last = DoubleLL.removeAtEnd(dll);
        StdOut.println("end item: " + last);
        dll.printLink();

        StdOut.println("remove:");
        DoubleNode<String> nodeToRemove = dll.search("i");
        String item = DoubleLL.remove(dll, nodeToRemove);
        StdOut.println("node removed: " + item);
        dll.printLink();
    }
}