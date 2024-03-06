package singly_linked_list;

public class LinkedListTester {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(1);
        list.insert(6);
        list.insert(4);

        list.remove(4);

        list.print();

        list.recursivePrint(list.head);

    }
}
