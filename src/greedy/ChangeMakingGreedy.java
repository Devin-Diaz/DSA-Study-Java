package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    Change making problem. A perfect beginner-friendly problem to learn about greedy in computer science.
*/



public class ChangeMakingGreedy {

    public static void main(String[] args) {
        logicMethod();
    }

    public static ArrayList<Integer> outcome(int amount) {

        ArrayList<Integer> output_list = new ArrayList<>();
        int[] denominations = {1, 5, 10, 25};
        int n = denominations.length;

        for (int i = n - 1; i >= 0; i--) {
            while(amount >= denominations[i]) {
                output_list.add(denominations[i]);
                amount -= denominations[i];
            }
        }
        return output_list;
    }

    public static void displayChange(ArrayList<Integer> change) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < change.size(); i++) {
            if (change.get(i) == 1)
                map.put("penny", map.getOrDefault("penny", 0) + 1);
            if (change.get(i) == 5)
                map.put("Nickel", map.getOrDefault("Nickel", 0) + 1);
            if (change.get(i) == 10)
                map.put("Dime", map.getOrDefault("Dime", 0) + 1);
            if (change.get(i) == 25)
                map.put("Quarter", map.getOrDefault("Quarter", 0) + 1);

        }

        for(Map.Entry<String, Integer> temp : map.entrySet()) {
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }

    public static void logicMethod() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("This program utilizes greedy algorithm approach with a time complexity of O(D + A) \n" +
                "where D are the denominations and A is the amount given. Given an input integer, it will \n" +
                "calculate the best case scenario to simplify your process and getting a customers change. Try: ");
        System.out.println();

        System.out.print("ENTER #: ");
        int input = sc.nextInt();

        System.out.println();
        System.out.println("Your change in denominations is: ");
        displayChange(outcome(input));

        sc.close();
    }
}
