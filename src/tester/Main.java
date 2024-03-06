package tester;

import recursion.RecursionExamples;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 9, 4, 10};
        System.out.println(RecursionExamples.maxNumberInArray(arr, arr.length - 1));

        RecursionExamples.starLine(5, "");

        System.out.println(RecursionExamples.sum(arr, arr.length - 1));

        System.out.println(RecursionExamples.fibonacci(5));

        System.out.println(RecursionExamples.factorial(5));

    }
}
