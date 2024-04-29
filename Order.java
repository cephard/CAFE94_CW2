package order;

import menu.MenuItem;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an order containing a list of menu items.
 */
public class Order {
    private final List<MenuItem> order;
    private final int orderId;
    private final Date orderDate;

    // Variables for delivery
    private final boolean delivery;
    private final String deliveryAddress;
    private final LocalDateTime estimatedTime;
    private final Driver assignedDriver;

    /**
     * Constructs an Order object with a specified order ID and the current date.
     *
     * @param orderId The ID of the order.
     */
    public Order(int orderId) {
        this.order = new ArrayList<>();
        this.orderId = orderId;
        this.orderDate = new Date();
        this.delivery = false;
    }

    public void approveDelivery(String deliveryAddress, LocalDateTime estimatedTime) {
        this.delivery = true;
        this.deliveryAddress = deliveryAddress;
        this.estimatedTime = estimatedTime;
    }

    public void assignDriver(Driver driver) {
        assignedDriver = driver;
    }

    /**
     * Adds a menu item to the order and increases the quantity if item already exists.
     *
     * @param menuItem The menu item to add.
     */
    public void addItem(MenuItem menuItem) {
        if (menuItem != null) {
            boolean itemFound = false;
            for (MenuItem item : order) {
                if (item.getName().equals(menuItem.getName())) {
                    item.updateQuantity();
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                order.add(menuItem);
            }
        } else {
            System.out.println("Cannot add null item to the order.");
        }
    }

    /**
     * Removes a menu item from the order.
     *
     * @param item The menu item to remove.
     */
    public void removeItem(MenuItem item) {
        if (item != null) {
            if (order.contains(item)) {
                order.remove(item);
            } else {
                System.out.println("Item is not in the order.");
            }
        } else {
            System.out.println("Cannot remove null item from the order.");
        }
    }

    /**
     * Calculates the total price of the items in the order.
     *
     * @return The total price of the order.
     */
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (MenuItem item : order) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Calculates the total calories of the items in the order.
     *
     * @return The total calories of the order.
     */
    public int getTotalCalories() {
        int totalCalories = 0;
        for (MenuItem item : order) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    /**
     * Checks if the order contains any vegan items.
     *
     * @return True if the order contains at least one vegan item, false otherwise.
     */
    public boolean containsVeganItem() {
        for (MenuItem item : order) {
            if (item.isVegan()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all items in the order.
     *
     * @return A list of all items in the order.
     */
    public ArrayList<MenuItem> getOrder() {
        return new ArrayList<>(order);
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The order ID.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Checks if the order is empty.
     *
     * @return True if the order is empty, false otherwise.
     */
    public boolean isEmpty() {
        return order.isEmpty();
    }

    /**
     * Generates a string representation of the order.
     *
     * @return The string representation of the order.
     */
    @Override
    public String toString() {
        String sb = "Order ID: " + orderId + "\n" +
                "Order Date: " + formatDate(orderDate) + "\n";
        return sb;
    }

    /**
     * Formats the given date object to a string in "yyyy-MM-dd" format.
     *
     * @param date The date object to format.
     * @return The formatted date string.
     */
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
