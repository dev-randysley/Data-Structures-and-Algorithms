public class LinkedList {

    private Node head;

    private static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public void print(){

    }
    public void addFront(int value){
        Node newNode = new Node(value);
        if (head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void addBack(int value){
        Node newNode = new Node(value);
        Node current = head;
        if(current != null){
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        else
            head = newNode;
    }
    public int size(){
        int size = 0;
        Node current = head;
        if(current != null){
            while (current != null){
                size++;
                current = current.next;
            }
        }
        return size;
    }

    public void clear(){
        head = null;
    }

    public int getFirst(){
        int data= -1;
        if(head != null)
            data = head.data;
        return data;
    }

    public int getLast(){
        int data = 0;
        if(head != null){
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            data = current.data;
        }
        return data;
    }

    public void deleteValue(int value) {
        Node current = head;
        Node oldNode = null;
        if (current != null) {
            if (getFirst() == value)
                head = current.next;
            else {
                while (current.next != null) {
                    oldNode = current;
                    current = current.next;
                    if (current.data == value) {
                        oldNode.next = current.next;
                    }
                }
            }
        }
    }

}
