package algorithm.forjava.chap05;

import java.util.EmptyStackException;

public class DynamicArrayQueue {

    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    public DynamicArrayQueue() {
        capacity = 1;
        front = -1;
        rear = -1;
        array = new int[1];
    }

    public static DynamicArrayQueue createQueue() {
        return new DynamicArrayQueue();
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int getQueueSize() {
        if (front == -1) {
            return 0;
        }

        int size = (capacity - front + rear + 1) % capacity;
        return size != 0 ? size : capacity;
    }

    public void resizeQueue() {
        int initCapacity = capacity;
        capacity *= 2;

        int[] oldArray = array;
        array = new int[this.capacity];

        System.arraycopy(oldArray, 0, array, 0, oldArray.length);

        // 꼬리를 가르키는 포인터가 머리 포인터보다 앞서있다면 기존 크기의 인덱스부터 값을 차례대로 쭉 넣는다
        if (rear < front) {
            System.arraycopy(this.array, 0, array, initCapacity, front);
            rear += initCapacity;
        }
    }

    public void enQueue(int data) {
        if (isFull()) {
            resizeQueue();
        } else {
            rear = (rear + 1) % capacity;
            array[rear] = data;
            if (front == -1) {
                front = rear;
            }
        }
    }

    public int deQueue() {
        int data;

        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            data = array[front];
            front = front == rear ? rear - 1 : (front + 1) % capacity;
        }

        return data;
    }
}
