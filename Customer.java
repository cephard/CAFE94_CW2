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
    private final LocalDate creationDate;
    private boolean member;
    private ArrayList<Order> orderHistory;
    private ArrayList<Transaction> transactions;
    private final int telephoneNumber;

    private static int count = 0;

    private static ArrayList<Customer> customers = new ArrayList<>();

    {
        // counts the number of customers
        count++;
    }


    public Customer(int customerID, String firstName, String lastName, String address, int telephoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.creationDate = LocalDate.now();
        this.telephoneNumber = telephoneNumber;

        customers.add(this); // adds customer to an arraylist of customers
    }

    public static ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public void setMembership() {
        if (!member) {
            member = true;
        }
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public boolean isMember() {
        return member;
    }

    public ArrayList<Order> viewOrderHistory() {
        return orderHistory;
    }

    public void cancelOrder(Order order) {

    }

    public void makePayment(Transaction payment) {

    }

    public static int countCustomers() {
        return count;
    }
}
