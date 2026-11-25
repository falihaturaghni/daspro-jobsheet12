// ============================== PERCOBAAN 1 ==============================================
// public class Kafe01 {
//     //Langkah 2
//     public static void Menu() {
//     System.out.println("===== MENU RESTO KAFE =====");
//     System.out.println("1. Kopi Hitam - Rp 15,000");
//     System.out.println("2. Cappuccino - Rp 20,000");
//     System.out.println("3. Latte - Rp 22,0000");
//     System.out.println("4. Teh Tarik - Rp 12,000");
//     System.out.println("5. Roti Bakar - Rp 10,000");
//     System.out.println("6. Mie Goreng - Rp 18,000");
//     System.out.println("===========================");
//     System.out.println("Silakan pilih menu yang Anda inginkan.");

// }

//  // Pertanyaan 1: Fungsi tanpa parameter yang mengembalikan nilai
//     public static int jumlahMenu() {
//         return 6;
//     }

//     //Langkah 3
//      public static void main(String[] args) {

//         Menu();
       
//         // Pertanyaan 1
//         int total = jumlahMenu();

//         System.out.println("Jumlah menu kafe: " + total);
//     }
// }

// ============================== PERCOBAAN 2 ==============================================
// public class Kafe01 {
//     //Langkah 2
//     public static void Menu(String namaPelanggan, boolean isMember) {
//     System.out.println("Selamat datang, " + namaPelanggan + "!");
    
//     if (isMember) {
//         System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");  
//     }

//     System.out.println("===== MENU RESTO KAFE =====");
//     System.out.println("1. Kopi Hitam - Rp 15,000");
//     System.out.println("2. Cappuccino - Rp 20,000");
//     System.out.println("3. Latte - Rp 22,0000");
//     System.out.println("4. Teh Tarik - Rp 12,000");
//     System.out.println("5. Roti Bakar - Rp 10,000");
//     System.out.println("6. Mie Goreng - Rp 18,000");
//     System.out.println("===========================");
//     System.out.println("Silakan pilih menu yang Anda inginkan.");

// }
//     public static void main(String[] args) {
//         Menu("Andi", false);
//     }

// Langkah 3
//     public static void main(String[] args) {
//         Menu("Andi", true);
//     }
//     dpt diskon

// Langkah 4
//     public static void main(String[] args) {
//         Menu("Andi", false);
//     }

// Pertanyaan 2:
//  public static int hitungTotalHargaNoAbsen(int pilihanMenu, int banyakItem) {
//         int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

//         int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
//         return hargaTotal;
//     }

// Pertanyaan 3:
// Coba 1
// public static void main(String[] args) {
//         Menu();
//     }

// Coba 2
// public static void main(String[] args) {
//     Menu(true, "Andi");
// }
// }

import java.util.Scanner;

public class Kafe01 {

    // Modifikasi 4
    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("Apakah member? (y/n): ");
        String status = sc.nextLine();
        boolean member = status.equalsIgnoreCase("y");

        System.out.print("Masukkan jam kunjung (0-23): ");
        int jam = sc.nextInt();

        Menu(nama, member, jam);
    }

}