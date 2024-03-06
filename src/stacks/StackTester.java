package stacks;

public class StackTester {
    public static void main(String[] args) {

        // tester specifically made for our bootleg stack class
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(8);

        System.out.println(s.peek());

        System.out.println(s);

    }
}
