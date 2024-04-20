package customer;

import javafx.fxml.FXML;
import self.App;

import java.io.IOException;

public class CustomerController {

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginOrSignUpPage");
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

}
