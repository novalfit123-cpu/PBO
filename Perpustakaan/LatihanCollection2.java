import java.util.Set;
import java.util.TreeSet;

public class LatihanCollection2 {
    public static void main(String[] args) {
        // Membuat collection dan menambahkan data seperti di Latihan 1
        Set<String> daftarBuku = new TreeSet<>();

        daftarBuku.add("Dilan 1990");
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Mahaguru");
        daftarBuku.add("Mengejar Matahari");
        daftarBuku.add("Dilan 1991");
        daftarBuku.add("Milea");
        daftarBuku.add("Perahu Kertas");
        daftarBuku.add("Laskar Pelangi"); 
        daftarBuku.add("Perahu Kertas");

        // 1. Menampilkan daftar buku awal
        System.out.println("Daftar Buku secara Urut:");
        int nomor = 1;
        for (String buku : daftarBuku) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
        
        System.out.println(); // Memberikan baris kosong agar rapi sesuai output di soal

        // 2. Mengecek apakah buku "Mahaguru" ada
        if (daftarBuku.contains("Mahaguru")) {
            System.out.println("Buku Mahaguru ada\n"); // \n untuk baris kosong ekstra
            
            // 3. Menghapus buku dari daftar karena dipinjam
            daftarBuku.remove("Mahaguru");
        }

        // 4. Menampilkan daftar buku setelah dipinjam (looping for tanpa index)
        System.out.println("Daftar Buku setelah Mahaguru dipinjam:");
        nomor = 1; // Reset nomor urut kembali ke 1
        for (String buku : daftarBuku) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
    }
}