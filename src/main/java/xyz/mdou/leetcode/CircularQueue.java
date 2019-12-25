package xyz.mdou.leetcode;

public class CircularQueue<T> {

    private T[] t;
    private int length;
    private int head;
    private int tail;

    public CircularQueue(T[] t) {
        this.t = t;
        this.length = t.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    public boolean enQueue(T o) {
        if (isFull()) {
            return false;
        }
        t[tail] = o;
        tail = (tail + 1) % length;
        return true;
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T o = t[head];
        head = (head + 1) % length;
        return o;
    }

    public int size() {
        return (length + tail - head) % length;
    }

    public static void main(String[] args) {
        String[] t = new String[2];
        CircularQueue<String> queue = new CircularQueue<String>(t);

        queue.enQueue("aaa");
        queue.enQueue("bbb");
        queue.enQueue("ccc");
        System.out.println(queue.size());

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue.size());
    }
}
