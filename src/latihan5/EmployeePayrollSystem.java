package latihan5;

import java.util.*;

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        /*
         * ADVANCED PROJECT: Employee Payroll System
         *
         * Deskripsi: Sistem untuk menghitung gaji berbagai tipe karyawan
         * dengan aturan perhitungan yang berbeda-beda.
         */

        // ===== SETUP EMPLOYEE DATA =====
        System.out.println("=== EMPLOYEE PAYROLL SYSTEM ===\n");

        // Latihan 1: Create employees
        // - Buat FullTimeEmployee: "John", gajiPokok: 8000000, tunjangan: 2000000
        // - Buat PartTimeEmployee: "Sarah", upahPerJam: 50000, jamKerja: 120
        // - Buat ContractEmployee: "Mike", gajiKontrak: 15000000, durasi: 6 bulan
        List<Employee> karyawan = new ArrayList<>();
        FullTimeEmployee karyawan1 = new FullTimeEmployee("John", "IT321", "IT", 8000000, 2000000);
        PartTimeEmployee karyawan2 = new PartTimeEmployee("Sarah", "MAR455", "Marketing", 50000, 120);
        ContractEmployee karyawan3 = new ContractEmployee("Mike", "FIN765", "Finance", 15000000, 6);

        karyawan.add(karyawan1);
        karyawan.add(karyawan2);
        karyawan.add(karyawan3);

        System.out.println(karyawan.size() + " employees created");

        // Ekspektasi Output:
        // 3 employees created

        // Latihan 2: Calculate salaries
        // - Calculate gaji untuk setiap employee
        // - Display salary details
        System.out.printf("%s (Full-Time): Rp %,.0f%n", karyawan1.getName(), karyawan1.calculateSalary());
        System.out.printf("%s (Part-Time): Rp %,.0f%n", karyawan2.getName(), karyawan2.calculateSalary());
        System.out.printf("%s (Contract): Rp %,.0f%n", karyawan3.getName(), karyawan3.calculateSalary());
        System.out.println();

        // Ekspektasi Output:
        // John (Full-Time): Rp 10,000,000
        // Sarah (Part-Time): Rp 6,000,000
        // Mike (Contract): Rp 15,000,000

        // Latihan 3: Add bonus
        // - Full-time dapat bonus 10% dari gaji pokok
        // - Part-time dapat bonus tetap Rp 500,000
        // - Contract tidak dapat bonus
        // - Calculate total dengan bonus
        double kar1Total = karyawan1.calculateSalary() + karyawan1.calculateBonus();
        double kar2Total = karyawan2.calculateSalary() + karyawan2.calculateBonus();
        double kar3Total = karyawan3.calculateSalary() + karyawan3.calculateBonus();

        System.out.printf("%s total dengan bonus: Rp %,.0f%n", karyawan1.getName(), kar1Total);
        System.out.printf("%s total dengan bonus: Rp %,.0f%n", karyawan2.getName(), kar2Total);
        System.out.printf("%s total dengan bonus: Rp %,.0f%n", karyawan3.getName(), kar3Total);
        System.out.println();

        // Ekspektasi Output:
        // John total dengan bonus: Rp 10,800,000
        // Sarah total dengan bonus: Rp 6,500,000
        // Mike total dengan bonus: Rp 15,000,000

        // Latihan 4: Calculate total payroll
        // - Sum semua salary + bonus
        // - Display payroll summary
        System.out.println("=== PAYROLL SUMMARY ===");
        double totalPayroll = kar1Total + kar2Total + kar3Total;
        System.out.printf("Total Payroll: Rp %,.0f%n", totalPayroll);
        System.out.println();

        // Ekspektasi Output:
        // Total Payroll: Rp 32,300,000

        // Latihan 5: Generate payslip
        // - Generate payslip detail untuk setiap employee
        // - Include: nama, tipe, gaji pokok, bonus, potongan, total
        karyawan1.generatePayslip();
        System.out.println();
        karyawan2.generatePayslip();
        System.out.println();
        karyawan3.generatePayslip();

        // Ekspektasi Output:
        // === PAYSLIP ===
        // Name: John
        // Type: Full-Time Employee
        // Base Salary: Rp 8,000,000
        // Allowance: Rp 2,000,000
        // Bonus: Rp 800,000
        // Total: Rp 10,800,000
    }
}
