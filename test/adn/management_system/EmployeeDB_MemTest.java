package adn.management_system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDB_MemTest {
    @Test
    public void testEmployeeDBCreation() {
        EmployeeDB_Mem db = new EmployeeDB_Mem();
        Employee e = new Employee("Adhava", "Nandhiyar", 10000, "Intern", 2, "0001");

        db.addEmployee(e);

        assertEquals(1, db.numInDB());
    }

}