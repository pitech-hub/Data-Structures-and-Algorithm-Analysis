public class ArrayPracticum {
    public static void main(String[] args) {

        // =========================
        // ARRAY 1 DIMENSI - FOR LOOP
        // =========================
        String[] days = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        System.out.println("=== Array 1 Dimensi (For Loop) ===");
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }

        // =========================
        // ARRAY 1 DIMENSI - DO WHILE
        // =========================
        System.out.println("\n=== Array 1 Dimensi (Do-While) ===");

        int j = 0;
        do {
            System.out.println(days[j]);
            j++;
        } while (j < days.length);

        // =========================
        // ARRAY MULTIDIMENSI
        // =========================
        String[][] address = {
                {"Florence", "735-1234", "Manila"},
                {"Joyce", "983-3333", "Quezon City"},
                {"Becca", "456-3322", "Manila"}
        };

        System.out.println("\n=== Buku Alamat Saya ===");

        for (int k = 0; k < address.length; k++) {
            System.out.println("Name : " + address[k][0]);
            System.out.println("Tel. # : " + address[k][1]);
            System.out.println("Address : " + address[k][2]);
            System.out.println();
        }
    }
}