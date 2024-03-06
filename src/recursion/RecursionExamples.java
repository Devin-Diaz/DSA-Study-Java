package recursion;

public class RecursionExamples {


    public static int sum(int[] A, int index) {
        if(index == 0) return A[0];
        return A[index] + sum(A, index - 1);
    }

    public static int fibonacci(int n) {
        if(n < 2) return n;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int factorial(int n) {
        if(n == 0) return 1;
        return n * factorial(n - 1);
    }


    public static int maxNumberInArray(int[] A, int index) {
        if(index == 0) return A[0];
        return Math.max(A[index], index - 1);
    }

    private static void printStars(int n) {

        if(n == 0) return;

        System.out.print("*");
        printStars(n - 1);
    }

    public static void starLine(int lines, String prefix) {

        if(lines < 1) return;
        System.out.print(prefix);
        printStars(lines);
        System.out.println();

        starLine(lines - 1, prefix + " ");

    }

}
