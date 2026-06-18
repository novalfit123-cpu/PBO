/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loq
 */
public class Mhs {
    private String nim, nama;
    private double uts, uas, tugas;

    // Ini namanya Constructor, untuk menerima data inputan
    public Mhs(String nim, String nama, double uts, double uas, double tugas) {
        this.nim = nim;
        this.nama = nama;
        this.uts = uts;
        this.uas = uas;
        this.tugas = tugas;
    }
    
    // Method untuk mengambil nilai awal
    public double uts() { return uts; }
    public double uas() { return uas; }
    public double tugas() { return tugas; }

    // Method menghitung Nilai Akhir
    public double nilaiAkhir() {
        return (uts * 0.35) + (uas * 0.35) + (tugas * 0.30);
    }

    // Method menentukan Nilai Huruf
    public String getNilHuruf(double na) {
        if (na >= 85) return "A";
        else if (na >= 70) return "B";
        else if (na >= 60) return "C";
        else if (na >= 50) return "D";
        else return "E";
    }

    // Method menentukan Predikat
    public String getPredikat(String huruf) {
        switch (huruf) {
            case "A": return "Apik";
            case "B": return "Baik";
            case "C": return "Cukup";
            case "D": return "Kurang";
            default: return "Jelek";
        }
    }
}
