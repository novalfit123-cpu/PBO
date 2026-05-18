public class BangunDatar {
    double panjang;
    double lebar;
    double tinggi;

    // Luas default
    public double luas() {
        return 0;
    }

    // Luas untuk segitiga (overloading)
    public double luas(double alas, double tinggi) {
        return 0;
    }

    public void cetakLuas(String jenis, double luas) {
        System.out.println("Luas " + jenis + " adalah " + luas);
    }
}