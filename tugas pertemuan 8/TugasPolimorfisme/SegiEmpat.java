public class SegiEmpat extends BangunDatar {
    @Override
    public double luas() {
        return panjang * lebar;
    }

    // Overloading luas untuk bujur sangkar (persegi)
    public int luas(int sisi) {
        return sisi * sisi;
    }
}