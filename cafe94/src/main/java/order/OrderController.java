package order;

import menu.MenuController;
import menu.MenuItem;
import transaction.PrintReceipt;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import self.App;
import javafx.collections.ObservableList;
import java.io.IOException;

public class OrderController {
    Order order = MenuController.getOrderFromMenu();
    @FXML
    private ListView<String> orderListView = new ListView<>();

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    public void initialize() {
        ObservableList<String> orderItems = FXCollections.observableArrayList();
        for (MenuItem item : order.getOrder()) {
            String itemInfo = String.format("Name: %s, Type: %s, Price: £%.2f, Calories: %d, Vegan: %s",
                    item.getName(), item.getType(), item.getPrice(), item.getCalories(), item.isVegan() ? "Yes" : "No");
            orderItems.add(itemInfo);
        }

        orderListView.setItems(orderItems);
    }

    @FXML
    public void handleCheckOutButtonClick() {
        String receiptName;
        receiptName = String.valueOf(order.getOrderId());
        String filePath = "cafe94/src/main/resources/self/Receipt" + receiptName + ".csv";
        PrintReceipt.writeOrderDetailsToCSV(order, filePath);
    }
}
