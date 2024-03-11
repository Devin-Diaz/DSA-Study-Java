package heaps;

import java.util.Arrays;

public class MaxHeap {
    private int top;
    private int capacity;
    private int[] data;

    public MaxHeap() {
        top = 0;
        capacity = 10;
        data = new int[capacity];
    }

    private void resizeHeap() {
        if(capacity == top) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = data[indexOne];
        data[indexOne] = data[indexTwo];
        data[indexTwo] = temp;
    }

    // retrieves of a parent or child node given its certain counterpart
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    // returns the element in the heap at the given index
    private int parent(int index) {
        return data[getParentIndex(index)];
    }

    private int leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    // boolean functions that checks if a node exists given its position
    private boolean hasParent(int index) {
        return index > 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < top;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < top;
    }

    // returns root element
    public int peek() {
        if(top == 0) throw new IllegalStateException("HEAP IS EMPTY");
        return data[0];
    }

    // removes max element and utilizes heapify
    public int poll() {
        if(top == 0) throw new IllegalStateException("HEAP IS EMPTY");
        int root = data[0];
        data[0] = data[top - 1];
        top--;
        heapifyDown(0);
        return root;
    }

    public void add(int element) {
        resizeHeap();
        data[top++] = element;
        heapifyUp(top - 1);
    }

    // recursive version of heapifyUp
    private void heapifyUp(int index) {
        if(hasParent(index) && parent(index) < data[index]) {
            swap(index, getParentIndex(index));
            heapifyUp(getParentIndex(index));
        }
    }


    // recursive version of heapifyDown
    private void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largest = index;

        // Check if left child is larger than current node
        if (hasLeftChild(index) && data[leftChildIndex] > data[largest]) {
            largest = leftChildIndex;
        }

        // Check if right child is larger than the largest so far
        if (hasRightChild(index) && data[rightChildIndex] > data[largest]) {
            largest = rightChildIndex;
        }

        // If the largest is not the current node, swap and continue bubbling down
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void printMaxHeap() {
        // Assuming 'data' is the array storing heap elements, and 'top' is the size of the heap.
        // Calculate depth of the heap (how many levels contain nodes)
        int depth = (int) (Math.log(top) / Math.log(2)) + 1;

        int startIndex = 0; // Start at the root
        for (int level = 0; level < depth; level++) {
            int levelCount = (int) Math.pow(2, level); // Number of elements at this level
            int spaces = (int) Math.pow(2, depth - level + 1) - 1; // Space between elements in the level

            // Print leading spaces for the current level
            for (int i = 0; i < spaces / 2; i++) {
                System.out.print(" ");
            }

            // Print all nodes at the current level
            for (int i = 0; i < levelCount && (startIndex + i) < top; i++) {
                System.out.print(data[startIndex + i]);

                // Print spaces between nodes in the same level
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Move to the next line after printing the level

            startIndex += levelCount; // Move to the start index of the next level
        }
    }

}
