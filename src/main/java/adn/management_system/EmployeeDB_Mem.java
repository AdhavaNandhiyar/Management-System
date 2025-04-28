package adn.management_system;

import java.util.LinkedList;

public class EmployeeDB_Mem implements IEmployeeDB{

    private final LinkedList<Employee> db;

    public EmployeeDB_Mem() {
        this.db = new LinkedList<>();
    }

    @Override
    public void addEmployee(Employee e) {

    }

    @Override
    public int numInDB() {
        return 0;
    }
}
