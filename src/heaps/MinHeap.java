package heaps;

import java.util.Arrays;

public class MinHeap {

    private int top;
    private int capacity;
    private int[] data;

    public MinHeap() {
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

    // these 3 functions find the index of the element we want based of their parent node's index
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2; //flooring up by 1 from a child floor(i / 2)
    }
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;  // LN = 2 * i + 1
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    //boolean condition checking for existence of an element via their index
    //parent must be >= top bc/ they have to be greater than 0
    //left child nodes are < top because they need parent nodes for existence
    private boolean hasParent(int index) {
        return index > 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < top;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < top;
    }

    //retrieving the data in the minHeap array implementation via index
    private int parent(int index) {
        return data[getParentIndex(index)];
    }

    private int leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    //finding value of our root node (smallest one in heap)
    public int peek() {
        if(top == 0) throw new IllegalStateException();
        return data[0];
    }

    //removing minimum node (root)
    public int poll() {
        if(top == 0) throw new IllegalStateException();
        //recall min heaps remove minimum element that being the root
        int root = data[0];

        //top is always at an empty element, so it's ready for new insertion thus [top -1]
        data[0] = data[top - 1];
        top--;
        heapifyDown();
        return root;

    }

    //inserting new node in heap
    public void add(int element) {
        if(top == data.length) resizeHeap();

        //inserting and prepping top for future insertions
        data[top++] = element;
        heapifyUp();
    }

    //"bubbling up"
    public void heapifyUp() {
        int index = top - 1; // our last element in heap

        // while parent node exists and parent index is greater than last element
        while(hasParent(index) && parent(index) > data[index]) {

            //swap parent element with last element we have stored to heapify up
            swap(getParentIndex(index), index);

            // last element is now in the position of the previous parent position
            index = getParentIndex(index);

            //repeat this process until new inserted element fits minHeap criteria
            //parent node must be less than children nodes
        }
    }

    //"bubbling down", this is the iterative version of heapifyDown
    private void heapifyDown() {

        int index = 0; //parent root, element at the very top of heap

        //we check left child bc/ following heap criteria elements always get stored left side first
        while(hasLeftChild(index)) {

            //storing left child node of the root (last element in array that replaced minimum)
            int smallerChildIndex = getLeftChildIndex(index);

            //if a right child node exists and it's smaller than the left child node
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {

                //if conditions are reached than this will be the index that we will swap to start bubbling down
                smallerChildIndex = getRightChildIndex(index);
            }

            //if our current parent root node is smaller than either the left or right child node (we found the)
            //smalled between the two above), it tells us it's in the correct spot thus we are done
            if(data[index] < data[smallerChildIndex]) {
                break;
            }

            //if not then we will swap the elements of the two causing us to heapify down
            else {
                swap(index, smallerChildIndex);
            }

            // we adjust our new parent node index for future iterations
            index = smallerChildIndex;
        }
    }

    // display heap in visually appealing tree format
    public void printMinHeap() {
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
