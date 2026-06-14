// 1. SUPERCLASS (Class Induk/Generik)
public class Kendaraan {
    // State (Atribut) yang akan diwariskan
    String merek;
    int tahun;

    // Constructor Superclass
    public Kendaraan(String merek, int tahun) {
        this.merek = merek;
        this.tahun = tahun;
    }

    // Behaviour (Method) yang akan diwariskan
    public void klakson() {
        System.out.println("Tiiin! Kendaraan " + merek + " membunyikan klakson.");
    }

    public void info() {
        System.out.println("Merek: " + merek + " | Tahun: " + tahun);
    }
}