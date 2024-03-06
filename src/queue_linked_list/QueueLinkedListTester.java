package queue_linked_list;

import singly_linked_list.LinkedList;

public class QueueLinkedListTester {
    public static void main(String[] args) {

        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        System.out.println(queue);

        System.out.println(queue.peek());

    }
}