import java.util.EmptyStackException;

public class Queue {

    private Node head;
    private Node tail;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (tail != null)
            tail.next = newNode;

        tail = newNode;
        if (head == null)
            head = tail;
    }

    public int remove() {
        int data = -1;
        if (!isEmpty())
            data = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        int data = head.data;
        head = head.next;
        return data;
    }
}
