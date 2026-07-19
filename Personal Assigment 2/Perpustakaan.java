import java.util.Scanner;

/**
 * Class Node
 * Merepresentasikan satu node/simpul pada Single Linked List.
 * Setiap node menyimpan data satu buku dan referensi ke node berikutnya.
 */
class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // referensi ke node berikutnya

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

/**
 * Class LinkedList
 * Mengelola kumpulan Node (daftar buku) dalam bentuk Single Linked List.
 * Menyediakan operasi tambah (push), hapus (pop), cari, dan tampilkan.
 */
class LinkedList {
    private Node head; // penunjuk ke node pertama
    private int jumlahData;

    public LinkedList() {
        this.head = null;
        this.jumlahData = 0;
    }

    /**
     * Menambahkan buku baru di akhir daftar (operasi Push).
     * Validasi: kodeBuku maksimal 5 karakter.
     */
    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Gagal! Kode buku maksimal 5 karakter.");
            return false;
        }

        Node baru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            // Jika daftar masih kosong, node baru menjadi head
            head = baru;
        } else {
            // Telusuri sampai node terakhir, lalu sambungkan
            Node bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = baru;
        }

        jumlahData++;
        System.out.println("Data berhasil ditambahkan!");
        return true;
    }

    /**
     * Menghapus buku terakhir dari daftar (operasi Pop).
     */
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            // Hanya ada satu node
            System.out.println("Buku '" + head.judul + "' berhasil dihapus.");
            head = null;
        } else {
            // Telusuri sampai node kedua dari belakang
            Node bantu = head;
            while (bantu.next.next != null) {
                bantu = bantu.next;
            }
            System.out.println("Buku '" + bantu.next.judul + "' berhasil dihapus.");
            bantu.next = null;
        }
        jumlahData--;
    }

    /**
     * Mencari buku berdasarkan kodeBuku.
     */
    public void cariBuku(String kodeBuku) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode   : " + bantu.kodeBuku);
                System.out.println("Judul  : " + bantu.judul);
                System.out.println("Penulis: " + bantu.penulis);
                return;
            }
            bantu = bantu.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    /**
     * Menampilkan seluruh data buku sesuai urutan input,
     * beserta total jumlah buku.
     */
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku
                    + " | Judul: " + bantu.judul
                    + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + jumlahData);
    }
}

/**
 * Class Perpustakaan (main class)
 * Menampilkan menu dan menerima input pengguna.
 */
public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        int pilihan;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi input angka agar program tidak error saat input bukan angka
            while (!scanner.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih menu: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline sisa input

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;

                case 2:
                    daftarBuku.hapusBuku();
                    break;

                case 3:
                    System.out.print("\nMasukkan Kode Buku: ");
                    String cariKode = scanner.nextLine();
                    daftarBuku.cariBuku(cariKode);
                    break;

                case 4:
                    daftarBuku.tampilkanSemua();
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
