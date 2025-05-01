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


/**
 * The HelloApplication class is used as front end
 * to display the back end contents into a table
 * and also to get inputs
 *
 * @author Adhava Nandhiyar
 */
public class HelloApplication extends Application implements IMVPContract.View {

    /**
     * the employee ID textfield
     */
    private TextField tf_employeeIDField;

    /**
     * the employee first name textfield
     */
    private TextField tf_firstNameField;

    /**
     * the employee last name textfield
     */
    private TextField tf_lastNameField;

    /**
     * the employee salary textfield
     */
    private TextField tf_salaryField;

    /**
     * the employee job textfield
     */
    private TextField tf_jobField;

    /**
     * the employee employed years textfield
     */
    private TextField tf_yearsField;

    /**
     * the employee ID textfield to be used in the find function
     */
    private TextField tf_findIDField;

    /**
     * the employee ID textfield to be used in the remove function
     */
    private TextField tf_removalIDField;

    /**
     * the list of all the employees for the table
     */
    private ObservableList<Employee> employeeObservableList;

    /**
     * the table of employees
     */
    TableView<Employee> tableView;

    /**
     * the presenter connector
     */
    IMVPContract.Presenter myPresenter;

    /**
     * The showing and start to show the javafx
     * front end
     */
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

        Label label_remove = new Label("");

        Label listLabel = new Label("Show full Employee List: ");

        Button listButton = new Button("Show Employee List");
        listButton.setOnAction(this::buttonList);

        VBox addEmployeePane = new VBox(10);
        addEmployeePane.setPadding(new Insets(20, 30, 20, 30));
        addEmployeePane.getChildren().addAll(messageLabel, tf_employeeIDField, tf_firstNameField, tf_lastNameField, tf_salaryField,
                tf_jobField, tf_yearsField, addEmployeeButton);

        VBox findEmployeePane = new VBox(10);
        findEmployeePane.setPadding(new Insets(20, 30, 20, 30));
        findEmployeePane.getChildren().addAll(findLabel, tf_findIDField, findButton, removeLabel, tf_removalIDField,
                removeButton, label_remove, listLabel, listButton);

        HBox hBoxPane = new HBox();
        hBoxPane.getChildren().addAll(addEmployeePane, findEmployeePane, tablePane);

        Scene scene = new Scene(hBoxPane);
        stage.setScene(scene);

        stage.show();
    }

    /**
     * the function to add an employee after the button is clicked
     *
     * @param event a ActionEvent that tells the button has been pressed
     */
    public void buttonClicked(ActionEvent event) {
        myPresenter.addEmployeeToDB( tf_firstNameField.getText(), tf_lastNameField.getText(), tf_salaryField.getText(),
                tf_jobField.getText(), tf_yearsField.getText(), tf_employeeIDField.getText());

        tf_employeeIDField.clear();
        tf_jobField.clear();
        tf_firstNameField.clear();
        tf_lastNameField.clear();
        tf_salaryField.clear();
        tf_yearsField.clear();
    }

    /**
     * the function to find an employee after the button is clicked
     *
     * @param event a ActionEvent that tells the button has been pressed
     */
    public void buttonFind(ActionEvent event) {
        myPresenter.findEmployee(tf_findIDField.getText());
        tf_findIDField.clear();
    }

    /**
     * the function to remove an employee after the button is clicked
     *
     * @param event a ActionEvent that tells the button has been pressed
     */
    public void buttonRemove(ActionEvent event) {
        myPresenter.removeEmployee(tf_removalIDField.getText());
        tf_removalIDField.clear();
    }

    /**
     * the function to get the full table after the button is pressed
     *
     * @param event a ActionEvent that tells the button has been pressed
     */
    public void buttonList(ActionEvent event) {
       tableView.setItems(employeeObservableList);
    }

    /**
     * Updates the number and table for the view
     *
     * @param num a int containing the number of employees in the DB
     * @param e the employee to add to the table
     */
    @Override
    public void updateNumberInDB(int num, Employee e) {
        employeeObservableList.add(e);
        tableView.setItems(employeeObservableList);
    }

    /**
     * Updates the table with only displaying the found table
     *
     * @param e a employee that is the found employee
     */
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

    /**
     * Removes the employee from the list and table
     *
     * @param e a employee that is the removed employee
     */
    @Override
    public void updateRemove(Employee e) {
        for (Employee employee: employeeObservableList) {
            if (employee.getEmployeeID().equals(e.getEmployeeID())) {
                employeeObservableList.remove(employee);
            }
        }
    }

    /**
     * Launches the front end
     */
    public static void main(String[] args) {
        launch();
    }
}