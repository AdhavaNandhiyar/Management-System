package adn.management_system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void testEmployeeCreation() {
        Employee e = new Employee("Adhava", "Nandhiyar", 10000, "Intern", 2, "0001");

        assertEquals("Adhava", e.getFirstName());
        assertEquals("Nandhiyar", e.getLastName());
        assertEquals(10000, e.getSalary());
        assertEquals("Intern", e.getJobTitle());
        assertEquals(2, e.getYearsAtCompany());
        assertEquals("0001", e.getEmployeeID());
    }

}