package adn.management_system;

public class EmployeePresenter implements IMVPContract.Presenter {
    EmployeeDB_Mem employeeDB;
    IMVPContract.View theActualView;

    public EmployeePresenter(IMVPContract.View aView) {
        this.theActualView = aView;
        this.employeeDB = new EmployeeDB_Mem();
    }

    @Override
    public void addEmployeeToDB(String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany, String initEmployeeID) {
        Integer eYears = Integer.parseInt( initYearsAtCompany );
        Integer eSalary = Integer.parseInt( initSalary );

        Employee e = new Employee(initFirstName, initLastName, eSalary, initJobTitle, eYears, initEmployeeID);
        employeeDB.addEmployee(e);

        theActualView.updateNumberInDB( employeeDB.numInDB() );
    }

    @Override
    public void findEmployee(String employeeID) {
        Employee e = employeeDB.findEmployee(employeeID);
        theActualView.updateFound( e );
    }

    @Override
    public void removeEmployee(String employeeID) {
        Employee e = employeeDB.findEmployee(employeeID);
        employeeDB.removeEmployeeFromDB(e);

        theActualView.updateRemove();
        theActualView.updateNumberInDB( employeeDB.numInDB() );
    }
}
