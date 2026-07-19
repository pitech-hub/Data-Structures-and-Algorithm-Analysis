class QueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int maxSize;

    public QueueArray(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }

    // Menambahkan data ke queue
    public void enqueue(int data) {
        if (rear == maxSize - 1) {
            System.out.println("Queue Penuh!");
        } else {
            queue[++rear] = data;
            System.out.println(data + " berhasil ditambahkan.");
        }
    }

    // Menghapus data dari queue
    public void dequeue() {
        if (front > rear) {
            System.out.println("Queue Kosong!");
        } else {
            System.out.println("Data yang keluar: " + queue[front]);
            front++;
        }
    }

    // Menampilkan isi queue
    public void display() {
        if (front > rear) {
            System.out.println("Queue Kosong!");
        } else {
            System.out.print("Isi Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        q.display();
    }
}