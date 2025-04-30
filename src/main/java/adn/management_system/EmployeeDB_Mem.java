package adn.management_system;

import java.util.LinkedList;

public class EmployeeDB_Mem implements IEmployeeDB {

    private final LinkedList<Employee> db;

    public EmployeeDB_Mem() {
        this.db = new LinkedList<>();
    }

    @Override
    public void addEmployee(Employee e) {
        this.db.add(e);
    }

    @Override
    public int numInDB() {
        return this.db.size();
    }

    @Override
    public Employee findEmployee(String employeeID) {
        for (Employee e: this.db) {
            if (e.getEmployeeID().equals(employeeID)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void removeEmployeeFromDB(Employee e) {
        db.remove(e);
    }
}
