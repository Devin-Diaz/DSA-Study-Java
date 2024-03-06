package set_linked_list;

public class SetLinkedListTester {
    public static void main(String[] args) {

        SetLinkedList set = new SetLinkedList();

        set.insert(5);
        set.insert(10);
        set.insert(2);
        set.insert(9);
        set.insert(10);

        System.out.println(set);



    }
}
