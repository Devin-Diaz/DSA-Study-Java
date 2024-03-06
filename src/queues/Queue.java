package queues;

public class Queue {

    private int front;
    private int rear;
    private int[] data;

    public Queue() {
        this.front = 0;
        this.rear = 0;
        data = new int[1240];
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        for(int i = 0; i < rear - front; i++) {
            temp[i] = data[i + front];
        }
        data = temp;
        rear = rear - front;
        front = 0;
    }

    public void offer(int element) {
        if(rear == data.length) resize();
        data[rear++] = element;
    }

    public int poll() {
        return data[front++];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int peek() {
        return data[front];
    }

    public int size() {
        return rear - front;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for(int i = front; i < rear; i++) {
            sb.append(data[i]).append(", ");
        }

        sb.append(']');

        return sb.toString();
    }



}
