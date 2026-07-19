public class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Menambahkan data
    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue Penuh!");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println(data + " berhasil ditambahkan.");
    }

    // Menghapus data
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue Kosong!");
            return;
        }

        System.out.println("Data keluar: " + queue[front]);
        front = (front + 1) % capacity;
        size--;
    }

    // Menampilkan isi queue
    public void display() {
        if (size == 0) {
            System.out.println("Queue Kosong!");
            return;
        }

        System.out.print("Isi Circular Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        cq.display();

        cq.dequeue();
        cq.dequeue();

        cq.display();

        cq.enqueue(50);
        cq.enqueue(60);

        cq.display();
    }
}