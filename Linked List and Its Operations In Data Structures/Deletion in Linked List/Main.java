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

    // Menambahkan node di akhir
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

    // Menghapus node pertama
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Linked List kosong.");
            return;
        }

        head = head.next;
    }

    // Menghapus node pada posisi tertentu (index dimulai dari 0)
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked List kosong.");
            return;
        }

        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Posisi tidak valid.");
            return;
        }

        current.next = current.next.next;
    }

    // Menghapus node terakhir
    public void deleteLast() {
        if (head == null) {
            System.out.println("Linked List kosong.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
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

        list.insertTail(10);
        list.insertTail(20);
        list.insertTail(30);
        list.insertTail(40);
        list.insertTail(50);

        System.out.println("Data awal:");
        list.display();

        list.deleteFirst();
        System.out.println("Setelah menghapus node pertama:");
        list.display();

        list.deleteAtPosition(1);
        System.out.println("Setelah menghapus node di tengah:");
        list.display();

        list.deleteLast();
        System.out.println("Setelah menghapus node terakhir:");
        list.display();
    }
}