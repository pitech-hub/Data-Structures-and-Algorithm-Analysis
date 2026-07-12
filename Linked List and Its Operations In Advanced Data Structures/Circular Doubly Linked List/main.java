class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class CircularDoublyLinkedList {
    Node head = null;

    // Menambah node di akhir
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    // Menampilkan data maju
    public void displayForward() {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        Node temp = head;
        System.out.print("Forward  : ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Menampilkan data mundur
    public void displayBackward() {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        Node temp = head.prev;
        System.out.print("Backward : ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != head.prev);

        System.out.println();
    }

    // Menghapus node berdasarkan nilai
    public void delete(int key) {
        if (head == null)
            return;

        Node current = head;

        do {
            if (current.data == key) {

                // Jika hanya ada satu node
                if (current.next == current) {
                    head = null;
                    return;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;

                if (current == head)
                    head = current.next;

                return;
            }

            current = current.next;

        } while (current != head);
    }
}

public class main {
    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Setelah Insert:");
        list.displayForward();
        list.displayBackward();

        list.delete(20);

        System.out.println("\nSetelah Menghapus 20:");
        list.displayForward();
        list.displayBackward();
    }
}