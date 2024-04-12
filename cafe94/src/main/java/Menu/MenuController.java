package Menu;

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
    @FXML private static Order order = new Order(2334);;
    public String[] items = new String[5];

    public void initialize() {
        stackPane1.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane1, "Croissant", "Pastry",2.10, 230,false);
        });
        stackPane2.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane2, "Avocado Toast","Breakfast",5.75, 320, true);
        });
        stackPane3.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane3, "Caprese Salad", "Salad",7.99,250,false);
        });
        stackPane4.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane4, "Grilled Sandwich","Sandwich", 4.93,4800,false);
        });
        stackPane5.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane5, "Blueberry Muffin","Pastry", 2.99,350,false);
        });
        stackPane6.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane6, "Quinoa Salad","Salad", 7.19,320,true);
        });
        stackPane7.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane7, "Veggie Wrap","Sandwich", 6.99,280,true);
        });
        stackPane8.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane8, "Broth Bowl","Soup", 7.99,470,true);
        });
        stackPane9.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane9, "Chai Latte","Coffee", 3.99,1200,false);
        });
        stackPane10.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane10, "Cream Bagel","Snack", 3.49,350,false);
        });
        stackPane11.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane11, "Fruit Smoothie","Beverage", 5.99,200,true);
        });
        stackPane12.setOnMouseClicked(event -> {
            handleStackPaneClick(stackPane12, "Club Sandwich","Sandwich", 8.49,650,false);
        });
    }

    private void handleStackPaneClick(StackPane stackPane, String itemName, String type,Double price,int calories,boolean vegan) {
        MenuItem menuItem = new MenuItem(itemName, type, price, calories, vegan);
        order.addItem(menuItem);
        Text text = new Text("Added: " + menuItem.getName());
        stackPane.getChildren().add(text);
    }

    /**
     * Method to extract selected items from the menu in form of an order
     * @Ceph
     */
    public static Order getItemsFromMenu() {
        return order;
    }

    public void setItems(int limit, int rNum, String item) {
        item1.setText(null);
        item2.setText(null);
        item3.setText(null);
        item4.setText(null);
        item5.setText(null);
        if (limit >= 1) {
            items[0] = itemData.getItemInfo(rNum, 1, item);
            item1.setText(items[0]);
        }
        if (limit >= 2) {
            items[1] = itemData.getItemInfo(rNum, 2, item);
            item2.setText(items[1]);
        }
        if (limit >= 3) {
            items[2] = itemData.getItemInfo(rNum, 3, item);
            item3.setText(items[2]);
        }
        if (limit >= 4) {
            items[3] = itemData.getItemInfo(rNum, 4, item);
            item4.setText(items[3]);
        }
        if (limit >= 5) {
            items[4] = itemData.getItemInfo(rNum, 5, item);
            item5.setText(items[4]);
        }
        item6.setText(null);
    }

    @FXML
    private void switchToView() throws IOException {
        App.setRoot("view");
    }

    @FXML
    private void switchToOrder() throws IOException {
        App.setRoot("order");
    }

    @FXML
    private void openHotDrink() throws IOException {
        String item = "HotDrinks";
        setItems(5, 1, item);
    }

    @FXML
    private void openColdDrink() throws IOException {
        String item = "ColdDrinks";
        setItems(5, 3, item);
    }

    @FXML
    private void openDonuts() throws IOException {
        String item = "Donuts";
        setItems(5, 5, item);
    }

    @FXML
    private void openWrap() throws IOException {
        String item = "Wrap";
        setItems(4, 7, item);
    }

    @FXML
    private void openSandwiches() throws IOException {
        String item = "Sandwiches";
        setItems(2, 9, item);
    }

    @FXML
    private void openBurgers() throws IOException {
        String item = "Burgers";
        setItems(3, 11, item);
    }

    @FXML
    private void openChickenTenders() throws IOException {
        String item = "ChickenTenders";
        setItems(3, 13, item);
    }

    @FXML
    private void openSides() throws IOException {
        String item = "Sides";
        setItems(2, 15, item);
    }

    @FXML
    private void openVegg() throws IOException {
        String item = "Vegg";
        setItems(2, 17, item);
    }

    @FXML
    private void openSpecialItems() throws IOException {
        String item = "SpecialItems";
        setItems(1, 19, item);
    }

    public void addToBasket(String item) {
        if (item != null) {
            item = "\n" + item;
            if (basket.isEmpty()) {
                basket.put(item, 1);
            } else if (basket.containsKey(item)) {
                basket.replace(item, 1 + basket.get(item));
            } else {
                basket.put(item, 1);
            }
        }
    }

    public String getBasket() {
        return basket.toString();
    }
}
