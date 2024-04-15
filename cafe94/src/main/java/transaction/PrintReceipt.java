package transaction;

import menu.MenuItem;
import order.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintReceipt {
    public static void writeOrderDetailsToCSV(Order order, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Name,Type,Price,Calories,Vegan\n");
            ArrayList<MenuItem> items = order.getOrder();
            for (MenuItem item : items) {
                writer.write(item.getName() + ", ");
                writer.write(item.getType() + ", ");
                writer.write(String.format("£%.2f ", item.getPrice()) + ", ");
                writer.write(item.getCalories() + ", ");
                writer.write(item.isVegan() ? "Yes\n" : "No\n");
            }
            writer.write("Total Calories: " + order.getTotalCalories() + "\n");
            writer.write(String.format("Total Price: £%.2f\n ", order.getTotalPrice()));
            System.out.println("Order details written to CSV file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the order details to the CSV file.");
            e.printStackTrace();
        }
    }
}
