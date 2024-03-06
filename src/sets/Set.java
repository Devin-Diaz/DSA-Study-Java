package sets;
/*
    This program emulates a Set data structure does with
    an array implementation
*/
public class Set {
    private int capacity; // field to keep track of array capacity
    private int top; // field to keep track of current index of top most set element
    private int[] data; // array that will contain our set information

    public Set() { //constructor
        top = 0;
        capacity = 1; // array fixed size starts at 1
        data = new int[capacity];
    }

    private boolean isFull() { // checks if our array is at capacity for our Set
        return top == data.length;
    }

    private void resize() {

        System.out.println("RESIZING SET...");

        int[] temp = new int[capacity * 2];

        for(int i = 0; i < this.top; i++) {
            temp[i] = this.data[i];
        }
        capacity *= 2; //updating our capacity field
        data = temp;
    }

    //STATIC METHODS FOR UNION AND INTERSECTION are preferred bc/ sets being compared won't get modified since
    // a new set is being returned. However, I will add 1 implementation of the non-static union method

    //STATIC VERSION
    public static Set union(Set a, Set b    ) {
        Set unionSet = new Set();

        for(int i = 0; i < a.top; i++) {
            unionSet.add(a.data[i]);
        }

        for(int i = 0; i < b.top; i++) {
            unionSet.add(b.data[i]);
        }

        return unionSet;
    }

    //NON-STATIC VERSION OF UNION
    public void union(Set other) {

        for(int i = 0; i < other.top; i++) {
            this.add(other.data[i]);
        }
    }

    // STATIC VERSION OF SET DIFFERENCE
    public static Set difference(Set a, Set b) {
        Set temp = new Set();

        for(int i = 0; i < a.top; i++) {
            temp.add(a.data[i]);
        }

        for(int i = 0; i < b.top; i++) {
            temp.remove(b.data[i]);
        }
        return temp;
    }

    //STATIC VERSION OF INTERSECTION
    // NOTE: A AND B == A - (A - B)
    public static Set intersection(Set a, Set b) {
        return Set.difference(a, Set.difference(a, b));
    }

    public void add(int num) {

        if(isFull()) { //checking if array is at capacity
            resize(); // if so resize the array by x2
        }

        if(!contains(num)) {
            data[top++] = num;
        }
    }

    public void remove(int num) {

        for(int i = 0; i < top; i++) {
            if(data[i] == num) {
                data[i] = data[--top];
                return;
            }
        }
    }

    public boolean contains(int num) {
        for(int i = 0; i < top; i++) {
            if(data[i] == num)
                return true;
        }
        return false;
    }

    public int size() {
        return top;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < top; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2).deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}
