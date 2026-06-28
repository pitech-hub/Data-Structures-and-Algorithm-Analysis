public class ArrayInsertion {
    public static void main(String[] args) {

        // Array dengan kapasitas lebih besar
        int[] array = new int[6];
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        array[3] = 40;
        array[4] = 50;

        int jumlahElemen = 5;
        int posisiSisip = 2; // Menyisipkan pada indeks ke-2
        int nilaiBaru = 25;

        System.out.print("Array sebelum penyisipan: ");
        for (int i = 0; i < jumlahElemen; i++) {
            System.out.print(array[i] + " ");
        }

        // Geser elemen ke kanan
        for (int i = jumlahElemen; i > posisiSisip; i--) {
            array[i] = array[i - 1];
        }

        // Sisipkan elemen baru
        array[posisiSisip] = nilaiBaru;
        jumlahElemen++;

        System.out.print("\nArray setelah penyisipan: ");
        for (int i = 0; i < jumlahElemen; i++) {
            System.out.print(array[i] + " ");
        }
    }
}