package abstrak;

public class ResizeableMain {
    public static void main(String[] args) {
        // a. Mendefinisikan objek kotak (panjang = 4, lebar = 5)
        Kotak kotak = new Kotak(4, 5); 

        // b. Cetak luas dan keliling objek (Ukuran awal)
        System.out.println("=== UKURAN AWAL ===");
        System.out.println("Luas Kotak     : " + kotak.getLuas()); 
        System.out.println("Keliling Kotak : " + kotak.getKeliling()); 

        // c. Ubah ukuran panjang dan lebar sebesar 2x dari ukuran semula
        System.out.println("\n--- Melakukan Resize ---");
        kotak.resize(2.0); 

        // d. Cetak kembali luas dan keliling objek (Setelah di-resize)
        System.out.println("\n=== UKURAN SETELAH RESIZE (2x) ===");
        System.out.println("Luas Kotak     : " + kotak.getLuas()); 
        System.out.println("Keliling Kotak : " + kotak.getKeliling()); 
    }
}
