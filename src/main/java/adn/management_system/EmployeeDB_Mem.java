package adn.management_system;

import java.util.LinkedList;

/**
 * The EmployeeDB_Mem class is the class used to
 * manage and create an employee database
 * and taking methods from another interface
 *
 * @author Adhava Nandhiyar
 */
public class EmployeeDB_Mem implements IEmployeeDB {

    /**
     * the list of the employees database
     */
    private final LinkedList<Employee> db;

    /**
     * The default constructor for the EmployeeDB_Mem. This constructor
     * sets the default parameters needed to initialize a EmployeeDB_Mem
     */
    public EmployeeDB_Mem() {
        this.db = new LinkedList<>();
    }

    /**
     * Adds an employee to the database
     *
     * @param e the employee to be added to the database
     */
    @Override
    public void addEmployee(Employee e) {
        this.db.add(e);
    }

    /**
     * Gets the number of employees in the database
     *
     * @return      the int of the num of employees in DB
     */
    @Override
    public int numInDB() {
        return this.db.size();
    }

    /**
     * finds the employee from the database and returns it
     *
     * @param employeeID a string containing the employee to be founds ID number
     * @return      the found employee
     */
    @Override
    public Employee findEmployee(String employeeID) {
        for (Employee e: this.db) {
            if (e.getEmployeeID().equals(employeeID)) {
                return e;
            }
        }
        return null;
    }

    /**
     * removes the employee from the database
     *
     * @param e a employee to be removed from the database
     */
    @Override
    public void removeEmployeeFromDB(Employee e) {
        db.remove(e);
    }
}
