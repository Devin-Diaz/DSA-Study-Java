package queues;

public class QueueTester {
    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.offer(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(20);
        System.out.println(queue.size());

        System.out.println(queue.peek());

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.size());



    }
}
