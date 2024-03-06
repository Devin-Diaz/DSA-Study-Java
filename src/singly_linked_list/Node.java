package singly_linked_list;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public void addNext(Node node) {
        next = node;
    }
}
