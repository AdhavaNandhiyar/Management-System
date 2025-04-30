package adn.management_system;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

        TableView<Employee> tableView = new TableView<>();
        ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();

        TableColumn<Employee, String> idColumn = new TableColumn<>("ID");

        // Create Age column
        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("Age");

        // Create City column
        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("City");

        TableColumn<Employee, Integer> salaryColumn = new TableColumn<>("City");

        TableColumn<Employee, String> jobColumn = new TableColumn<>("Job Title");

        TableColumn<Employee, Integer> yearsColumn = new TableColumn<>("Years in Company");

        // Add columns to the table
        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, salaryColumn, jobColumn, yearsColumn);

        // Create a layout and add the TableView
        StackPane tablePane = new StackPane();
        tablePane.getChildren().add(tableView);

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

        Label findLabel = new Label("Find an Employee's Details: ");
        tf_findIDField = new TextField();
        tf_findIDField.setPromptText("Enter the Employee's ID");

        Button findButton = new Button("Find person");
        findButton.setOnAction(this::buttonFind);

        Label label_findResult = new Label("Employee Details: ");
        label_found = new Label("");

        VBox vboxPane = new VBox(10);
        vboxPane.setPadding(new Insets(20, 30, 20, 30));
        vboxPane.getChildren().addAll(messageLabel, tf_employeeIDField, tf_firstNameField, tf_lastNameField, tf_salaryField,
                tf_jobField, tf_yearsField, addEmployeeButton, label_employeeInDB, label_numOfEmployee,
                findLabel, tf_findIDField, findButton, label_findResult, label_found);

        HBox hBoxPane = new HBox();
        hBoxPane.getChildren().addAll(vboxPane, tablePane);

        // The Scene (or SceneGraph) in JavaFX contains everything that will
        // be rendered and shown.  Add the pane to it via the constructor call.
        // and then let the stage know about the scene.
        Scene scene = new Scene(hBoxPane);
        stage.setScene(scene);

        // this results in the stage being rendered
        stage.show();
    }

    public void buttonClicked(ActionEvent event) {
        myPresenter.addEmployeeToDB( tf_firstNameField.getText(), tf_lastNameField.getText(), tf_salaryField.getText(),
                tf_jobField.getText(), tf_yearsField.getText(), tf_employeeIDField.getText());
    }

    public void buttonFind(ActionEvent event) {
        myPresenter.findEmployee(tf_findIDField.getText());
    }

    @Override
    public void updateNumberInDB(int num) {
        label_numOfEmployee.setText( Integer.toString(num) );
    }

    @Override
    public void updateFound(Employee e) {
        label_found.setText("ID: " + e.getEmployeeID() + ", First Name: " + e.getFirstName() + ", Last Name: " + e.getLastName()
                + ", Salary: " + e.getSalary() + ", Job Title: " + e.getJobTitle() + ", Years in Company: " + e.getYearsAtCompany());
    }

    public static void main(String[] args) {
        launch();
    }
}