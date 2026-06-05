package abstrak;

public class Kotak extends BangunDatar implements Resizeable {
    private double panjang;
    private double lebar;

    public Kotak(double panjang, double lebar) {
        super(4); 
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar Kotak...");
    }

    // Ini dari abstract class BangunDatar (tanpa parameter)
    @Override
    public void resize() {
        System.out.println("Ini method resize bawaan BangunDatar");
    }

    //  Implementasi method dari Interface Resizeable (pakai parameter) ( agar class Kotak meng-implement Resizeable)
    @Override
    public void resize(double x) {
        this.panjang = this.panjang * x;
        this.lebar = this.lebar * x;
        System.out.println("Ukuran kotak telah diperbesar " + x + " kali lipat.");
    }

    @Override
    public double getLuas() {
        return panjang * lebar; 
    }

    @Override
    public double getKeliling() {
        return 2 * (panjang + lebar); 
    }
}
