package stacks;

/*
    This program emulates a Stack data structure does with
    an array implementation
*/


public class Stack {

    private int top;
    private int[] data;

    Stack() {
        top = 0;
        data = new int[2];
    }

    public void push(int num) {

        if(top == data.length - 1)
            resizeStack();

        data[top++] = num;
    }

    public int pop() {
        return data[--top];
    }

    public int peek() {

        int val = data[--top];
        top++;
        return val;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void resizeStack() {

        System.out.println("RESIZING ARRAY...");

        int[] temp_arr = new int[data.length * 2];

        for(int i = 0; i < top; i++) {
            temp_arr[i] = data[i];
        }

        data = temp_arr;
    }

    public int size() {
        return top;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();



        for(int i = 0; i < top; i++) {
            s.append(data[i]);
            s.append(" ");
        }
        return s.toString();
    }

}
