import java.util.Map;
import java.util.TreeMap;

public class LatihanCollection3 {
    public static void main(String[] args) {
        // Menggunakan TreeMap agar Key (Nama Perusahaan) otomatis terurut sesuai abjad
        Map<String, String> techMap = new TreeMap<>();

        // Memasukkan data ke dalam Map sesuai tabel di soal
        // Format: .put(Key, Value)
        techMap.put("Microsoft", "Bill Gates");
        techMap.put("Apple", "Steven Paul Jobs");
        techMap.put("Linux", "Linux Benedict Torvalds");
        techMap.put("Facebook", "Mark Zuckerberg");
        techMap.put("Twitter", "Jack Dorsey");
        techMap.put("Instagram", "Kevin Systrom");

        // Menampilkan output menggunakan perulangan
        int nomor = 1;
        for (String key : techMap.keySet()) {
            // Mengambil value berdasarkan key
            String value = techMap.get(key);
            
            // Mencetak hasil dengan format yang diminta
            // key.toUpperCase() digunakan agar nama perusahaan menjadi huruf kapital semua
            System.out.println(nomor + ". " + key.toUpperCase() + " dikembangkan oleh " + value);
            
            nomor++;
        }
    }
}