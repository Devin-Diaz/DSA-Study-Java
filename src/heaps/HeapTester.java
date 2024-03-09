package heaps;

public class HeapTester {
    public static void main(String[] args) {

        MinHeap heap = new MinHeap();

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);

        heap.poll();

        heap.printHeap();
    }
}
