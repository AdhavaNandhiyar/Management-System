package adn.management_system;

public class IMVPContract {

    interface Presenter {
        void addEmployeeToDB( String initFirstName, String initLastName, String initSalary, String initJobTitle, String initYearsAtCompany );
    }

    interface View {
        void updateNumberInDB( int num );
    }
}
