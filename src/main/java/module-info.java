module github.mariapas235 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;


    opens github.mariapas235.model.connection to java.xml.bind;
    exports github.mariapas235;
    opens github.mariapas235.test to java.xml.bind;
    opens github.mariapas235.view to java.xml.bind, javafx.fxml;

    opens github.mariapas235 to java.xml.bind, javafx.fxml;


    exports github.mariapas235.view;
}
