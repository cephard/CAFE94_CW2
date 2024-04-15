package menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import order.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import self.App;
import java.io.IOException;
import java.util.HashMap;

public class MenuController {
    MenuDataController itemData = new MenuDataController();
    HashMap<String, Integer> basket = new HashMap<>();
    @FXML private Button backButton;
    @FXML private Button checkOutButton;
    @FXML private Text item1;
    @FXML private Text item2;
    @FXML private Text item3;
    @FXML private Text item4;
    @FXML private Text item5;
    @FXML private Text item6;
    @FXML private TextArea showBasketItems;
    @FXML private Text showBasketItems2;
    @FXML private StackPane stackPane1;
    @FXML private StackPane stackPane2;
    @FXML private StackPane stackPane3;
    @FXML private StackPane stackPane4;
    @FXML private StackPane stackPane5;
    @FXML private StackPane stackPane6;
    @FXML private StackPane stackPane7;
    @FXML private StackPane stackPane8;
    @FXML private StackPane stackPane9;
    @FXML private StackPane stackPane10;
    @FXML private StackPane stackPane11;
    @FXML private StackPane stackPane12;
    @FXML private static Order order = new Order(2334);
    Menu menu = new Menu();
    private static MenuItem selectedMenuItem;
    public String[] items = new String[5];

    public void openOrderWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("C:\\Users\\Ceph\\IdeaProjects\\Cafe94\\cafe94\\src\\main\\resources\\self\\Order.fxml"));
            Parent root = loader.load();
            Stage orderStage = new Stage();
            orderStage.setScene(new Scene(root));
            orderStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
        stackPane1.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane1, menu.croissant);
        });
        stackPane2.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane2, menu.avocadoToast);
        });
        stackPane3.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane3, menu.capreseSaladd);
        });
        stackPane4.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane4, menu.grilledSandwich);
        });
        stackPane5.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane5, menu.blueBerryMuffin);
        });
        stackPane6.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane6, menu.quionaSalad);
        });
        stackPane7.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane7, menu.veggieWrap);
        });
        stackPane8.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane8, menu.brothBowl);
        });
        stackPane9.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane9, menu.chaiLatte);
        });
        stackPane10.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane10, menu.creamBagel);
        });
        stackPane11.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane11, menu.fruitSmoothie);
        });
        stackPane12.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane12, menu.clubSandwich);
        });
    }

    private void handleStackPaneClick(StackPane stackPane, MenuItem menuItem) {
        order.addItem(menuItem);
        //Text text = new Text("Added: " + menuItem.getName());
        //stackPane.getChildren().add(text);
        selectedMenuItem = menuItem;
        try {
            App.setRoot("MenuItem");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to extract selected items from the menu in form of an order
     *
     * @Ceph
     */
    public static Order getOrderFromMenu() {
        return order;
    }

    public static MenuItem getItemFromMenu() {
        return selectedMenuItem;
    }


    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

    @FXML
    private void switchToOrder() throws IOException {
        App.setRoot("order");
    }
}
