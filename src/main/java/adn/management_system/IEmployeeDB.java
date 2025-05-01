package adn.management_system;

/**
 * The IEmployeeDB interface is used to make various types of DBs
 * and also is used to have the basic methods needed
 * for various databases
 *
 * @author Adhava Nandhiyar
 */
public interface IEmployeeDB {

    /**
     * Adds an employee to the database
     *
     * @param e the employee to be added to the database
     */
    void addEmployee( Employee e);

    /**
     * Gets the number of employees in the database
     *
     * @return      the int of the num of employees in DB
     */
    int numInDB();

    /**
     * finds the employee from the database and returns it
     *
     * @param employeeID a string containing the employee to be founds ID number
     * @return      the found employee
     */
    Employee findEmployee(String employeeID);

    /**
     * removes the employee from the database
     *
     * @param e a employee to be removed from the database
     */
    void removeEmployeeFromDB(Employee e);
}
