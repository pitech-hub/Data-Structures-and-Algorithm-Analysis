class Kalkulator {

    // Method tambah dengan 2 parameter int
    int tambah(int a, int b) {
        System.out.println("Method tambah(int, int) dipanggil");
        return a + b;
    }

    // Method tambah dengan 3 parameter int (Overloading)
    int tambah(int a, int b, int c) {
        System.out.println("Method tambah(int, int, int) dipanggil");
        return a + b + c;
    }

    // Method tambah dengan 2 parameter double (Overloading)
    double tambah(double a, double b) {
        System.out.println("Method tambah(double, double) dipanggil");
        return a + b;
    }
}

public class DemoStaticBinding {
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();

        System.out.println("=== STATIC BINDING (OVERLOADING) ===\n");

        System.out.println("Hasil 1: " + k.tambah(5, 10));
        System.out.println();
        System.out.println("Hasil 2: " + k.tambah(5, 10, 15));
        System.out.println();
        System.out.println("Hasil 3: " + k.tambah(3.5, 2.5));
    }
}