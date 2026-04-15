import java.util.Set; //  //aturan bahwa data tidak boleh kembar
import java.util.TreeSet; //agar datanya nanti urut

public class LatihanCollection {
    public static void main(String[] args) {
        // TreeSet otomatis mengurutkan abjad dan menghilangkan duplikat
        Set<String> daftarBuku = new TreeSet<>(); // daftarBuku Adalah nama variabel (wadah) yang kita buat.
        //<String>: Menandakan bahwa wadah ini khusus hanya untuk menyimpan teks.
        //treeset agar data yang keluar nanti urut

        // Memasukkan data dari soal (termasuk yang duplikat)
        daftarBuku.add("Dilan 1990");
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Mahaguru");
        daftarBuku.add("Mengejar Matahari");
        daftarBuku.add("Dilan 1991");
        daftarBuku.add("Milea");
        daftarBuku.add("Perahu Kertas");
        daftarBuku.add("Laskar Pelangi"); 
        daftarBuku.add("Perahu Kertas");

        // Menampilkan hasil menggunakan iteration
        System.out.println("Daftar Buku:");
        int nomor = 1;
        for (String buku : daftarBuku) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
        
    }
}