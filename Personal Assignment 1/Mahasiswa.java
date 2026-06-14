
public class Mahasiswa {

    // Atribut private (enkapsulasi) - tidak bisa diakses langsung dari luar class
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    // =============================================
    // CONSTRUCTOR: menginisialisasi data mahasiswa
    // =============================================
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama    = nama;
        this.nim     = nim;
        this.jurusan = jurusan;
        this.ipk     = ipk;
    }

    // =============================================
    // GETTER & SETTER untuk atribut ipk
    // =============================================
    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Getter NIM agar bisa dicari dari Main
    public String getNim() {
        return nim;
    }

    // =============================================
    // METHOD: menampilkan seluruh info mahasiswa
    // =============================================
    public void tampilkanInfo() {
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.printf ("IPK     : %.2f%n", ipk);
    }

    // =============================================
    // METHOD: mengecek status kelulusan mahasiswa
    // IPK >= 3.00 -> Lulus, IPK < 3.00 -> Belum Lulus
    // =============================================
    public void cekKelulusan() {
        if (ipk >= 3.00) {
            System.out.println("Status  : Lulus");
        } else {
            System.out.println("Status  : Belum Lulus");
        }
    }

    // =============================================
    // METHOD: memperbarui IPK mahasiswa
    // =============================================
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // =============================================
    // METHOD: menentukan predikat akademik
    // berdasarkan rentang nilai IPK
    // =============================================
    public void hitungPredikat() {
        String predikat;
        if (ipk >= 3.75) {
            predikat = "Dengan Pujian";
        } else if (ipk >= 3.50) {
            predikat = "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            predikat = "Memuaskan";
        } else {
            predikat = "Perlu Perbaikan";
        }
        System.out.println("Predikat: " + predikat);
    }
}