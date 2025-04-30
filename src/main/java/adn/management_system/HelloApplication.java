package adn.management_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements IMVPContract.View {

    private TextField tf_employeeIDField;
    private TextField tf_firstNameField;
    private TextField tf_lastNameField;
    private TextField tf_salaryField;
    private TextField tf_jobField;
    private TextField tf_yearsField;
    private Label label_numOfEmployee;
    private TextField tf_findIDField;
    private Label label_found;

    IMVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {
        myPresenter = new EmployeePresenter(this);

        stage.setTitle("Employee Database");

        Label messageLabel = new Label("Enter Employee Details");
        tf_employeeIDField = new TextField();
        tf_employeeIDField.setPromptText("Enter employee's ID Number");
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

        Label findLabel = new Label("Find an Employee: ");
        tf_findIDField = new TextField();
        tf_findIDField.setPromptText("Enter the Employee IF");

        Button findButton = new Button("Find person");
        findButton.setOnAction(this::buttonFind);

        Label label_findResult = new Label("Result: ");
        label_found = new Label("");

        VBox vboxPane = new VBox(10);
        vboxPane.setPadding(new Insets(20, 30, 20, 30));
        vboxPane.getChildren().addAll(messageLabel, tf_employeeIDField, tf_firstNameField, tf_lastNameField, tf_salaryField,
                tf_jobField, tf_yearsField, addEmployeeButton, label_employeeInDB, label_numOfEmployee,
                findLabel, tf_findIDField, findButton, label_findResult, label_found);

        // The Scene (or SceneGraph) in JavaFX contains everything that will
        // be rendered and shown.  Add the pane to it via the constructor call.
        // and then let the stage know about the scene.
        Scene scene = new Scene(vboxPane);
        stage.setScene(scene);

        // this results in the stage being rendered
        stage.show();
    }

    public void buttonClicked(ActionEvent event) {
        myPresenter.addEmployeeToDB( tf_firstNameField.getText(), tf_lastNameField.getText(), tf_salaryField.getText(),
                tf_jobField.getText(), tf_yearsField.getText(), tf_employeeIDField.getText());
    }

    public void buttonFind(ActionEvent event) {
        myPresenter.addEmployeeToDB( tf_firstNameField.getText(), tf_lastNameField.getText(), tf_salaryField.getText(),
                tf_jobField.getText(), tf_yearsField.getText(), tf_employeeIDField.getText());
    }

    @Override
    public void updateNumberInDB(int num) {

    }

    public static void main(String[] args) {
        launch();
    }
}