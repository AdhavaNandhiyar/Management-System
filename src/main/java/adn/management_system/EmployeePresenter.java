package adn.management_system;

/**
 * The EmployeePresenter class is used to do the
 * methods and calculations in the backend
 * and then send them to the front end using
 * the view attribute
 *
 * @author Adhava Nandhiyar
 */
public class EmployeePresenter implements IMVPContract.Presenter {

    /**
     * the database of the employees
     */
    EmployeeDB_Mem employeeDB;

    /**
     * the view of the contract
     */
    IMVPContract.View theActualView;

    /**
     * The default constructor for the EmployeePresenter. This constructor
     * sets the default parameters needed to initialize a EmployeePresenter
     */
    public EmployeePresenter(IMVPContract.View aView) {
        this.theActualView = aView;
        this.employeeDB = new EmployeeDB_Mem();
    }

    /**
     * Adds an Employee object to the database
     *
     * @param initFirstName a string containing the first name of the employee
     * @param initLastName a string containing the last name of the employee
     * @param initSalary a String containing the salary of the employee
     * @param initJobTitle a string containing the job title of the employee
     * @param initYearsAtCompany a string containing the years the employee has worked
     * @param initEmployeeID a string containing the employee's ID number
     */
    @Override
    public void addEmployeeToDB(String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany, String initEmployeeID) {
        Integer eYears = Integer.parseInt( initYearsAtCompany );
        Integer eSalary = Integer.parseInt( initSalary );

        Employee e = new Employee(initFirstName, initLastName, eSalary, initJobTitle, eYears, initEmployeeID);
        employeeDB.addEmployee(e);

        theActualView.updateNumberInDB( employeeDB.numInDB(), e);
    }

    /**
     * Finds the employee using the ID
     *
     * @param employeeID a string containing the employee's ID number
     */
    @Override
    public void findEmployee(String employeeID) {
        Employee e = employeeDB.findEmployee(employeeID);
        theActualView.updateFound( e );
    }

    /**
     * Removes an employee by using the ID
     *
     * @param employeeID a string containing the employee's ID number
     */
    @Override
    public void removeEmployee(String employeeID) {
        Employee e = employeeDB.findEmployee(employeeID);
        employeeDB.removeEmployeeFromDB(e);

        theActualView.updateRemove(e);
        theActualView.updateNumberInDB( employeeDB.numInDB(), e);
    }
}
