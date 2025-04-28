package adn.management_system;

public class IMVPContract {

    interface Presenter {
        void addEmployeeToDB( String initFirstName, String initLastName, int initSalary, String initJobTitle, int initYearsAtCompany );
    }

    interface View {
        void updateNumberInDB( int num );
    }
}
