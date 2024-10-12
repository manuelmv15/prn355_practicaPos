module org.example.pos_practicamv23036 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.pos_practicamv23036 to javafx.fxml;
    exports org.example.pos_practicamv23036;
}