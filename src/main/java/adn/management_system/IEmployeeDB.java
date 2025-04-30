package adn.management_system;

public interface IEmployeeDB {
    void addEmployee( Employee e);
    int numInDB();
    Employee findEmployee(String employeeID);
    void removeEmployeeFromDB(Employee e);
}
