import java.util.Scanner;

public class BankSampah01 {

    static Scanner sc = new Scanner(System.in);

    // membaca berat setoran n nasabah, mengembalikan array
    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== Data Setoran ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double s : setoran) {
            total += s;
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    // indeks nasabah dengan setoran terbesar
    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        final double HARGA_PER_KG = 3000;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n);

        tampilSetoran(setoran);

        System.out.println("\n=== Saldo Nasabah (Rp" + (int) HARGA_PER_KG + "/kg) ===");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah ke-%d: Rp%,.0f%n", (i + 1), saldo);
        }

        System.out.println("\nTotal setoran seluruh nasabah: " + totalSetoran(setoran) + " kg");

        int idx = nasabahTerbanyak(setoran);
        System.out.println("Setoran terbanyak: nasabah ke-" + (idx + 1)
                + " (" + setoran[idx] + " kg)");

        sc.close();
    }
}
