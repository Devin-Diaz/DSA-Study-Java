package CS_271_ASSIGNMENT_2;

/*

    FOR THIS ASSIGMENT, THIS ADT CAN BE USED FOR THE FOLLOWING EXPLAINED BELOW:

    This bag data structure has an array implementation. This is used to, add a ticket,
    keep track of how many tickets are entered, how many winners, IF there is a winner,
    if the bag is empty, if the bag is full, and a private feature that resizes the bag
    accordingly if the amount of entries exceeds its original capacity.
 */
public class Bag {
    private int capacity;
    private int top;
    private int[] data;

    public Bag() {
        capacity = 1;
        top = 0;
        data = new int[capacity];
    }

    public void add(int num) {
        if(full())
            resize();

        data[top++] = num;
    }

    private boolean full() {
        return top == data.length;
    }

    private void resize() {
        int newTop = capacity * 2;
        int[] temp = new int[newTop];

        for(int i = 0; i < this.top; i++) {
            temp[i] = data[i];
        }

        capacity *= 2;
        data = temp;
    }

    public int occurrence(int num) {
        int counter = 0;

        for(int i = 0; i < data.length; i++) {
            if(data[i] == num) counter++;
        }
        return counter;
    }


    public boolean contains(int num) {
        for (int ticket : data) {
            if (ticket == num) {
                return true;
            }
        }
        return false;
    }

    public boolean IsEmpty() {
        return top == 0;
    }
}
