package adn.management_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements IMVPContract.View {

    private TextField tf_firstNameField;
    private TextField tf_lastNameField;
    private TextField tf_salaryField;
    private TextField tf_jobField;
    private TextField tf_yearsField;
    private Label label_numOfEmployee;

    IMVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {
        myPresenter = new EmployeePresenter(this);

        stage.setTitle("Employee Database");

        Label messageLabel = new Label("Enter Employee Details");
        tf_firstNameField = new TextField();
        tf_firstNameField.setPromptText("Enter employee's First Name");
        tf_lastNameField = new TextField();
        tf_lastNameField.setPromptText("Enter employee's Last Name");
        tf_salaryField = new TextField();
        tf_salaryField.setPromptText("Enter employee's Salary");
        tf_jobField = new TextField();
        tf_jobField.setPromptText("Enter employee's Job Title");
        tf_yearsField = new TextField();
        tf_yearsField.setPromptText("Enter how many years the employee has been employed");

        Label label_employeeInDB = new Label("Num of Employee's: ");
        label_numOfEmployee = new Label("0");

        Button addEmployeeButton = new Button("Add employee to DB");
        addEmployeeButton.setOnAction(this::buttonClicked);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public void buttonClicked(ActionEvent event) {

    }

    @Override
    public void updateNumberInDB(int num) {

    }

    public static void main(String[] args) {
        launch();
    }
}