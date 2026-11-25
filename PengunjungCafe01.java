public class PengunjungCafe01 {

    // Fungsi varargs (Pertanyaan 2a: perulangan memakai for-each)
    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    // Pertanyaan 3: parameter biasa (nomorMeja) di depan, varargs di paling akhir
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + " - Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    /*
     * Pertanyaan 3: dua bentuk berikut TIDAK BISA dikompilasi.
     * Hapus tanda komentar satu per satu, lalu catat pesan errornya:
     *
     * a. static void daftarPengunjung(String... namaPengunjung, int nomorMeja) { }
     * b. static void daftarPengunjung(String... namaPengunjung, int... nomorMeja) { }
     */

    // Pertanyaan 4: varargs bertipe int, mengembalikan jumlah seluruh harga
    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        // Langkah 3
        daftarPengunjung("Ali", "Budi", "Citra");

        // Langkah 5
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");

        // Pertanyaan 1: dipanggil tanpa argumen
        System.out.println("\n--- Pertanyaan 1: tanpa argumen ---");
        daftarPengunjung();

        // Pertanyaan 2b: mengirim array langsung
        System.out.println("\n--- Pertanyaan 2b: mengirim array ---");
        String[] tamu = {"Ali", "Budi", "Citra"};
        daftarPengunjung(tamu);

        // Pertanyaan 3: dengan nomor meja
        System.out.println("\n--- Pertanyaan 3: dengan nomor meja ---");
        daftarPengunjung(5, "Hana", "Indra");
        daftarPengunjung(7, "Joko");

        // Pertanyaan 4: uji dengan 1, 3, dan 5 argumen
        System.out.println("\n--- Pertanyaan 4: hitungTotalBelanja ---");
        System.out.println("Total 1 argumen : Rp" + hitungTotalBelanja(15000));
        System.out.println("Total 3 argumen : Rp" + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("Total 5 argumen : Rp" + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}