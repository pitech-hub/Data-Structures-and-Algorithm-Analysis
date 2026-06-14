// 2. SUBCLASS Mobil menggunakan keyword EXTENDS
public class Mobil extends Kendaraan {
    // State spesifik yang HANYA dimiliki Mobil
    int jumlahPintu;

    // Constructor Subclass
    public Mobil(String merek, int tahun, int jumlahPintu) {
        // Keyword SUPER: Memanggil constructor dari Superclass
        super(merek, tahun); 
        this.jumlahPintu = jumlahPintu;
    }

    // Method spesifik HANYA untuk Mobil
    public void nyalakanAC() {
        System.out.println("AC Mobil " + merek + " dinyalakan... Dingin!");
    }

    // OVERRIDING: Memodifikasi method dari Superclass
    @Override
    public void info() {
        super.info(); // Memanggil method info() dari Superclass
        System.out.println("Jenis: Mobil | Jumlah Pintu: " + jumlahPintu);
    }
}