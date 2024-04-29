/*Class to manage a list of outstanding orders for all staff to see*/

import java.util.ArrayList;

public class OrderStatus {
    private final ArrayList<Order> outstandingOrders;
    private final ArrayList<Order> completedOrders;

    // Constructor to initialise the outstanding and completed orders
    public OrderStatus() {
        this.outstandingOrders = new ArrayList<>();
        this.completedOrders = new ArrayList<>();
    }

    // Method to add an order to the outstanding orders
    public void addOutstandingOrder(Order newOrder) {
        if (newOrder != null) {

            // Ensure order isn't already in outstanding orders
            boolean itemFound = false;
            for (Order order : outstandingOrders) {
                if (order.getOrderId() == newOrder.getOrderId()) {
                    System.out.println("Order already in Outstanding Orders.");
                    itemFound = true;
                    break;
                }
            }
            // Add order to outstanding orders
            if (!itemFound) {
                outstandingOrders.add(newOrder);
            }
        } else {
            System.out.println("Cannot add null order to Outstanding Orders.");
        }
    }

    // Method to add a completed order to the completed orders  
    public void addCompletedOrder(Order completeOrder) {
        if (completeOrder != null) {
            // Ensure order is in outstanding orders
            for (Order order : outstandingOrders) {
                if (order.getOrderId() == completeOrder.getOrderId()) {
                    // Move order from outstanding orders to completed orders
                    outstandingOrders.remove(order);
                    completedOrders.add(completeOrder);
                    break;
                }
            }
            System.out.println("Order not found in Outstanding Orders.");
        } else {
            System.out.println("Cannot add null order to Complete Orders.");
        }
    }

    // Shows outstanding orders
    public ArrayList<Order> getOutstandingOrders() {
        return outstandingOrders;
    }

    // Shows completed orders
    public ArrayList<Order> getCompletedOrders() {
        return completedOrders;
    }

}
