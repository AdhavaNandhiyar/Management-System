package adn.management_system;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private String jobTitle;
    private int yearsAtCompany;

    private Employee() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.salary = 0;
        this.jobTitle = "Unknown";
        this.yearsAtCompany = 0;
    }

    Employee(String initFirstName, String initLastName, int initSalary, String initJobTitle, int initYearsAtCompany) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
        this.salary = initSalary;
        this.jobTitle = initJobTitle;
        this.yearsAtCompany = initYearsAtCompany;
    }
}
