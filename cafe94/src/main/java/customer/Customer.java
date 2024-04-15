package customer;

import order.Order;
import transaction.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private final int customerID;
    private final String firstName;
    private final String lastName;
    private final String address;
    private boolean member;
    private ArrayList<Order> orderHistory;
    private ArrayList<Transaction> transactions;
    private final LocalDate creationDate;
    private int telephoneNumber;


    public Customer(int customerID, String firstName, String lastName, String address,int telephoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.creationDate = LocalDate.now();
        this.telephoneNumber = telephoneNumber;
    }

    public void setMmbership() {
        if (!member) {
            member = true;
        }
    }

    public boolean isMember() {
        return member;
    }

    public ArrayList<Order> viewOrderHistory() {

        return null;
    }

    public void cancelOrder(Order order) {

    }

    public void makePayment(Transaction payment) {

    }
}
