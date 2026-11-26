import java.util.Scanner;
public class BioskopWithScanner02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baris, kolom, menu;
        String nama, next;
        String[][] penonton = new String[4][2];

        while (true) {
            System.out.println("\n=== MENU BIOSKOP ===");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih menu (1-3): ");
            menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                while (true) {
                    System.out.print("Masukkan nama: ");
                    nama = sc.nextLine();

                    while (true) {
                        System.out.print("Masukkan baris (1-4): ");
                        baris = sc.nextInt();
                        System.out.print("Masukkan kolom (1-2): ");
                        kolom = sc.nextInt();
                        sc.nextLine();

                        if (baris < 1 || baris > 4 || kolom < 1 || kolom > 2) {
                            System.out.println("Nomor baris/kolom kursi tidak tersedia! Silakan masukkan lagi.");
                        } 

                        else if (penonton[baris - 1][kolom - 1] != null) {
                            System.out.println("Warning: Kursi tersebut sudah terisi oleh " + penonton[baris - 1][kolom - 1] + ". Silakan pilih kursi lain!");
                        } else {
                            penonton[baris - 1][kolom - 1] = nama;
                            break;
                        }
                    }

                    System.out.print("Input penonton lainnya? (y/n): ");
                    next = sc.nextLine();
                    if (next.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else if (menu == 2) {
                System.out.println("\n=== DAFTAR PENONTON ===");
                for (int i = 0; i < penonton.length; i++) {
                    System.out.print("Baris ke-" + (i + 1) + ": ");
                    for (int j = 0; j < penonton[i].length; j++) {
                        String tampil = (penonton[i][j] == null) ? "***" : penonton[i][j];
                        System.out.print(tampil + (j < penonton[i].length - 1 ? ", " : ""));
                    }
                    System.out.println();
                }
            } else if (menu == 3) {
                System.out.println("Program selesai.");
                break;
            } else {
                System.out.println("Pilihan menu tidak valid!");
            }
        }
        sc.close();
    }
}