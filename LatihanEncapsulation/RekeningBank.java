// Class yang menerapkan Encapsulation
public class RekeningBank {
    // 1. INFORMATION HIDING: Variabel dibuat PRIVATE agar tidak bisa diakses langsung dari luar
    private String pemilik;
    private double saldo;

    // Constructor
    public RekeningBank(String pemilik, double saldoAwal) {
        this.pemilik = pemilik;
        if (saldoAwal > 0) {
            this.saldo = saldoAwal;
        } else {
            this.saldo = 0;
        }
    }

    // 2. GETTER: Method public untuk MENGAMBIL nilai variabel private
    public String getPemilik() {
        return pemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    // 3. SETTER: Method public untuk MENGUBAH nilai variabel private (dengan validasi)
    public void setPemilik(String pemilik) {
        if (pemilik != null && !pemilik.isEmpty()) {
            this.pemilik = pemilik;
        } else {
            System.out.println("Nama pemilik tidak boleh kosong!");
        }
    }

    // Method khusus untuk mengubah saldo (Bukan setter biasa, tapi logic bisnis)
    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.println("Setor Rp" + jumlah + " berhasil. Saldo saat ini: Rp" + this.saldo);
        } else {
            System.out.println("Jumlah setor harus lebih dari 0!");
        }
    }

    public void tarik(double jumlah) {
        if (jumlah > 0 && jumlah <= this.saldo) {
            this.saldo -= jumlah;
            System.out.println("Tarik Rp" + jumlah + " berhasil. Saldo saat ini: Rp" + this.saldo);
        } else {
            System.out.println("Penarikan gagal! Saldo tidak mencukupi atau jumlah tidak valid.");
        }
    }
}