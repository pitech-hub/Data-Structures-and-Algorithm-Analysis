class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head = null;
    Node tail = null;

    // Menambah node di akhir
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // membentuk lingkaran
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Menampilkan isi Circular Linked List
    public void display() {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(kembali ke head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.add(10);
        cll.add(20);
        cll.add(30);
        cll.add(40);

        System.out.println("Circular Linked List:");
        cll.display();
    }
}