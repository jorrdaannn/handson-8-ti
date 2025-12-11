package latihan5;

public class PartTimeEmployee extends Employee {
    // Properties
    private double upahPerJam;
    private int jamKerja;

    // Constructor
    public PartTimeEmployee(String name, String employeeId, String department, double upahPerJam, int jamKerja) {
        // TODO: Implementasi
        super(name, employeeId, department);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    // Override calculateSalary
    @Override
    public double calculateSalary() {
        // TODO: Return upahPerJam * jamKerja
        return upahPerJam * jamKerja;
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        // TODO: Return bonus tetap 500000
        return 500000;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        // TODO: Implementasi
        super.displayInfo();
        System.out.println("Type: Part-Time Employee");
        System.out.println("Upah/Jam: Rp" + upahPerJam);
        System.out.println("Jam Kerja: " + jamKerja);
    }

    // Override generatePayslip
    @Override
    public void generatePayslip() {
        super.generatePayslip();
        System.out.println("Type: Part-Time Employee");
        System.out.printf("Hourly Rate: Rp %,.0f%n", upahPerJam);
        System.out.println("Working Hours: " + jamKerja);
        System.out.printf("Base Salary: Rp %,.0f%n", calculateSalary());
        System.out.printf("Bonus: Rp %,.0f%n", calculateBonus());
        System.out.printf("Total: Rp %,.0f%n", calculateSalary() + calculateBonus());

    }
}