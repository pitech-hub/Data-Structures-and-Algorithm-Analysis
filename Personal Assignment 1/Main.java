import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // =============================================
        // SOAL 1: Buat 5 objek Mahasiswa dan simpan
        //         ke dalam array (OOP + Array)
        // =============================================
        Mahasiswa[] daftar = new Mahasiswa[5];

        // Inisialisasi data 5 mahasiswa menggunakan constructor
        daftar[0] = new Mahasiswa("Andi Pratama",   "2440001", "Teknik Informatika", 3.75);
        daftar[1] = new Mahasiswa("Budi Santoso",   "2440002", "Sistem Informasi",   3.40);
        daftar[2] = new Mahasiswa("Citra Lestari",  "2440003", "Teknik Informatika", 3.90);
        daftar[3] = new Mahasiswa("Joni Suhartono", "2440004", "Teknik Industri",    3.00);
        daftar[4] = new Mahasiswa("Sucipto",     "2440005", "Akuntansi",          3.20);

        // Gunakan loop untuk menampilkan seluruh data mahasiswa (Soal 1)
        System.out.println("=== SOAL 1: Data Mahasiswa ===");
        for (Mahasiswa m : daftar) {
            System.out.println("=== Data Mahasiswa ===");
            m.tampilkanInfo();
            System.out.println();
        }

        // =============================================
        // SOAL 2: Enkapsulasi, Getter/Setter,
        //         cekKelulusan(), dan updateIpk()
        // =============================================
        System.out.println("=== SOAL 2: Update IPK & Cek Kelulusan ===");

        // Gunakan Scanner untuk input dari pengguna
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.next();  

        System.out.print("Masukkan IPK baru: ");
        double ipkBaru = scanner.nextDouble();

        // Cari mahasiswa berdasarkan NIM menggunakan loop
        boolean ditemukan = false;
        for (Mahasiswa m : daftar) {
            if (m.getNim().equals(nimInput)) {
                m.updateIpk(ipkBaru);   // perbarui IPK via method
                System.out.println("Data berhasil diperbarui!");
                System.out.println("=== Data Mahasiswa ===");
                m.tampilkanInfo();
                m.cekKelulusan();       // tampilkan status kelulusan
                ditemukan = true;
                System.out.println();
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("NIM tidak ditemukan dalam sistem.");
        }

        // =============================================
        // SOAL 3: Predikat Akademik (hitungPredikat())
        // Tampilkan data lengkap semua mahasiswa
        // beserta status kelulusan dan predikatnya
        // =============================================
        System.out.println("=== SOAL 3: Predikat Akademik Semua Mahasiswa ===");
        for (Mahasiswa m : daftar) {
            System.out.println("=== Data Mahasiswa ===");
            m.tampilkanInfo();
            m.cekKelulusan();       // status kelulusan
            m.hitungPredikat();     // predikat akademik
            System.out.println();
        }

        scanner.close();
    }
}