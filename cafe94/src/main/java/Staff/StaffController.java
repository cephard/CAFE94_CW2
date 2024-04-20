package Staff;

import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class StaffController {

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}
