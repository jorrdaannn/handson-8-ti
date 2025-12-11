package latihan5;

public class ContractEmployee extends Employee {
    // Properties
    private double gajiKontrak;
    private int durasiKontrakBulan;

    // Constructor
    public ContractEmployee(String name, String employeeId, String department, double gajiKontrak, int durasiKontrakBulan) {
        // TODO: Implementasi
        super(name, employeeId, department);
        this.gajiKontrak = gajiKontrak;
        this.durasiKontrakBulan = durasiKontrakBulan;
    }

    // Override calculateSalary
    @Override
    public double calculateSalary() {
        // TODO: Return gaji kontrak
        return gajiKontrak;
    }

    // Override calculateBonus
    @Override
    public double calculateBonus() {
        // TODO: Return 0 (tidak dapat bonus)
        return 0;
    }

    // Override displayInfo
    @Override
    public void displayInfo() {
        // TODO: Implementasi
        super.displayInfo();
        System.out.println("Type: Contract Employee");
        System.out.println("Contract Salary: Rp" + gajiKontrak);
        System.out.println("Contract Duration: " + durasiKontrakBulan + " months");
    }

    // Override generatePayslip
    @Override
    public void generatePayslip() {
        super.generatePayslip();
        System.out.println("Type: Contract Employee");
        System.out.printf("Contract Salary: Rp %,.0f%n", gajiKontrak);
        System.out.println("Contract Duration: " + durasiKontrakBulan + " months");
        System.out.printf("Bonus: Rp %,.0f%n", calculateBonus());
        System.out.printf("Total: Rp %,.0f%n", calculateSalary() + calculateBonus());
    }
}