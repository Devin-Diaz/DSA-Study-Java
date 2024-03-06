package doubly_linked_list;

public class DLLTester {
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(5);
        dll.add(10);
        dll.add(15);
        dll.add(20);

        dll.regularDisplay();
        dll.reverseDisplay();

        System.out.println(dll.isEmpty());
        System.out.println("Is 10 contained in dll? " + dll.contains(10));
        System.out.println("The size of our dll is: " + dll.size());

    }
}
