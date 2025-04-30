package adn.management_system;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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

    private TextField tf_removalIDField;
    private Label label_remove;

    private ObservableList<Employee> employeeObservableList;
    private ObservableList<Employee> empty = FXCollections.observableArrayList();

    TableView<Employee> tableView;

    IMVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {
        myPresenter = new EmployeePresenter(this);

        stage.setTitle("Employee Database");

        tableView = new TableView<>();

        employeeObservableList = FXCollections.observableArrayList();

        tableView.setItems(employeeObservableList);

        TableColumn<Employee, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployeeID()));

        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));

        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));

        TableColumn<Employee, Integer> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSalary()).asObject());

        TableColumn<Employee, String> jobColumn = new TableColumn<>("Job Title");
        jobColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));

        TableColumn<Employee, Integer> yearsColumn = new TableColumn<>("Years Employed");
        yearsColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYearsAtCompany()).asObject());

        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, salaryColumn, jobColumn, yearsColumn);

        StackPane tablePane = new StackPane();
        tablePane.getChildren().add(tableView);

        Label messageLabel = new Label("Enter Employee Details");
        tf_employeeIDField = new TextField();
        tf_employeeIDField.setPromptText("Enter ID Number");
        tf_firstNameField = new TextField();
        tf_firstNameField.setPromptText("Enter First Name");
        tf_lastNameField = new TextField();
        tf_lastNameField.setPromptText("Enter Last Name");
        tf_salaryField = new TextField();
        tf_salaryField.setPromptText("Enter Salary");
        tf_jobField = new TextField();
        tf_jobField.setPromptText("Enter Job Title");
        tf_yearsField = new TextField();
        tf_yearsField.setPromptText("Enter Years Employed");

        Label label_employeeInDB = new Label("Num of Employee's: ");
        label_numOfEmployee = new Label("0");

        Button addEmployeeButton = new Button("Add Employee");
        addEmployeeButton.setOnAction(this::buttonClicked);

        Label findLabel = new Label("Find an Employee's Details: ");
        tf_findIDField = new TextField();
        tf_findIDField.setPromptText("Enter the Employee's ID");

        Button findButton = new Button("Find Employee");
        findButton.setOnAction(this::buttonFind);

        Label removeLabel = new Label("Remove an Employee: ");
        tf_removalIDField = new TextField();
        tf_removalIDField.setPromptText("Enter the Employee's ID");

        Button removeButton = new Button("Remove Employee");
        removeButton.setOnAction(this::buttonRemove);

        label_remove = new Label("");

        VBox addEmployeePane = new VBox(10);
        addEmployeePane.setPadding(new Insets(20, 30, 20, 30));
        addEmployeePane.getChildren().addAll(messageLabel, tf_employeeIDField, tf_firstNameField, tf_lastNameField, tf_salaryField,
                tf_jobField, tf_yearsField, addEmployeeButton, label_employeeInDB, label_numOfEmployee);

        VBox findEmployeePane = new VBox(10);
        findEmployeePane.setPadding(new Insets(20, 30, 20, 30));
        findEmployeePane.getChildren().addAll(findLabel, tf_findIDField, findButton, removeLabel, tf_removalIDField,
                removeButton, label_remove);

        HBox hBoxPane = new HBox();
        hBoxPane.getChildren().addAll(addEmployeePane, findEmployeePane, tablePane);

        Scene scene = new Scene(hBoxPane);
        stage.setScene(scene);

        stage.show();
    }

    public void buttonClicked(ActionEvent event) {
        myPresenter.addEmployeeToDB( tf_firstNameField.getText(), tf_lastNameField.getText(), tf_salaryField.getText(),
                tf_jobField.getText(), tf_yearsField.getText(), tf_employeeIDField.getText());
    }

    public void buttonFind(ActionEvent event) {
        myPresenter.findEmployee(tf_findIDField.getText());
    }

    public void buttonRemove(ActionEvent event) {
        myPresenter.removeEmployee(tf_removalIDField.getText());
    }

    @Override
    public void updateNumberInDB(int num, Employee e) {
        label_numOfEmployee.setText( Integer.toString(num) );
        employeeObservableList.add(e);
        tableView.setItems(employeeObservableList);
    }

    @Override
    public void updateFound(Employee e) {
        ObservableList<Employee> foundEmployee = FXCollections.observableArrayList();
        if (e != null) {
            foundEmployee.add(e);
            tableView.setItems(foundEmployee);
        } else {
            tableView.setItems(foundEmployee);
        }
    }

    @Override
    public void updateRemove() {
        label_remove.setText("Employee Removed");
    }

    public static void main(String[] args) {
        launch();
    }
}