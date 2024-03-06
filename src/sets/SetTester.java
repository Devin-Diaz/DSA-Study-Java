package sets;

//class specifically for testing out mock Set data structure

public class SetTester {
    public static void main(String[] args) {

        Set s1 = new Set();

        Set s2 = new Set();

        s2.add(4);
        s2.add(7);

        System.out.println(s2.size());


        System.out.println(s2);

    }
}
