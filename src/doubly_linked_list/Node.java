package doubly_linked_list;

public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void addNext(Node node) {
        this.next = node;
    }

    public void addPrev(Node node) {
        this.prev = node;
    }


}
