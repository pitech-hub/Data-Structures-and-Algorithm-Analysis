/**
 * ============================================================
 * TUGAS KELOMPOK 1 - COSC6025 Data Structures and Algorithm Analysis
 * Week 3: Introduction to OOP & Data Structures
 *
 * Nama Kelompok:
 * 1. AHMAD ANDI NUGROHO - 2902792355
 * 2. LYNATU KHOIRINNISA - 2902785980
 * 3. NAURA ZULWINDA PUTRI - 2902783602
 * 4. INDAH TRI PRAESTI - 2902795395
 * 
 * Deskripsi:
 * Program sistem manajemen playlist musik sederhana menggunakan
 * konsep OOP (Enkapsulasi, Inheritance, Polymorphism) dan array
 * untuk menyimpan kumpulan objek lagu.
 * ============================================================
 */

// ============================================================
// CLASS LAGU
// Merepresentasikan setiap lagu dalam playlist dengan atribut
// judul, artis, dan durasi (dalam menit).
// ============================================================
class Lagu {
    // Enkapsulasi: atribut dibuat private agar tidak bisa diakses langsung dari luar
    private String judul;
    private String artis;
    private double durasi;

    /**
     * Constructor: menginisialisasi objek Lagu dengan nilai awal.
     * Dipanggil saat membuat objek Lagu baru.
     */
    public Lagu(String judul, String artis, double durasi) {
        this.judul  = judul;
        this.artis  = artis;
        this.durasi = durasi;
    }

    // --- Getter: mengambil nilai atribut private ---

    /** Mengembalikan judul lagu */
    public String getJudul()  { return judul; }

    /** Mengembalikan nama artis lagu */
    public String getArtis()  { return artis; }

    /** Mengembalikan durasi lagu (dalam menit) */
    public double getDurasi() { return durasi; }

    // --- Setter: mengubah nilai atribut private ---

    /** Mengubah judul lagu */
    public void setJudul(String judul)   { this.judul  = judul; }

    /** Mengubah nama artis lagu */
    public void setArtis(String artis)   { this.artis  = artis; }

    /** Mengubah durasi lagu */
    public void setDurasi(double durasi) { this.durasi = durasi; }

    /**
     * Menampilkan informasi lengkap tentang sebuah lagu.
     * Format: Judul | Artis | Durasi
     */
    public void tampilkanInfo() {
        System.out.printf("  %-30s | %-20s | %.2f menit%n", judul, artis, durasi);
    }
}


// ============================================================
// CLASS USER (Parent / Superclass)
// Menyimpan identitas pengguna sistem (nama dan role).
// Menjadi dasar untuk class Admin dan class Member.
// ============================================================
class User {
    // Atribut protected agar bisa diakses oleh child class
    protected String nama;
    protected String role;

    /**
     * Constructor User: menerima nama dan role pengguna.
     */
    public User(String nama, String role) {
        this.nama = nama;
        this.role = role;
    }

    /**
     * Method tampilkanAkses() di parent class bersifat umum.
     * Akan di-override (polymorphism) oleh setiap child class
     * sesuai hak akses masing-masing peran.
     */
    public void tampilkanAkses() {
        System.out.println("User: " + nama + " | Role: " + role);
    }
}


// ============================================================
// CLASS ADMIN (Child class dari User)
// Inheritance: mewarisi atribut dan method dari User.
// Admin memiliki kemampuan tambahan: menambahkan lagu ke playlist.
// ============================================================
class Admin extends User {

    /**
     * Constructor Admin: memanggil constructor User dengan role "Admin".
     */
    public Admin(String nama) {
        super(nama, "Admin");
    }

