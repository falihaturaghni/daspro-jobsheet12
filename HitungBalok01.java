import java.util.Scanner;

public class HitungBalok01 {

    // ===================== VERSI TANPA FUNGSI (Pertanyaan 1) =====================
    // Semua rumus ditulis langsung. Jika perlu dipakai lagi, harus disalin ulang.
    static void versiTanpaFungsi(int p, int l, int t) {
        int L = p * l;
        System.out.println("Luas persegi panjang adalah " + L);
        int vol = p * l * t;
        System.out.println("Volume balok adalah " + vol);
    }

    // ===================== VERSI DENGAN FUNGSI (Langkah 3) =====================
    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    // hitungVolume memanggil hitungLuas, lalu dikalikan tinggi.
    // CATATAN: urutan parameter (tinggi, a, b) -> panggil dengan (t, p, l)
    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    // ===================== PERTANYAAN 2: LacakFungsi =====================
    static int kali2(int x) {
        return x * 2;
    }

    static int tambah(int a, int b) {
        return a + b;
    }

    static void cetak(int n) {
        for (int i = n; i > 0; i -= 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void lacakFungsi() {
        int a = kali2(3);               // kali2(3) = 6      -> a = 6
        int b = tambah(a, kali2(1));    // tambah(6, 2) = 8  -> b = 8
        cetak(b);                       // cetak(8) -> 8 6 4 2
        cetak(tambah(b, -a) + 1);       // tambah(8, -6) = 2, +1 = 3 -> cetak(3) -> 3 1
    }

    // ===================== PERTANYAAN 3: urutan argumen =====================
    // Fungsi pembanding: hasilnya BERUBAH jika urutan argumen tertukar.
    static int kurang(int a, int b) {
        return a - b;
    }

    // ===================== PERTANYAAN 4: luas permukaan =====================
    // Rumus: 2 x (pl + pt + lt), memanfaatkan hitungLuas.
    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    // Menampilkan hasil satu balok, dipakai 3 kali (tidak perlu menyalin rumus).
    static void tampilBalok(int no, int p, int l, int t) {
        System.out.println("Balok " + no + " (p=" + p + ", l=" + l + ", t=" + t + ")");
        System.out.println("  Luas permukaan: " + hitungLuasPermukaanBalok(p, l, t));
        System.out.println("  Volume        : " + hitungVolume(t, p, l));
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, l, t, L, vol;

        System.out.println("Masukkan panjang");
        p = input.nextInt();

        System.out.println("Masukkan lebar");
        l = input.nextInt();

        System.out.println("Masukkan tinggi");
        t = input.nextInt();

        // Langkah 2 / Pertanyaan 1: versi tanpa fungsi
        System.out.println("\n=== Versi TANPA fungsi ===");
        versiTanpaFungsi(p, l, t);

        // Langkah 3-4 / Pertanyaan 1: versi dengan fungsi
        System.out.println("\n=== Versi DENGAN fungsi ===");
        L = hitungLuas(p, l);
        System.out.println("Luas Persegi Panjang adalah " + L);
        vol = hitungVolume(t, p, l);
        System.out.println("Volume Balok adalah " + vol);

        // Pertanyaan 2
        System.out.println("\n=== Pertanyaan 2: LacakFungsi ===");
        lacakFungsi();

        // Pertanyaan 3
        System.out.println("\n=== Pertanyaan 3: urutan argumen ===");
        System.out.println("hitungVolume(t, p, l) = " + hitungVolume(t, p, l));
        System.out.println("hitungVolume(p, l, t) = " + hitungVolume(p, l, t));
        System.out.println("kurang(10, 3) = " + kurang(10, 3));
        System.out.println("kurang(3, 10) = " + kurang(3, 10));

        // Pertanyaan 4
        System.out.println("\n=== Pertanyaan 4: tiga balok ===");
        tampilBalok(1, 4, 3, 5);
        tampilBalok(2, 6, 2, 3);
        tampilBalok(3, 10, 5, 2);

        input.close();
    }
}



// // ===================== PERTANYAAN 2 =====================
// public class LacakFungsi {
//     static int kali2(int x) {
//         return x * 2;
//     }

//     static int tambah(int a, int b) {
//         return a + b;
//     }

//     static void cetak(int n) {
//         for (int i = n; i > 0; i -= 2) {
//             System.out.print(i + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int a = kali2(3);
//         int b = tambah(a, kali2(1));
//         cetak(b);
//         cetak(tambah(b, -a) + 1);
//     }
// }