/*Class to manage the waiter employee*/

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Waiter {

    // counts the number of waiters
    private static int count = 0;{
        count++;
    }

    public static int countWaiters() {
        return count;
    }

    // Method to create a new order
    public Order makeOrder(int orderId, ArrayList<MenuItem> order, OrderStatus orderStatus){
        Order newOrder = new Order(orderId);
        for(MenuItem item : order){
            newOrder.addItem(item);
        }
        // Adds new order to outstanding orders
        orderStatus.addOutstandingOrder(newOrder);

        return newOrder;
    }

    // Method to complete an order
    public void completeOrder(Order completeOrder, OrderStatus orderStatus) {
        orderStatus.addCompletedOrder(completeOrder);
    }
    // Method to approve a delivery
    public void approveDelivery(Order order, String deliveryAddress, LocalDateTime estimatedTime) {
        order.approveDelivery(deliveryAddress, estimatedTime);
    }

}
