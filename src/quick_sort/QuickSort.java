package quick_sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {6, 2, 7, 2, 7, 8, 1, 3};
        quicksort(arr);
        printArray(arr);

    }

    private static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex) return;

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

         quicksort(arr, lowIndex, leftPointer - 1);
         quicksort(arr, leftPointer + 1, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {

            while(arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while(arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int j : arr) {
            sb.append(j).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        System.out.println(sb);
    }

}