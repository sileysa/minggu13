import java.util.Scanner;

public class VaksinMain {
    public static void main(String[] args) {
        Scanner leli = new Scanner(System.in);
        Vaksinasi vksn = new Vaksinasi();
        int pilih;

        do {
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.println("+++++++++++++++++++++++++++++");
            System.out.print("Pilih Menu: ");
            pilih = leli.nextInt();
            leli.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.print("Nomor Antrian: ");
                    int no = leli.nextInt(); 
                    leli.nextLine();
                    System.out.print("Nama Penerima: ");
                    String nama = leli.nextLine();
                    vksn.enqueue(no, nama);
                    break;
                case 2:
                    vksn.dequeue();
                    break;
                case 3:
                    vksn.print();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 4);
    }
}
