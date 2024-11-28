module com.example.eloadasbeadando {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires jakarta.persistence;
    opens com.example.eloadasbeadando to javafx.fxml, org.hibernate.orm.core;
    exports com.example.eloadasbeadando;
}