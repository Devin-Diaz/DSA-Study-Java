package set_linked_list;

import singly_linked_list.LinkedList;
import singly_linked_list.Node;

public class SetLinkedList {

    private final LinkedList list;

    public SetLinkedList() {
        list = new LinkedList();
    }

    public static SetLinkedList union(SetLinkedList a, SetLinkedList b) {
        SetLinkedList set = new SetLinkedList();

        Node temp = a.list.head;

        while(temp != null) {
            set.insert(temp.data);
            temp = temp.next;
        }

        temp = b.list.head;

        while(temp != null) {
            set.insert(temp.data);
            temp = temp.next;
        }
        return set;
    }

    public static SetLinkedList difference(SetLinkedList a, SetLinkedList b) {
        SetLinkedList set = new SetLinkedList();
        Node temp = a.list.head;

        while(temp != null) {
            set.insert(temp.data);
            temp = temp.next;
        }

        temp = b.list.head;

        while(temp != null) {
            set.remove(temp.data);
            temp = temp.next;
        }
        return set;
    }

    public void insert(int target) {
        if(!isMember(target)) {
            list.insert(target);
        }
    }

    public void remove(int target) {
        list.remove(target);
    }

    public boolean isMember(int target) {
        Node temp = list.head;

        while(temp != null) {
            if(temp.data == target) return true;
            temp = temp.next;
        }
        return false;
    }


    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node temp = list.head;

        while(temp != null) {
            sb.append(temp.data).append(" --> ");
            temp = temp.next;
        }
        sb.append("NULL");

        return sb.toString();
    }




}
