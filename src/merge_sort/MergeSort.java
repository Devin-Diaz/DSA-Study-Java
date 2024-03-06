package merge_sort;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {

        int[] numbers = {5, 2, 6, 8, 2, 4, 8, 42, 12};

        mergeSort(numbers);
        displayArray(numbers);

    }

    private static void mergeSort(int[] arr) {

        int length = arr.length;

        //base case
        if(length <= 1) return;

        int middle = length / 2;

        // size of our sub-array
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        // indices
        int i = 0;
        int j = 0;

        // storing unordered elements in left and right partitioned arrays
        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = arr[i];
            }
            else {
                rightArray[j] = arr[i];
                j++;
            }
        }

        //recursive sequences to partition arrays
        mergeSort(leftArray);
        mergeSort(rightArray);

        // recursive sequence to conquer and properly sort array
        merge(leftArray, rightArray, arr);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] arr) {

        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;

        int i = 0, l = 0, r = 0; //indices

        while(l < leftSize && r < rightSize) {

            // storing elements in current order
            if(leftArray[l] < rightArray[r]) {
                arr[i] = leftArray[l];
                i++;
                l++;
            }

            else {
                arr[i] = rightArray[r];
                i++;
                r++;
            }
        }

        // any remaining elements leftover will get appended to the array

        while(l < leftSize) {
            arr[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize) {
            arr[i] = rightArray[r];
            i++;
            r++;
        }
    }


    // display array
    private static void displayArray(int[] arr) {

        List<Integer> list = new ArrayList<>();

        for (int j : arr) {
            list.add(j);
        }

        System.out.println(list);
    }

}
