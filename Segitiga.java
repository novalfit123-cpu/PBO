package abstrak;

public class Segitiga extends BangunDatar {
    private double alas; // 
    private double tinggi; // 

    public Segitiga(double alas, double tinggi) {
        super(3); // Memanggil constructor BangunDatar, Segitiga punya 3 sisi 
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar Segitiga...");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Segitiga...");
    }

    @Override
    public double getLuas() {
        return 0.5 * alas * tinggi; // Rumus luas segitiga 
    }

    @Override
    public double getKeliling() {
        // Untuk memudahkan, kita asumsikan ini segitiga siku-siku untuk mencari sisi miringnya 
        double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
        return alas + tinggi + sisiMiring; 
    }
}