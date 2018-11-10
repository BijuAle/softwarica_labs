/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author Biju Ale
 */
public class Employee extends Department {

    String empName;
    String empAddress;
    double Salary;
    double NetSalary;

    void assignInfo(String empName, String empAddress, double Salary) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.Salary = Salary;
    }

    void displayInfo() {

        NetSalary = Salary - ((5 / 100) * Salary);

        System.out.println("Organization: " + super.organizationName);
        System.out.println("Organization Address: " + super.organizationAddress);

        System.out.println("****************************************");

        System.out.println("Department: " + super.deptName);
        System.out.println("Department: " + super.deptID);
        System.out.println("Department: " + super.deptRemarks);

        System.out.println("****************************************");

        System.out.println("Name: " + empName);
        System.out.println("Address: " + empAddress);
        System.out.println("Name: " + empName);
        System.out.println("Salary: " + Salary);
        System.out.println("Net Salary: " + NetSalary);

    }

}
