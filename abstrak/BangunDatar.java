package abstrak;

public abstract class BangunDatar {
	
    
    int x, y;
    
    // 1. Tambahan atribut sesuai soal
    private int jumlahSisi; 
    
    // 2. Tambahan constructor sesuai soal
    public BangunDatar(int sisi) {
        this.jumlahSisi = sisi; 
    }
    
    // Method asli 
    public void pindahkan(int a, int b) {
        x = a;
        y = b;
    }
    
    // 3. Tambahan method getter untuk jumlahSisi
    public int getJumlahSisi() {
        return jumlahSisi;
    }
    
    // Abstract method asli 
    public abstract void draw();
    public abstract void resize();
    
    // 4. Tambahan abstract method sesuai modul PDF
    public abstract double getLuas();
    public abstract double getKeliling();

}