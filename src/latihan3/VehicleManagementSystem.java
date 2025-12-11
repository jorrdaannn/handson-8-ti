package latihan3;

import java.util.*;

public class VehicleManagementSystem {
    public static void main(String[] args) {
        /*
         * REAL-WORLD PROJECT: Vehicle Rental Management System
         *
         * Deskripsi: Sistem untuk mengelola rental kendaraan dengan berbagai
         * tipe kendaraan dan perhitungan biaya rental yang berbeda.
         */

        // ===== SETUP RENTAL SYSTEM =====
        System.out.println("=== VEHICLE RENTAL MANAGEMENT SYSTEM ===\n");

        // Latihan 1: Create vehicle fleet
        // - Buat 3 Mobil: Toyota Avanza, Honda Jazz, Suzuki Ertiga
        // - Buat 2 Motor: Honda Beat, Yamaha NMAX
        // - Set harga rental per hari untuk masing-masing
        List<Vehicle> fleet = new ArrayList<>();
        Car mbl1 = new Car("Toyota", "Avanza", 2004, "BK 5675 YZ", 300000, 7, "Manual", true);
        Car mbl2 = new Car("Honda", "Jazz", 2020, "BH 7685 KBB", 400000, 5, "Automatic", true);
        Car mbl3 = new Car("Suzuki", "Ertiga", 2021, "BB 2354 YTH", 350000, 7, "Manual", true);

        Motorcycle mtr1 = new Motorcycle("Honda", "Beat", 2023, "Z 765 KOL", 75000, "Matic", 110);
        Motorcycle mtr2 = new Motorcycle("Yamaha", "NMAX", 2022, "BK 6587 JKW", 100000, "Matic", 155);

        fleet.add(mbl1);
        fleet.add(mbl2);
        fleet.add(mbl3);
        fleet.add(mtr1);
        fleet.add(mtr2);

        System.out.println("Fleet created: " + fleet.size() + " vehicles");
        // Ekspektasi Output:
        // Fleet created: 5 vehicles

        // Latihan 2: Display all vehicles
        // - Loop semua kendaraan
        // - Display info lengkap masing-masing
        for (Vehicle kendaraan : fleet){
            kendaraan.displayInfo();
        }

        // Ekspektasi Output:
        // [Info detail untuk setiap kendaraan]

        // Latihan 3: Rent a vehicle
        // - Customer "Andi" rental Toyota Avanza selama 3 hari
        // - Calculate total biaya
        // - Display rental details
        RentalTransaction rental1 = new RentalTransaction("Andi", fleet.getFirst() , 3);
        rental1.displayRentalDetails();

        // Ekspektasi Output:
        // Rental untuk: Andi
        // Kendaraan: Toyota Avanza (Mobil)
        // Durasi: 3 hari
        // Biaya per hari: Rp 300,000
        // Total biaya: Rp 900,000

        // Latihan 4: Calculate monthly revenue
        // - Rent beberapa kendaraan
        // - Calculate total revenue bulan ini
        List<RentalTransaction> rentalBulanan = new ArrayList<>();
        rentalBulanan.add(rental1);
        rentalBulanan.add(new RentalTransaction("Stephan", mbl2, 5));
        rentalBulanan.add(new RentalTransaction("King", mbl3, 4));
        rentalBulanan.add(new RentalTransaction("Eben", mtr1, 4));
        rentalBulanan.add(new RentalTransaction("Jordan", mtr2, 8));

        double totalRevenue = 0;
        for (RentalTransaction rental : rentalBulanan) {
            totalRevenue += rental.getTotalBiaya();
        }

        System.out.println("Total revenue bulan ini: Rp " + totalRevenue);

        // Ekspektasi Output:
        // Total revenue bulan ini: Rp 5,400,000

        // Latihan 5: Vehicle maintenance
        // - Mark beberapa kendaraan sebagai "under maintenance"
        // - Display available vehicles only
        mbl2.setTersedia(false);
        mtr2.setTersedia(false);

        int available = 0;
        int maintenance = 0;

        for (Vehicle kendaraan : fleet) {
            if (kendaraan.isTersedia()) {
                available++;
            } else {
                maintenance++;
            }
        }
        System.out.println("Available vehicles: " + available);
        System.out.println("Under maintenance: " + maintenance);

        // Ekspektasi Output:
        // Available vehicles: 3
        // Under maintenance: 2

        // Latihan 6: Find vehicles by criteria
        // - Find all Mobil dengan harga < Rp 350,000/hari
        int mobilJumlah = 0;
        for (Vehicle kendaraan : fleet) {
            if (kendaraan instanceof Car && kendaraan.getHargaRentalPerHari() < 350000) {
                mobilJumlah++;
            }
        }
        System.out.println("Found " + mobilJumlah + " Mobil sesuai kriteria");
        // - Find all Motor jenis "matic"
        int maticJumlah = 0;
        for (Vehicle kendaraan : fleet) {
            if (kendaraan instanceof Motorcycle) {
                if (((Motorcycle) kendaraan).getJenisMotor().equalsIgnoreCase("Matic")) {
                    maticJumlah++;
                }
            }
        }
        System.out.println("Found " + maticJumlah + " Motor matic");

        // Ekspektasi Output:
        // Found 2 Mobil sesuai kriteria
        // Found 1 Motor matic

        // Latihan 7: Generate rental report
        // - Display summary rental bulan ini
        // - Group by vehicle type
        // - Show total revenue per type
        int mobilRentals = 0;
        double mobilRevenue = 0;
        int motorRentals = 0;
        double motorRevenue = 0;

        for (RentalTransaction rental : rentalBulanan) {
            if (rental.getKendaraan() instanceof Car) {
                mobilRentals++;
                mobilRevenue += rental.getTotalBiaya();
            } else if (rental.getKendaraan() instanceof Motorcycle) {
                motorRentals++;
                motorRevenue += rental.getTotalBiaya();
            }
        }

        System.out.println("\n=== RENTAL REPORT ===");
        System.out.println("Mobil: " + mobilRentals + " rentals, Rp " + mobilRevenue);
        System.out.println("Motor: " + motorRentals + " rentals, Rp " + motorRevenue);
        System.out.println("Total: Rp " + (mobilRevenue + motorRevenue));

        // Ekspektasi Output:
        // === RENTAL REPORT ===
        // Mobil: 15 rentals, Rp 4,200,000
        // Motor: 8 rentals, Rp 1,200,000
        // Total: Rp 5,400,000
    }

}