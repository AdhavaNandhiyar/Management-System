package adn.management_system;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer salary;
    private String jobTitle;
    private Integer yearsAtCompany;
    private String employeeID;

    private Employee() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.salary = 0;
        this.jobTitle = "Unknown";
        this.yearsAtCompany = 0;
        this.employeeID = "00000";
    }

    Employee(String initFirstName, String initLastName, Integer initSalary, String initJobTitle, Integer initYearsAtCompany, String initEmployeeID) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
        this.salary = initSalary;
        this.jobTitle = initJobTitle;
        this.yearsAtCompany = initYearsAtCompany;
        this.employeeID = initEmployeeID;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getYearsAtCompany() {
        return yearsAtCompany;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLastName() {
        return lastName;
    }
}
