package transaction;

import menu.MenuController;
import order.Order;
import customer.Customer;

public class Transaction {
    Order order = MenuController.getOrderFromMenu();
    public Transaction(Order order, Customer customer ,boolean paymentType,double amount){

    }
    public double payAmount(double amount){
        if (amount < order.getTotalPrice()){
            System.out.println("Insuffcient funds");
        }
        return amount;
    }
}
