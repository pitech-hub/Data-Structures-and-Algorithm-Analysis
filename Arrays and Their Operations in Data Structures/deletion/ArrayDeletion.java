public class ArrayDeletion {
    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50};
        int posisiHapus = 2; // Menghapus elemen pada indeks ke-2 (nilai 30)

        System.out.print("Array sebelum dihapus: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Menggeser elemen ke kiri
        for (int i = posisiHapus; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        System.out.print("\nArray setelah dihapus: ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
    }
}