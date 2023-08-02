class stack {
    private int top;
    private int capacity;
    private int arr[];

    stack(int size) {
        this.top = -1;
        this.capacity = size;
        this.arr = new int[size];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isFull())
            System.out.println("Stack is full!");
        else {
            System.out.println("Inserting " + data);
            arr[++top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return 500;
        } else {
            return arr[top--];
        }

    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        stack s = new stack(5);
        s.push(3);
        s.push(3);
        s.push(3);
        s.push(3);
        s.push(3);
        s.printStack();
    }
}
