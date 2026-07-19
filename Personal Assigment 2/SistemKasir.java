import java.util.Scanner;

/**
 * Class Node
 * Menyimpan data satu pelanggan: kode, nama, dan total belanja.
 * Digunakan bersama oleh class Queue maupun class Stack.
 */
class Node {
    String kode;
    String nama;
    double total;
    Node next;

    public Node(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}

/**
 * Class Queue
 * Mengelola antrian pelanggan (FIFO - First In First Out).
 * front = pelanggan paling depan (akan dilayani lebih dulu)
 * rear  = pelanggan paling belakang (baru masuk antrian)
 */
class Queue {
    private Node front;
    private Node rear;
    private int jumlahData;
    private static final int MAX_DATA = 5; // validasi jumlah data <= 5

    public Queue() {
        front = null;
        rear = null;
        jumlahData = 0;
    }

    /**
     * Menambahkan pelanggan baru ke akhir antrian (enqueue).
     */
    public void enqueue(String kode, String nama, double total) {
        if (jumlahData >= MAX_DATA) {
            System.out.println("Antrian penuh! Maksimal " + MAX_DATA + " pelanggan.");
            return;
        }

        Node baru = new Node(kode, nama, total);
        if (rear == null) {
            // Antrian masih kosong
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlahData++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    /**
     * Mengeluarkan pelanggan paling depan dari antrian (dequeue).
     * Mengembalikan Node pelanggan yang dilayani, atau null jika antrian kosong.
     */
    public Node dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada pelanggan untuk dilayani.");
            return null;
        }

        Node dilayani = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian menjadi kosong
        }
        jumlahData--;
        return dilayani;
    }

    /**
     * Menampilkan seluruh pelanggan yang sedang mengantre.
     */
    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian Pelanggan Saat Ini:");
        Node bantu = front;
        while (bantu != null) {
            System.out.println("No: " + bantu.kode
                    + " | Nama: " + bantu.nama
                    + " | Total: " + bantu.total);
            bantu = bantu.next;
        }
    }
}

/**
 * Class Stack
 * Menyimpan riwayat transaksi pelanggan yang sudah dilayani (LIFO - Last In First Out).
 * top = transaksi paling baru berada di paling atas.
 */
class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    /**
     * Menambahkan data transaksi baru ke puncak stack.
     */
    public void push(Node pelanggan) {
        pelanggan.next = top;
        top = pelanggan;
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    /**
     * Menampilkan riwayat transaksi dari yang terbaru ke yang paling lama.
     */
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (Terbaru -> Terlama):");
        Node bantu = top;
        while (bantu != null) {
            System.out.println("No: " + bantu.kode
                    + " | Nama: " + bantu.nama
                    + " | Total: " + bantu.total);
            bantu = bantu.next;
        }
    }
}

/**
 * Class SistemKasir (main class)
 * Menampilkan menu dan menghubungkan Queue (antrian) dengan Stack (riwayat).
 */
public class SistemKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih menu: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan Nomor Antrian: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = scanner.nextDouble();
                    scanner.nextLine();
                    antrian.enqueue(kode, nama, total);
                    break;

                case 2:
                    Node dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("\nMelayani pelanggan " + dilayani.kode
                                + " (" + dilayani.nama + ")");
                        riwayat.push(dilayani);
                    }
                    break;

                case 3:
                    antrian.tampilkanAntrian();
                    break;

                case 4:
                    riwayat.tampilkanRiwayat();
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
