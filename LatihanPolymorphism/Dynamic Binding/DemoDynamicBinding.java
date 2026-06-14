// Parent Class
class Hewan {
    String nama;

    Hewan(String nama) {
        this.nama = nama;
    }

    // Method yang akan di-override
    void suara() {
        System.out.println(nama + " mengeluarkan suara...");
    }

    void info() {
        System.out.println("Ini adalah hewan bernama " + nama);
    }
}

// Child Class 1
class Kucing extends Hewan {

    Kucing(String nama) {
        super(nama);
    }

    // Overriding method suara()
    @Override
    void suara() {
        System.out.println(nama + " mengeong: Miaawww!");
    }
}

// Child Class 2
class Anjing extends Hewan {

    Anjing(String nama) {
        super(nama);
    }

    // Overriding method suara()
    @Override
    void suara() {
        System.out.println(nama + " menggonggong: Guk guk!");
    }
}

// Child Class 3
class Sapi extends Hewan {

    Sapi(String nama) {
        super(nama);
    }

    // Overriding method suara()
    @Override
    void suara() {
        System.out.println(nama + " menguak: Mooo!");
    }
}

public class DemoDynamicBinding {
    public static void main(String[] args) {
        System.out.println("=== DYNAMIC BINDING (OVERRIDING) ===\n");

        // Membuat objek dari masing-masing kelas
        Hewan hewan1 = new Kucing("Kitty");
        Hewan hewan2 = new Anjing("Buddy");
        Hewan hewan3 = new Sapi("Moli");

        // Menyimpan dalam array bertipe parent class
        Hewan[] kumpulanHewan = {hewan1, hewan2, hewan3};

        // Dynamic Binding: method yang dipanggil ditentukan saat RUNTIME
        for (Hewan h : kumpulanHewan) {
            System.out.println("---");
            h.info();        // Method dari parent (tidak di-override)
            h.suara();       // Method dari child (di-override) → Dynamic Binding!
        }

        System.out.println("\n=== PEMBUKTIAN DYNAMIC BINDING ===\n");

        // Referensi bertipe Hewan, tapi objek bertipe Kucing
        Hewan hewanRef = new Kucing("Oren");
        System.out.println("Tipe referensi : Hewan");
        System.out.println("Tipe objek     : Kucing");
        hewanRef.suara(); // Memanggil method Kucing, bukan Hewan!
    }
}