class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;

    // Menambahkan node di akhir
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Menampilkan isi list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 1. Hapus node pertama
    public void deleteBeginning() {
        if (head == null) return;

        head = head.next;

        if (head != null)
            head.prev = null;
    }

    // 2. Hapus node setelah nilai tertentu
    public void deleteAfter(int key) {
        Node temp = head;

        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node deleteNode = temp.next;

        temp.next = deleteNode.next;

        if (deleteNode.next != null)
            deleteNode.next.prev = temp;
    }

    // 3. Hapus node sebelum nilai tertentu
    public void deleteBefore(int key) {
        Node temp = head;

        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null || temp.prev == null)
            return;

        Node deleteNode = temp.prev;

        if (deleteNode.prev == null) {
            head = temp;
            temp.prev = null;
        } else {
            deleteNode.prev.next = temp;
            temp.prev = deleteNode.prev;
        }
    }

    // 4. Hapus pada posisi tertentu (mulai dari 1)
    public void deletePosition(int pos) {
        if (head == null || pos <= 0)
            return;

        if (pos == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; temp != null && i < pos; i++)
            temp = temp.next;

        if (temp == null)
            return;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    // 5. Hapus node terakhir
    public void deleteEnd() {
        if (head == null)
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
    }
}

public class main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);
        list.insertEnd(50);

        System.out.println("Data Awal:");
        list.display();

        list.deleteBeginning();
        System.out.println("\n1. Delete Beginning:");
        list.display();

        list.deleteAfter(30);
        System.out.println("\n2. Delete After Node 30:");
        list.display();

        list.insertEnd(40);
        list.insertEnd(50);

        list.deleteBefore(50);
        System.out.println("\n3. Delete Before Node 50:");
        list.display();

        list.deletePosition(2);
        System.out.println("\n4. Delete Position 2:");
        list.display();

        list.deleteEnd();
        System.out.println("\n5. Delete End:");
        list.display();
    }
}