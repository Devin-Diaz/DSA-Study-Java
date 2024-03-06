package singly_linked_list;

public class LinkedList {
    public Node head;
    public LinkedList() {
        head = null;
    }

    public void insert(int target) {
        // this can be OR bc/ either one would be valid
        if(head == null || target <= head.data) {
            insertAtHead(target);
            return;
        }

        Node before = head;

        // the reason why order of conditionals matter is because we need ensure that
        // next isn't null before we check the data and next and compare it to target
        while(before.next != null && before.next.data <= target) {
            before = before.next;
        }

        Node after = before.next;
        before.next = new Node(target);
        before.next.next = after;
    }

    public void insertAtHead(int target) {
        Node newNode = new Node(target); // creating new node with its target
        newNode.addNext(head); // pointing the new node reference to the OLD HEAD
        head = newNode; // updating the head to the newest added target
    }

    public void insertAtTail(int target) {
        if(head == null) {
            head = new Node(target);
            return;
        }

        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(target);
    }

    public void remove(int target) {
        Node temp = head;

        // again order of conditionals matter. We need to make sure next is not null
        // before comparing the data at next, if not at a NullPointerException comparing data
        while(temp != null && temp.data != target) {
            temp = temp.next;
        }

        if(temp == null) return;

        if(temp == head) {
            head = head.next;
            return;
        }

        Node before = head;
        while(before.next.data != target) {
            before = before.next;
        }

        before.next = before.next.next;

    }

    public int size() {
        int counter = 0;
        Node temp = head;

        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public boolean contains(int value) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }

    public void print() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void recursivePrint(Node head) {

        if(head == null) {
            System.out.print("NULL");
            return;
        }
        System.out.print(head.data + " --> ");
        recursivePrint(head.next);
    }

}
