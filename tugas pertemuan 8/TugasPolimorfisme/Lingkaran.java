public class Lingkaran extends BangunDatar {
    double jariJari;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double luas() {
        return Math.PI * jariJari * jariJari; // Rumus luas lingkaran: pi * r^2
    }
}