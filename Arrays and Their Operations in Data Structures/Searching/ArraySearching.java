import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50};
        int target = 30;

        // ===== Linear Search =====
        int indexLinear = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                indexLinear = i;
                break;
            }
        }

        if (indexLinear != -1) {
            System.out.println("Linear Search:");
            System.out.println("Data " + target + " ditemukan pada indeks ke-" + indexLinear);
        } else {
            System.out.println("Linear Search:");
            System.out.println("Data tidak ditemukan");
        }

        // ===== Binary Search =====
        int indexBinary = Arrays.binarySearch(array, target);

        if (indexBinary >= 0) {
            System.out.println("\nBinary Search:");
            System.out.println("Data " + target + " ditemukan pada indeks ke-" + indexBinary);
        } else {
            System.out.println("\nBinary Search:");
            System.out.println("Data tidak ditemukan");
        }
    }
}