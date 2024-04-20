package order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import menu.MenuController;
import menu.MenuItem;
import self.App;
import transaction.PrintReceipt;

import java.io.IOException;

/**
 * Controller class for handling orders in the application.
 */
public class OrderController {

    /**
     * Reference to the current order retrieved from the menu.
     */
    Order order = MenuController.getOrderFromMenu();

    /**
     * ListView component to display the order items.
     */
    @FXML
    private ListView<String> orderListView = new ListView<>();

    /**
     * Switches the scene to the menu view.
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }

    /**
     * Initializes the controller, populating the order ListView with order details.
     */
    public void initialize() {
        ObservableList<String> orderItems = FXCollections.observableArrayList();
        for (MenuItem item : order.getOrder()) {
            String itemInfo = String.format("Name: %s, Type: %s, Price: £%.2f, Calories: %d, Vegan: %s, Quantity: %d",
                    item.getName(), item.getType(), item.getPrice(), item.getCalories(), item.isVegan() ? "Yes" : "No", item.getQuantity());
            orderItems.add(itemInfo);
        }
        String totalInfo = String.format("Total Calories: %d, Total Price: £%.2f", order.getTotalCalories(), order.getTotalPrice());
        orderItems.add(totalInfo);
        orderListView.setItems(orderItems);
    }

    /**
     * Handles the checkout button click event.
     *
     * <p>If the order is empty, switches to the menu view. Otherwise, prints the order receipt and returns to the start view.</p>
     *
     * @throws IOException If an I/O error occurs.
     */
    @FXML
    public void handleCheckOutButtonClick() throws IOException {
        if (order.isEmpty()) {
            switchToMenu();
        } else {
            printOrderToCSV();
            backToStart();
        }
    }

    /**
     * Returns to the start view.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void backToStart() throws IOException {
        App.setRoot("view");
    }

    /**
     * Prints the order details to CSV and Excel files.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void printOrderToCSV() throws IOException {
        String receiptName = String.valueOf(order.getOrderId());
        String filePath = "cafe94/src/main/resources/self/Receipt" + receiptName + ".csv";
        PrintReceipt.writeOrderDetailsToCSV(order, filePath);
    }
}
