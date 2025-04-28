module adn.management_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens adn.management_system to javafx.fxml;
    exports adn.management_system;
}