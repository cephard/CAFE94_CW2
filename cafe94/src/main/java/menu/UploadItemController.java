package menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class UploadItemController {

    @FXML
    private TextField nameText;
    @FXML
    private TextField typeText;
    @FXML
    private TextField quantityText;
    @FXML
    private TextField priceText;
    @FXML
    private TextField caloriesText;
    @FXML
    private ImageView imageView;
    @FXML
    private Button submitButton;
    @FXML
    private RadioButton veganYesRadioButton;
    @FXML
    private RadioButton veganNoRadioButton;

    private ToggleGroup veganToggleGroup;

    @FXML
    private void initialize() {
        // Create a ToggleGroup and add radio buttons to it
        veganToggleGroup = new ToggleGroup();
        veganYesRadioButton.setToggleGroup(veganToggleGroup);
        veganNoRadioButton.setToggleGroup(veganToggleGroup);

        // Set default selection to "No"
        veganNoRadioButton.setSelected(true);
    }

    @FXML
    private void submitItem() {
        // Check if either "Yes" or "No" is selected
        if (veganToggleGroup.getSelectedToggle() != null) {
            String name = nameText.getText();
            int quantity = Integer.parseInt(quantityText.getText());
            double price = Double.parseDouble(priceText.getText());
            int calories = Integer.parseInt(caloriesText.getText());
            String type = typeText.getText();
            String itemImagePath = "Image Path";
            boolean vegan = veganYesRadioButton.isSelected();

            MenuItem newItem = new MenuItem(name, type, price, calories, vegan, quantity, itemImagePath);

            // Perform further actions with the new MenuItem object
            System.out.println(newItem);
        } else {
            // Display an error message indicating that the user must choose either "Yes" or "No"
            System.out.println("Please select either Yes or No for the Vegan field.");
        }
    }
}