    /**
     * Polymorphism: override method tampilkanAkses() dari User.
     * Menampilkan hak akses khusus Admin (lebih luas dari Member).
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("[ ADMIN ] " + nama + " memiliki akses: Tambah Lagu, Lihat Semua Lagu.");
    }

    /**
     * Method khusus Admin: menambahkan lagu baru ke dalam array playlist.
     *
     * Logika:
     * - Menerima array playlist, jumlah lagu saat ini, dan lagu baru.
     * - Memeriksa apakah kapasitas array masih mencukupi.
     * - Jika iya, memasukkan lagu baru ke indeks berikutnya dan mengembalikan
     *   jumlah lagu yang sudah diperbarui.
     *
     * @param playlist   Array penyimpan lagu
     * @param jumlahLagu Jumlah lagu yang sudah ada saat ini
     * @param lagBaru    Objek Lagu yang ingin ditambahkan
     * @return           Jumlah lagu setelah penambahan
     */
    public int tambahLagu(Lagu[] playlist, int jumlahLagu, Lagu lagBaru) {
        if (jumlahLagu >= playlist.length) {
            System.out.println("  [!] Playlist penuh! Kapasitas maksimal: " + playlist.length + " lagu.");
            return jumlahLagu;
        }
        playlist[jumlahLagu] = lagBaru;
        jumlahLagu++;
        System.out.println("  [+] Lagu \"" + lagBaru.getJudul() + "\" berhasil ditambahkan.");
        return jumlahLagu;
    }

    /**
     * Method khusus Admin: menampilkan seluruh lagu dalam playlist.
     *
     * Logika:
     * - Iterasi array dari indeks 0 hingga jumlahLagu - 1.
     * - Memanggil tampilkanInfo() pada setiap objek Lagu.
     *
     * @param playlist   Array penyimpan lagu
     * @param jumlahLagu Jumlah lagu yang tersimpan
     */
    public void lihatSemuaLagu(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            System.out.println("  [!] Playlist masih kosong.");
            return;
        }
        System.out.printf("  %-30s | %-20s | %s%n", "JUDUL", "ARTIS", "DURASI");
        System.out.println("  " + "-".repeat(65));
        for (int i = 0; i < jumlahLagu; i++) {
            playlist[i].tampilkanInfo();
        }
    }
}


// ============================================================
// CLASS MEMBER (Child class dari User)
// Inheritance: mewarisi atribut dan method dari User.
// Member dapat menelusuri lagu dan melihat detail lagu tertentu.
// ============================================================
class Member extends User {

    /**
     * Constructor Member: memanggil constructor User dengan role "Member".
     */
    public Member(String nama) {
        super(nama, "Member");
    }

    /**
     * Polymorphism: override method tampilkanAkses() dari User.
     * Menampilkan hak akses Member (lebih terbatas dibanding Admin).
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("[ MEMBER ] " + nama + " memiliki akses: Lihat Lagu, Cari Lagu, Hitung Rata-rata Durasi.");
    }

    /**
     * Method khusus Member: mencari lagu berdasarkan judul (case-insensitive).
     *
     * Logika:
     * - Iterasi seluruh lagu dalam array.
     * - Membandingkan judul lagu (lowercase) dengan keyword pencarian (lowercase).
     * - Jika ditemukan, tampilkan info lagu tersebut.
     * - Jika tidak ditemukan, tampilkan pesan tidak ditemukan.
     *
     * @param playlist   Array penyimpan lagu
     * @param jumlahLagu Jumlah lagu yang tersimpan
     * @param keyword    Kata kunci pencarian judul
     */
    public void cariLagu(Lagu[] playlist, int jumlahLagu, String keyword) {
        boolean ditemukan = false;
        System.out.println("  Hasil pencarian untuk: \"" + keyword + "\"");
        System.out.println("  " + "-".repeat(65));
        for (int i = 0; i < jumlahLagu; i++) {
            // Pencarian case-insensitive menggunakan toLowerCase()
            if (playlist[i].getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                playlist[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("  [!] Lagu dengan judul \"" + keyword + "\" tidak ditemukan.");
        }
    }

    /**
     * Method khusus Member: menghitung rata-rata durasi semua lagu.
     *
     * Logika:
     * - Menjumlahkan seluruh nilai durasi dari setiap lagu dalam array.
     * - Membagi total durasi dengan jumlah lagu.
     * - Menampilkan hasil rata-rata.
     *
     * @param playlist   Array penyimpan lagu
     * @param jumlahLagu Jumlah lagu yang tersimpan
     */
    public void hitungRataRataDurasi(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            System.out.println("  [!] Tidak ada lagu dalam playlist.");
            return;
        }
        double total = 0;
        for (int i = 0; i < jumlahLagu; i++) {
            total += playlist[i].getDurasi();
        }
        double rataRata = total / jumlahLagu;
        System.out.printf("  Total Durasi   : %.2f menit%n", total);
        System.out.printf("  Jumlah Lagu    : %d lagu%n", jumlahLagu);
        System.out.printf("  Rata-rata Durasi: %.2f menit%n", rataRata);
    }
}


// ============================================================
// CLASS MAIN — PlaylistOOP
// Entry point program. Mendemonstrasikan seluruh fitur sistem.
// ============================================================
public class PlaylistOOP {

