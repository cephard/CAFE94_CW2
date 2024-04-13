package order;

import Menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> order;
    private int orderId;

    public Order(int orderId) {
        this.order = new ArrayList<>();
        this.orderId = orderId;
    }

    // Add an item to the order
    public void addItem(MenuItem item) {
        if (item != null) {
            order.add(item);
        } else {
            System.out.println("Cannot add null item to the order.");
        }
    }

    // Remove an item from the order
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

    // Get the total price of items in the order
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (MenuItem item : order) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    // Get the total calories of items in the order
    public int getTotalCalories() {
        int totalCalories = 0;
        for (MenuItem item : order) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    // Check if the order contains any vegan items
    public boolean containsVeganItem() {
        for (MenuItem item : order) {
            if (item.isVegan()) {
                return true;
            }
        }
        return false;
    }

    // Get all items in the order
    public ArrayList<MenuItem> getOrder() {
        return new ArrayList<>(order);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        return sb.toString();
    }

    public int getOrderId() {
        return  orderId;
    }
}
