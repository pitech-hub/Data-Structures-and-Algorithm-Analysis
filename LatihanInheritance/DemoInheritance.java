// 4. CLASS MAIN (Program Utama)
public class DemoInheritance {
    public static void main(String[] args) {
        System.out.println("=== DEMO INHERITANCE (PEWARISAN) ===\n");

        // Membuat objek Mobil
        Mobil mobilSaya = new Mobil("Toyota Avanza", 2022, 4);
        System.out.println("--- Data Mobil ---");
        mobilSaya.info();           // Method yang di-override
        mobilSaya.klakson();        // Method warisan dari Kendaraan (Code Reuse!)
        mobilSaya.nyalakanAC();     // Method spesifik Mobil

        System.out.println("\n-----------------------------------\n");

        // Membuat objek Motor
        Motor motorSaya = new Motor("Honda CBR", 2023, true);
        System.out.println("--- Data Motor ---");
        motorSaya.info();           // Method yang di-override
        motorSaya.klakson();        // Method warisan dari Kendaraan (Code Reuse!)
        motorSaya.wheelie();        // Method spesifik Motor
    }
}