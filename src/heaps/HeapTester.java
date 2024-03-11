package heaps;

public class HeapTester {
    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();

        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.poll();
        minHeap.printMinHeap();

        /*
                        2
                  4            3
               5
         */

        System.out.println();

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(5);
        maxHeap.poll();
        maxHeap.printMaxHeap();

        
        /*
                        4
                  3            2
               1
         */

    }
}
