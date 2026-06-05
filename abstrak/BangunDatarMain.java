package abstrak;

public class BangunDatarMain {
    public static void main(String[] args) {
        System.out.println("--- Objek Kotak ---");
        Kotak kotakSaya = new Kotak(5, 4); // Panjang 5, Lebar 4 
        System.out.println("Luas: " + kotakSaya.getLuas()); // 
        System.out.println("Keliling: " + kotakSaya.getKeliling()); // 

        System.out.println("\n--- Objek Segitiga ---");
        Segitiga segitigaSaya = new Segitiga(3, 4); // Alas 3, Tinggi 4 
        System.out.println("Luas: " + segitigaSaya.getLuas()); // 
        System.out.println("Keliling: " + segitigaSaya.getKeliling()); // 
    }
}