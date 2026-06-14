// Class Main untuk menjalankan program
public class DemoEncapsulation {
    public static void main(String[] args) {
        System.out.println("=== DEMO ENCAPSULATION ===\n");

        RekeningBank rek1 = new RekeningBank("Budi", 5000000);

        // Mengakses data melalui GETTER (Read)
        System.out.println("Pemilik Rekening : " + rek1.getPemilik());
        System.out.println("Saldo Awal       : Rp" + rek1.getSaldo());
        System.out.println("---------------------------------");

        // Mengubah data melalui METHOD YANG DIIJINKAN (Write with Logic)
        rek1.setor(1500000);
        rek1.tarik(2000000);
        System.out.println("---------------------------------");

        // CONTOH VALIDASI: Mencoba tarik uang melebihi saldo
        System.out.println("\nMencoba tarik uang melebihi saldo:");
        rek1.tarik(10000000);
        
        System.out.println("\nMencoba set nama pemilik kosong:");
        rek1.setPemilik(""); // Validasi di setter akan menolak ini
    }
}