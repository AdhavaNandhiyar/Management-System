package adn.management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
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

    IMVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {









        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void updateNumberInDB(int num) {

    }

    public static void main(String[] args) {
        launch();
    }
}