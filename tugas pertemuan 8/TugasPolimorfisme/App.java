import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BangunDatar bd;
        Scanner inputan = new Scanner(System.in);
        
        // --- 1. Persegi Panjang ---
        SegiEmpat persegiPanjang = new SegiEmpat();
        bd = persegiPanjang;
        System.out.println("Masukkan Panjang:");
        bd.panjang = inputan.nextDouble();
        
        System.out.println("Masukkan Lebar:");
        bd.lebar = inputan.nextDouble();
        
        bd.cetakLuas("Persegi panjang", bd.luas());
        System.out.println(); // Biar ada jarak di terminal
        
        // --- 2. Segitiga ---
        Segitiga sikusiku = new Segitiga();
        bd = sikusiku;
        
        System.out.println("Masukkan Panjang:");
        bd.panjang = inputan.nextDouble();
        
        System.out.println("Masukkan Tinggi:");
        bd.tinggi = inputan.nextDouble();
        
        bd.cetakLuas("Segitiga siku-siku", bd.luas(bd.panjang, bd.tinggi));
        System.out.println(); // Biar ada jarak di terminal

        // --- 3. Lingkaran ---
        System.out.println("--- Kreasi Bangun Datar Baru ---");
        System.out.println("Masukkan Jari-jari Lingkaran:");
        double jari = inputan.nextDouble();
        
        Lingkaran bulat = new Lingkaran(jari);
        bd = bulat;
        bd.cetakLuas("Lingkaran", bd.luas());

        inputan.close();
    }
}