import java.util.EmptyStackException;

public class Stack {

    private Node head;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        int value = head.data;
        head = head.next;
        return value;
    }

    public int size() {
        int value = 0;
        Node pointer = head;
        while (pointer != null) {
            value++;
            pointer = pointer.next;
        }
        return value;
    }
}
