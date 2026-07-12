class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;

    // Menampilkan isi linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 1. Insert di awal
    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2. Insert di akhir
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // 3. Insert setelah node tertentu
    public void insertAfter(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node " + key + " tidak ditemukan.");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // 4. Insert sebelum node tertentu
    public void insertBefore(int key, int data) {

        if (head == null)
            return;

        if (head.data == key) {
            insertFront(data);
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node " + key + " tidak ditemukan.");
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;
    }

    // 5. Insert pada posisi tertentu (mulai dari posisi 1)
    public void insertPosition(int position, int data) {

        if (position <= 1) {
            insertFront(data);
            return;
        }

        Node temp = head;

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            insertEnd(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }
}

public class main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        // Insert di akhir
        list.insertEnd(20);
        list.insertEnd(40);
        list.insertEnd(60);

        System.out.println("Data Awal:");
        list.display();

        // Insert di depan
        list.insertFront(10);
        System.out.println("\n1. Insert Front (10)");
        list.display();

        // Insert setelah node
        list.insertAfter(20, 30);
        System.out.println("\n2. Insert After 20 (30)");
        list.display();

        // Insert sebelum node
        list.insertBefore(60, 50);
        System.out.println("\n3. Insert Before 60 (50)");
        list.display();

        // Insert pada posisi
        list.insertPosition(3, 25);
        System.out.println("\n4. Insert Position 3 (25)");
        list.display();

        // Insert di akhir
        list.insertEnd(70);
        System.out.println("\n5. Insert End (70)");
        list.display();
    }
}