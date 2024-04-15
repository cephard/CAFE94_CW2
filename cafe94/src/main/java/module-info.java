module self {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens self to javafx.fxml;
    exports self;

    opens login to javafx.fxml;
    exports login;
    exports customer;
    opens customer to javafx.fxml;
    exports menu;
    opens menu to javafx.fxml;
    exports transaction;
    opens transaction to javafx.fxml;
    exports order;
    opens order to javafx.fxml;
    exports Staff;
    opens Staff to javafx.fxml;
}
