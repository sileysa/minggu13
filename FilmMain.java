import java.util.Scanner;

public class FilmMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmList list = new FilmList();
        int pilihan;

        do {
            System.out.println("=================================");
            System.out.println("DATA FILM LAYAR LEBAR");
            System.out.println("=================================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film–DESC");
            System.out.println("10. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan Data Film Posisi Awal");
                    int id = inputInt(sc, "ID Film: ");
                    String judul = inputString(sc, "Judul Film: ");
                    double rating = inputDouble(sc, "Rating Film: ");
                    list.addFirst(id, judul, rating);
                case 2:
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    int id = inputInt(sc, "ID Film: ");
                    String judul = inputString(sc, "Judul Film: ");
                    double rating = inputDouble(sc, "Rating Film: ");
                    list.addLast(id, judul, rating);
                case 3:
                    System.out.println("Masukkan Data Film di Index Tertentu");
                    int id = inputInt(sc, "ID Film: ");
                    String judul = inputString(sc, "Judul Film: ");
                    double rating = inputDouble(sc, "Rating Film: ");
                    int index = inputInt(sc, "Index: ");
                    list.addAt(index, id, judul, rating);
                case 4:
                    list.removeFirst();
                case 5:
                    list.removeLast();
                case 6:
                    int index = inputInt(sc, "Index yang ingin dihapus: ");
                    list.removeAt(index);
                case 7:
                    list.print();
                case 8:
                    int id = inputInt(sc, "Masukkan ID Film: ");
                    list.searchById(id);
                case 9:
                    list.sortByRatingDescending();
                    System.out.println("Data berhasil diurutkan secara descending berdasarkan rating.");
                case 10:
                System.out.println("Terima kasih!");
                default:
                System.out.println("Pilihan tidak valid.");
            }

            System.out.println();
        } while (pilihan != 10);
    }

    public static int inputInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double inputDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine());
    }
}