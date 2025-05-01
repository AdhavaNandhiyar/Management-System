package adn.management_system;

/**
 * The employee class is the class used to
 * create the basic object of the database which
 * are the employees
 *
 * @author Adhava Nandhiyar
 */
public class Employee {

    /**
     * the first name of the employee
     */
    private String firstName;

    /**
     * the last name of the employee
     */
    private String lastName;

    /**
     * the salary of the employee
     */
    private Integer salary;

    /**
     * the job title of the employee
     */
    private String jobTitle;

    /**
     * the years employed of the employee
     */
    private Integer yearsAtCompany;

    /**
     * the employee ID of the employee
     */
    private String employeeID;

    /**
     * The default constructor for the Employee. This constructor
     * sets the default parameters needed to initialize a employee without
     * any inputs
     */
    private Employee() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.salary = 0;
        this.jobTitle = "Unknown";
        this.yearsAtCompany = 0;
        this.employeeID = "00000";
    }

    /**
     * The default constructor for the employee. This constructor
     * sets the default parameters needed to initialize a employee with
     * inputs
     */
    Employee(String initFirstName, String initLastName, Integer initSalary, String initJobTitle, Integer initYearsAtCompany, String initEmployeeID) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
        this.salary = initSalary;
        this.jobTitle = initJobTitle;
        this.yearsAtCompany = initYearsAtCompany;
        this.employeeID = initEmployeeID;
    }

    /**
     * Gets the salary of the employee
     *
     * @return      the employees salary in an Integer
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Gets the years at company of the employee
     *
     * @return      the employees years employed in an Integer
     */
    public Integer getYearsAtCompany() {
        return yearsAtCompany;
    }

    /**
     * Gets the ID number of the employee
     *
     * @return      the employees ID in a String
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Gets the first name of the employee
     *
     * @return      the employees firstname in a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the salary of the employee
     *
     * @return      the employees job title in a String
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Gets the salary of the employee
     *
     * @return      the employees last name in a String
     */
    public String getLastName() {
        return lastName;
    }
}
