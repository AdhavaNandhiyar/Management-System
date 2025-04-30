package adn.management_system;

interface IMVPContract {

    interface Presenter {
        void addEmployeeToDB( String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany, String initEmployeeID);
        void findEmployee( String employeeID );
    }

    interface View {
        void updateNumberInDB( int num );
        void updateFound( Employee e );
    }
}
