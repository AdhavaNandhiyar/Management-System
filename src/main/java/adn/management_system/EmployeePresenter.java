package adn.management_system;

public class EmployeePresenter implements IMVPContract.Presenter {
    EmployeeDB_Mem employeeDB;
    IMVPContract.View theActualView;

    @Override
    public void addEmployeeToDB(String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany) {
        Integer eYears = Integer.parseInt( initYearsAtCompany );
        Integer eSalary = Integer.parseInt( initSalary );

        Employee e = new Employee(initFirstName, initLastName, eSalary, initJobTitle, eYears);
        employeeDB.addEmployee(e);

        theActualView.updateNumberInDB( employeeDB.numInDB() );
    }
}
