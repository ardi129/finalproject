import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class BuahNaga {
    //atribut
    String kodeProduk;
    String namaProduk;
    int stok;
    int harga;

    BuahNaga(String kodeProduk, String namaProduk, int stok, int harga) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.harga = harga;
    }

    public void detailProduk() {
        System.out.println("Kode Produk: " + kodeProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
    }
}

class LaporanPembukuanBuahNaga {
    ArrayList<BuahNaga> daftarBuahNaga = new ArrayList<>();
//insertionsort
    public void sortingInsertionHarga(ArrayList<BuahNaga> arr) {
        int panjangArr = arr.size();
        for (int i = 1; i < panjangArr; i++) {
            BuahNaga kunci = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j).harga > kunci.harga) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, kunci);
        }
        System.out.println("Hasil pengurutan berdasarkan harga:");
         System.out.println("---------------------------------");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).detailProduk();
             System.out.println("---------------------------------");
        }
    }

    public void menuDaftarBuahNaga() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("========= MENU =========");
            System.out.println("1. Tambah Data Buah Naga");
            System.out.println("2. Tampil Data Buah Naga");
            System.out.println("3. Urutkan Data Buah Naga");
            System.out.println("4. Cari Produk");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            try {
                pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan kode produk: ");
                        String kodeProduk = scanner.next();
                        System.out.print("Masukkan nama produk: ");
                        String namaProduk = scanner.next();
                        System.out.print("Masukkan stok: ");
                        int stok = scanner.nextInt();
                        System.out.print("Masukkan harga: ");
                        int harga = scanner.nextInt();

                        BuahNaga buahNaga = new BuahNaga(kodeProduk, namaProduk, stok, harga);
                        daftarBuahNaga.add(buahNaga);
                        break;
                    case 2:
                        System.out.println("Daftar Buah Naga:");
                         System.out.println("---------------------------------");
                        for (int i = 0; i < daftarBuahNaga.size(); i++) {
                            daftarBuahNaga.get(i).detailProduk();
                             System.out.println("---------------------------------");
                        }
                        break;
                    case 3:
                        sortingInsertionHarga(daftarBuahNaga);
                        break;
                    case 4:
                        System.out.print("Masukkan kode produk yang ingin dicari: ");
                        String kodeCari = scanner.next();
                        cariProduk(kodeCari);
                        break;
                    case 0:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan pilihan angka.");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    public void cariProduk(String kodeCari) {
        boolean ditemukan = false;
        for (BuahNaga buahNaga : daftarBuahNaga) {
            if (buahNaga.kodeProduk.equals(kodeCari)) {
                buahNaga.detailProduk();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Produk dengan kode tersebut tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LaporanPembukuanBuahNaga laporan = new LaporanPembukuanBuahNaga();
        laporan.menuDaftarBuahNaga();
    }
}
