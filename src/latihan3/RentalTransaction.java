package latihan3;

public class RentalTransaction {
    // Properties
    private String namaPelanggan;
    private Vehicle kendaraan;
    private int durasiHari;
    private double totalBiaya;

    // Constructor
    public RentalTransaction(String namaPelanggan, Vehicle kendaraan, int durasiHari) {
        // TODO: Implementasi
        // TODO: Calculate total biaya
        this.namaPelanggan= namaPelanggan;
        this.kendaraan=kendaraan;
        this.durasiHari=durasiHari;
        this.totalBiaya=kendaraan.hitungBiayaRental(durasiHari);

    }

    // Method display rental details
    public void displayRentalDetails() {
        // TODO: Print detail rental
        System.out.println("Renatal untuk: "+ namaPelanggan);
        System.out.println("Kendaraan:  "+kendaraan.merk+ " " + kendaraan.model + " (" +(kendaraan instanceof Car ? "Mobil" : "Motor") + ")");
        System.out.println("Durasi: " +durasiHari + "hari");
        System.out.println("Biaya per hari: Rp " +String.format("%,.0f", kendaraan.hargaRentalPerHari));
        System.out.println("Total biaya: Rp " + String.format("%,.0f", totalBiaya));
    }

    // Getters
    public double getTotalBiaya() {
        return totalBiaya;
    }

    public Vehicle getKendaraan() {
        return kendaraan;
    }
}
