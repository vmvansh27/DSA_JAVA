import java.util.Scanner;

public class queue {
    private int front;
    private int rear;
    private int arr[];
    private int capacity;

    queue(int size) {
        this.front = this.rear = -1;
        this.capacity = size;
        this.arr = new int[size];
    }

    public void enqueue(int data) {
        if (rear == capacity - 1) {
            System.out.print("Queue Overflow!");
            return;
        }
        rear++;
        arr[rear] = data;
        System.out.println(data + " Inserted Successfully!");
    }

    public void dequeue() {
        if (rear == front) {
            System.out.print("Queue Underflow!");
            return;
        }
        front++;
        System.out.println(arr[front] + " Deleted Successfully!");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        queue q = new queue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);

        s.close();
    }
}
