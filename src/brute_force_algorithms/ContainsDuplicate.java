package brute_force_algorithms;

import java.util.Random;

/*
    Devin Diaz,   3 / 20 / 2024

    This Java program utilizes a brute force algorithm that verifies whether an algorithm contains a
    duplicate element or not. We time each test case with nano seconds then convert to milliseconds
    for easier readability.
*/

public class ContainsDuplicate {
    // testing
    public static void main(String[] args) {

        int[] arr50 = populateArray(50);
        int[] arr100 = populateArray(100);
        int[] arr1000 = populateArray(1000);
        int[] arr5000 = populateArray(5000);
        int[] arr10000 = populateArray(10000);

        testCase(arr50);
        System.out.println();
        testCase(arr100);
        System.out.println();
        testCase(arr1000);
        System.out.println();
        testCase(arr5000);
        System.out.println();
        testCase(arr10000);

        /*
        RESULTS:

        Execution time for array of size: 50 is 0.0146 milliseconds
        Execution time for array of size: 100 is 0.0628 milliseconds
        Execution time for array of size: 1000 is 3.8404 milliseconds
        Execution time for array of size: 5000 is 8.6366 milliseconds
        Execution time for array of size: 10000 is 17.7717 milliseconds
        */

    }

    // execution of program
    private static void testCase(int[] arrTester) {

        long startTime = System.nanoTime();

        //start brute force algorithm
        for(int i = 0; i < arrTester.length; i++) {
            for(int j = i + 1; j < arrTester.length; j++) {
                if(arrTester[i] == arrTester[j]) break;
            }
        }
        //end of algorithm

        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // Duration in nanoseconds
        System.out.println("Execution time for array of size: " +
                arrTester.length + " is " + nanoToMilli(duration) + " milliseconds");
    }

    // populates array of custom size with random integers
    private static int[] populateArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // converts nanoseconds to milliseconds
    private static double nanoToMilli(double nano) {
        return nano / 1000000;
    }
}
