/*Class to manage the Driver employee role. Assigns 
 * drivers to delivery orders, and marks orders as 
 * complete when they have been delievred*/

 public class Driver {

    // Assigns the driver to an order
    public void assignToOrder(Order order) {
        order.assignDriver(this);
    }

    // Delivers the order and marks it as complete
    public void deliverOrder(Order order, OrderStatus orderStatus) {
        orderStatus.addCompletedOrder(order);
    }
}
