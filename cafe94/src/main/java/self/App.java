package self;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("view"), 854, 480);
        stage.setScene(scene);
        stage.setMinWidth(854);
        stage.setMinHeight(480);
        stage.show();
    }
    @FXML
    private void switchToStaff() throws IOException {
        App.setRoot("menu");
    }
    @FXML
    private void switchToCustomer() throws IOException {
        App.setRoot("loginOrSignUpPage");
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}