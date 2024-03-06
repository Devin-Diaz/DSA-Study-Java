package doubly_linked_list;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.addNext(newNode);
        newNode.addPrev(tail);
        tail = newNode;
    }

    public void remove(int data) {
        Node current = head; // Start at the beginning of the list

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current.prev == null) {
            head = current.next;
        }
        else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            tail = current.prev;
        }
        else {
            current.next.prev = current.prev;
        }
    }

    public boolean contains(int data) {
        Node current = head;

        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        Node current = head;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void regularDisplay() {
        StringBuilder sb = new StringBuilder();

        Node current = head;

        sb.append("NULL").append(" <--> ");

        while(current != null) {
            sb.append(current.data).append(" <--> ");
            current = current.next;
        }
        sb.append("NULL");

        System.out.println(sb);
    }

    public void reverseDisplay() {
        StringBuilder sb = new StringBuilder();

        Node current = tail;

        sb.append("NULL").append(" <--> ");


        while(current != null) {
            sb.append(current.data).append(" --> ");
            current = current.prev;
        }

        sb.append("NULL");

        System.out.println(sb);
    }
}
