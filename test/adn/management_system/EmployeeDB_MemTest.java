package adn.management_system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The EmployeeDB_MemTest class tests the various methods and
 * creations of EmployeeDB_Mem class
 *
 * @author Adhava Nandhiyar
 */
class EmployeeDB_MemTest {

    /**
     * This function tests the EmployeeDB_Mem ability to
     * be created correctly and also if the
     * functions correctly output
     */
    @Test
    public void testEmployeeDBCreation() {
        EmployeeDB_Mem db = new EmployeeDB_Mem();
        Employee e = new Employee("Adhava", "Nandhiyar", 10000, "Intern", 2, "0001");

        db.addEmployee(e);
        assertEquals(1, db.numInDB());

        assertEquals(e, db.findEmployee("0001"));

        db.removeEmployeeFromDB(e);
        assertEquals(0, db.numInDB());
    }

}