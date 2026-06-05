package abstrak;

public class Sepeda extends Kendaraan {
    private boolean isAuto;

    public Sepeda(boolean isAuto) {
        this.isAuto = isAuto;
    }

    public void jenis() {
        if (this.isAuto == true) {
            System.out.println("Sepeda otomatis"); 
        } else {
            System.out.println("Sepeda kayuh"); 
        }
    }

    // INI PERBAIKANNYA: Wajib melakukan override abstract method
    @Override
    public void nyalakan() {
        if (this.isAuto == true) {
            System.out.println("Mesin sepeda otomatis menyala, tinggal gas aja!");
        } else {
            System.out.println("Sepeda kayuh tidak punya mesin, langsung digowes!");
        }
    }
}
