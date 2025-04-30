package adn.management_system;

interface IMVPContract {

    interface Presenter {
        void addEmployeeToDB( String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany, String initEmployeeID);
        void findEmployee( String employeeID );
        void removeEmployee( String employeeID );
    }

    interface View {
        void updateNumberInDB( int num , Employee e);
        void updateFound( Employee e );
        void updateRemove( Employee e );
    }
}
