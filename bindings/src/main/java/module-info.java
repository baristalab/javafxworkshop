module com.adrianpk.baristalab.javafxworkshop.bindings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.adrianpk.baristalab.javafxworkshop.bindings to javafx.fxml;
    exports com.adrianpk.baristalab.javafxworkshop.bindings;
}