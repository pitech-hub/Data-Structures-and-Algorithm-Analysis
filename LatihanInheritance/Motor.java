// 3. SUBCLASS Motor menggunakan keyword EXTENDS
public class Motor extends Kendaraan {
    // State spesifik Motor
    boolean adaBagasi;

    // Constructor Subclass
    public Motor(String merek, int tahun, boolean adaBagasi) {
        // Keyword SUPER: Memanggil constructor dari Superclass
        super(merek, tahun); 
        this.adaBagasi = adaBagasi;
    }

    // Method spesifik Motor
    public void wheelie() {
        System.out.println("Motor " + merek + " melakukan wheelie!");
    }

    // OVERRIDING: Memodifikasi method dari Superclass
    @Override
    public void info() {
        super.info(); // Memanggil method info() dari Superclass
        System.out.println("Jenis: Motor | Ada Bagasi: " + (adaBagasi ? "Ya" : "Tidak"));
    }
}