package queue_linked_list;

import singly_linked_list.LinkedList;
import singly_linked_list.Node;

public class QueueLinkedList {

    private final LinkedList list;

    public QueueLinkedList() {
        list = new LinkedList();
    }

    public void enqueue(int entry) {
        list.insertAtTail(entry);
    }

    public int dequeue() {
        if(list.head == null) {
            return -1;
        }
        int element = list.head.data;
        list.head = list.head.next;
        return element;
    }

    public int size() {
        return list.size();
    }

    public boolean contains(int entry) {
        return list.contains(entry);
    }

    public int peek() {
        return list.head.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = list.head;

        while (current != null) {
            sb.append(current.data).append(" : ");
            current = current.next;
        }
        return sb.toString();
    }

}
