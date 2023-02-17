module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports com.example.demo.Controller;
    opens com.example.demo.Controller to javafx.fxml;
    exports com.example.demo.Model;
    opens com.example.demo.Model to javafx.fxml;
    exports com.example.demo.View;
    opens com.example.demo.View to javafx.fxml;
}