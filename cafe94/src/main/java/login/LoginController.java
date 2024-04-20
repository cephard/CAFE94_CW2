package login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import self.App;

import java.io.IOException;

public class LoginController {

    public static String userName1;
    //static UserData data = new UserData();
    static CustomerLoginController data = new CustomerLoginController();
    protected final String admin_User = "admin";
    protected final String admin_Pass = "admin";
    @FXML
    private TextField UserNameButton;
    @FXML
    private TextField passwordButton;
    //@FXML private Label resultBox;
    @FXML
    private Text loginStatus;

    public static String getUserName() {

        return CustomerLoginController.getUserName();
    }

    @FXML
    public void switchToResult() throws IOException {

        String regID = UserNameButton.getText();
        String userPassword = passwordButton.getText();

        if (CustomerLoginController.checkUserData(regID, userPassword)) {
            userName1 = regID;
            App.setRoot("passResult");
        } else if (regID.isEmpty() || userPassword.isEmpty()) {
            App.setRoot("login");
        } else {
            loginStatus.setText("Invalid details Try again");
            App.setRoot("login");
        }
    }

    @FXML
    public void switchToView() throws IOException {
        App.setRoot("view");
    }

    @FXML
    public void switchToSignUp() throws IOException {
        App.setRoot("signUpPage");
    }
}