package latihan1;

public class Kendaraan {
    // Properties
    protected String merk;
    protected String warna;
    protected int tahunProduksi;
    private String nomorRangka;

    // Constructor
    public Kendaraan(String merk, String warna, int tahunProduksi) {
        // TODO: Implementasi constructor
        // - Inisialisasi semua properties
        // - Print pesan "Constructor Kendaraan dipanggil"
        System.out.println("Constructor Kendaraan dipanggil");
        this.merk = merk;
        this.warna = warna;
        this.tahunProduksi = tahunProduksi;
        this.nomorRangka = generateNomorRangka(merk, tahunProduksi);

    }

    private String generateNomorRangka(String merk, int tahunProduksi) {
        String kode = merk.substring(0, Math.min(3, merk.length())).toUpperCase();
        return kode + tahunProduksi + String.format("%03d", 1);
    }

    // Method untuk menampilkan info
    public void displayInfo() {
        // TODO: Print semua informasi kendaraan
        System.out.println("=== Info Kendaraan ===");
        System.out.println("Merk: " + merk);
        System.out.println("Warna: " + warna);
        System.out.println("Tahun Produksi: " + tahunProduksi);
    }

    // Method klakson
    public void klakson() {
        // TODO: Print "Tin tin!"
        System.out.println("Tin tin!");
    }

    // Method untuk menghitung umur kendaraan
    public int hitungUmur() {
        // TODO: Return umur kendaraan (tahun sekarang - tahun produksi)
        return (2025 - tahunProduksi);
    }

    // Getter dan Setter
    public String getNomorRangka() {
        return nomorRangka;
    }

    public void setNomorRangka(String nomorRangka) {
        this.nomorRangka = nomorRangka;
    }
}
