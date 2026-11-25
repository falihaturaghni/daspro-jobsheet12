import java.util.Scanner;

public class RekapLaundry01 {

    static Scanner sc = new Scanner(System.in);

    // ---------------------------------------------------------------
    // INPUT
    // ---------------------------------------------------------------

    // [BEDA 3b] Fungsi baru: hanya dipakai di mode 2 (nama & harga dari input)
    static void inputLayanan(String[] layanan, int[] hargaPerKg) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg untuk " + layanan[i] + ": ");
            hargaPerKg[i] = Integer.parseInt(sc.nextLine().trim());
        }
    }

    // [BEDA 3b] Fungsi baru: nama hari dibuat otomatis "Hari ke-1", "Hari ke-2", ...
    static String[] buatNamaHari(int jmlHari) {
        String[] hari = new String[jmlHari];
        for (int j = 0; j < jmlHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }
        return hari;
    }

    // [3a & 3b] Input berat cucian. Baris = layanan, kolom = hari.
    // [BEDA 3b] Batas loop memakai data.length & data[i].length (bukan angka 4 dan 6)
    static void inputData(int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("\nLayanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian " + hari[j] + " (kg): ");
                data[i][j] = Integer.parseInt(sc.nextLine().trim());
            }
        }
    }

    // ---------------------------------------------------------------
    // TAMPIL & HITUNG (logika sama di 3a dan 3b)
    // ---------------------------------------------------------------

    static void tampilData(int[][] data, String[] layanan, int[] hargaPerKg, String[] hari) {
        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        System.out.printf("%-16s %-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-10s", h);
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-16s Rp%-8d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    // total berat satu layanan selama semua hari
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan cucian terbanyak: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    // mengembalikan indeks hari dengan total berat (semua layanan) terbesar
    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > totalMax) {
                totalMax = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] hargaPerKg) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            long pendapatan = (long) totalPerLayanan(data, i) * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-16s: Rp%,d%n", layanan[i], pendapatan);
        }
        System.out.printf("%-16s: Rp%,d%n", "TOTAL", totalPendapatan);
    }

    // ---------------------------------------------------------------
    // MAIN
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== REKAP LAUNDRY PAK RUDI ===");
        System.out.println("1. Mode 3(a): data tetap (4 layanan, 6 hari)");
        System.out.println("2. Mode 3(b): jumlah layanan/hari, nama & harga dari input");
        System.out.print("Pilih mode: ");
        int mode = Integer.parseInt(sc.nextLine().trim());

        String[] layanan;
        int[] hargaPerKg;
        String[] hari;
        int[][] data;

        if (mode == 1) {
            // ---------- 3(a): semua ukuran & isi dituliskan langsung ----------
            layanan = new String[]{"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
            hargaPerKg = new int[]{6000, 8000, 5000, 12000};
            hari = new String[]{"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
            data = new int[layanan.length][hari.length];
        } else {
            // ---------- [BEDA 3b]: ukuran array ditentukan dari input ----------
            System.out.print("Jumlah layanan: ");
            int jmlLayanan = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Jumlah hari: ");
            int jmlHari = Integer.parseInt(sc.nextLine().trim());

            layanan = new String[jmlLayanan];
            hargaPerKg = new int[jmlLayanan];
            hari = buatNamaHari(jmlHari);
            data = new int[jmlLayanan][jmlHari];

            inputLayanan(layanan, hargaPerKg);
        }

        // ---------- bagian di bawah ini SAMA untuk kedua mode ----------
        inputData(data, layanan, hari);
        tampilData(data, layanan, hargaPerKg, hari);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < data.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: " + hari[hariTersibuk(data)]);
        tampilPendapatan(data, layanan, hargaPerKg);

        sc.close();
    }
}