package algorithm.forjava.chap07;

public class Heap {

    public int[] array;
    public int count;
    public int capacity;
    public int heapType;

    public Heap(int capacity, int heapType) {
        this.capacity = capacity;
        this.heapType = heapType;
        this.array = new int[capacity];
    }

    public int parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return i - 1 / 2;
    }
}
