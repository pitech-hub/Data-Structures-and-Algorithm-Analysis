class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Menambahkan di depan (Head)
    public void insertHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Menambahkan di belakang (Tail)
    public void insertTail(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Menambahkan pada posisi tertentu (index dimulai dari 0)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Posisi tidak valid.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Menampilkan Linked List
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
}

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Insert di Tail
        list.insertTail(20);
        list.insertTail(30);

        // Insert di Head
        list.insertHead(10);

        // Insert di posisi index 2
        list.insertAtPosition(25, 2);

        System.out.println("Hasil Singly Linked List:");
        list.display();
    }
}