package adn.management_system;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer salary;
    private String jobTitle;
    private Integer yearsAtCompany;
    private Integer employeeID;

    private Employee() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.salary = 0;
        this.jobTitle = "Unknown";
        this.yearsAtCompany = 0;
        this.employeeID = 00000;
    }

    Employee(String initFirstName, String initLastName, Integer initSalary, String initJobTitle, Integer initYearsAtCompany, Integer initEmployeeID) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
        this.salary = initSalary;
        this.jobTitle = initJobTitle;
        this.yearsAtCompany = initYearsAtCompany;
        this.employeeID = initEmployeeID;
    }
}
