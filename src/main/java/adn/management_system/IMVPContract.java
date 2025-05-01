package adn.management_system;

/**
 * The IMVP Interface is connect the database in the backend
 * to the display in the front using MVP and has two
 * internal interfaces as well
 *
 * @author Adhava Nandhiyar
 */
interface IMVPContract {

    /**
     * The Presenter Interface is to do the data in the
     * backend and then send it up to the front
     * end using basic java
     *
     * @author Adhava Nandhiyar
     */
    interface Presenter {

        /**
         * Adds a Employee object to the database
         *
         * @param initFirstName a string containing the first name of the employee
         * @param initLastName a string containing the last name of the employee
         * @param initSalary a String containing the salary of the employee
         * @param initJobTitle a string containing the job title of the employee
         * @param initYearsAtCompany a string containing the years the employee has worked
         * @param initEmployeeID a string containing the employee's ID number
         */
        void addEmployeeToDB( String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany, String initEmployeeID);

        /**
         * Finds the employee using the ID
         *
         * @param employeeID a string containing the employee's ID number
         */
        void findEmployee( String employeeID );

        /**
         * Removes an employee by using the ID
         *
         * @param employeeID a string containing the employee's ID number
         */
        void removeEmployee( String employeeID );
    }

    /**
     * The View Interface is the front end connected
     * with JavaFX and is used to connect to the backend and
     * do the data there.
     *
     * @author Adhava Nandhiyar
     */
    interface View {

        /**
         * Updates the number and table for the view
         *
         * @param num a int containing the number of employees in the DB
         * @param e the employee to add to the table
         */
        void updateNumberInDB( int num , Employee e);

        /**
         * Updates the table with only displaying the found table
         *
         * @param e a employee that is the found employee
         */
        void updateFound( Employee e );

        /**
         * Removes the employee from the list and table
         *
         * @param e a employee that is the removed employee
         */
        void updateRemove( Employee e );
    }
}
