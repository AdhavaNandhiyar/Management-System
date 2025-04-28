package adn.management_system;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer salary;
    private String jobTitle;
    private Integer yearsAtCompany;

    private Employee() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.salary = 0;
        this.jobTitle = "Unknown";
        this.yearsAtCompany = 0;
    }

    Employee(String initFirstName, String initLastName, Integer initSalary, String initJobTitle, Integer initYearsAtCompany) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
        this.salary = initSalary;
        this.jobTitle = initJobTitle;
        this.yearsAtCompany = initYearsAtCompany;
    }
}
