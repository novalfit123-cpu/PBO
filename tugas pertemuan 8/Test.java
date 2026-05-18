public class Test {
    
    
    public static void main(String[] args) {
        System.out.println("Main method utama (String[] args) dieksekusi oleh JVM.");
        
        // Memanggil method main lain yang sudah di-overload
        main(100);
        main("Mahasiswa IT");
    }

    // Overloaded main method dengan parameter int
    public static void main(int angka) {
        System.out.println("Overloaded main method (int) dipanggil. Nilai: " + angka);
    }

    // Overloaded main method dengan parameter String
    public static void main(String teks) {
        System.out.println("Overloaded main method (String) dipanggil. Teks: " + teks);
    }
}