    public static void main(String[] args) {

        // --- Inisialisasi array playlist dengan kapasitas 10 lagu ---
        // Array digunakan sebagai struktur data utama untuk menyimpan objek Lagu.
        final int KAPASITAS = 10;
        Lagu[] playlist  = new Lagu[KAPASITAS];
        int jumlahLagu   = 0; // Menyimpan jumlah lagu aktif dalam array

        // --- Membuat objek Admin dan Member ---
        Admin  admin  = new Admin("Budi");
        Member member = new Member("Siti");

        System.out.println("=".repeat(70));
        System.out.println("       SISTEM MANAJEMEN PLAYLIST MUSIK - OOP & Data Structures");
        System.out.println("=".repeat(70));

        // --------------------------------------------------------
        // DEMONSTRASI POLYMORPHISM
        // Method tampilkanAkses() dipanggil pada tipe referensi User,
        // namun perilakunya berbeda tergantung objek sesungguhnya
        // (Admin atau Member) — inilah polymorphism.
        // --------------------------------------------------------
        System.out.println("\n>> HAK AKSES PENGGUNA (Polymorphism)");
        System.out.println("-".repeat(70));
        User[] users = { admin, member };
        for (User u : users) {
            u.tampilkanAkses(); // Polymorphism: setiap class mengimplementasikan berbeda
        }

        // --------------------------------------------------------
        // ADMIN: Menambahkan lagu ke dalam playlist
        // --------------------------------------------------------
        System.out.println("\n>> ADMIN - Menambahkan Lagu ke Playlist");
        System.out.println("-".repeat(70));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Blinding Lights",    "The Weeknd",         3.20));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Shape of You",       "Ed Sheeran",         3.53));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Levitating",         "Dua Lipa",           3.23));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Dynamite",           "BTS",                3.19));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Peaches",            "Justin Bieber",      3.18));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Stay",               "The Kid LAROI",      2.21));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Butter",             "BTS",                2.45));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Good 4 U",           "Olivia Rodrigo",     2.58));

        // --------------------------------------------------------
        // ADMIN: Menampilkan semua lagu
        // --------------------------------------------------------
        System.out.println("\n>> ADMIN - Daftar Semua Lagu");
        System.out.println("-".repeat(70));
        admin.lihatSemuaLagu(playlist, jumlahLagu);

        // --------------------------------------------------------
        // MEMBER: Mencari lagu berdasarkan judul
        // --------------------------------------------------------
        System.out.println("\n>> MEMBER - Mencari Lagu (keyword: \"BTS\")");
        System.out.println("-".repeat(70));
        member.cariLagu(playlist, jumlahLagu, "BTS");

        System.out.println("\n>> MEMBER - Mencari Lagu (keyword: \"Blinding\")");
        System.out.println("-".repeat(70));
        member.cariLagu(playlist, jumlahLagu, "Blinding");

        System.out.println("\n>> MEMBER - Mencari Lagu (keyword: \"Coldplay\")");
        System.out.println("-".repeat(70));
        member.cariLagu(playlist, jumlahLagu, "Coldplay");

        // --------------------------------------------------------
        // MEMBER: Menghitung rata-rata durasi
        // --------------------------------------------------------
        System.out.println("\n>> MEMBER - Rata-rata Durasi Lagu");
        System.out.println("-".repeat(70));
        member.hitungRataRataDurasi(playlist, jumlahLagu);

        System.out.println("\n" + "=".repeat(70));
        System.out.println("  Program selesai. Terima kasih!");
        System.out.println("=".repeat(70));
    }
}