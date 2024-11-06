module easv.dk.wordsearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens easv.dk.wordsearch to javafx.fxml;
    exports easv.dk.wordsearch;
}