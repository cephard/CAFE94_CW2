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
    exports Menu;
    opens Menu to javafx.fxml;
    exports payment;
    opens payment to javafx.fxml;
    exports order;
    opens order to javafx.fxml;
    exports Staff;
    opens Staff to javafx.fxml;
}
