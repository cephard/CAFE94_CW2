/*Class that goves the manager admin authorites over all of the staff functions.
 * The manager can view the number of staff members, customers, tables and orders.
 * They can also add, remove, and edit staff members, generate reports on the
 * most popular items, busiest periods, most active customer, and highest number of hours
 * worked by staff members. */

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map.Entry;
 
 static final String CUSTOMER_REPORT_STRING = "There are %d customers";
 static final String CHEF_REPORT_STRING = "There are %d chefs working";
 static final String TABLE_REPORT_STRING = "There are %d tables booked";
 static final String WAITER_REPORT_STRING = "There are %d waiters working";
 static final String MORE_CHEFS_STRING = "%d more Chefs are needed";
 static final String MORE_WAITERS_STRING = "%d more Waiters are needed";
 static final String POPULAR_ITEMS_STRING = "The most popular items on the menu are:";
 static final String POPULAR_ITEMS_FORMAT = "%s: ordered %d times";
 static final String MOST_HOURS_WORKED_STRING = "The staff member with the most hours worked is %s, who worked %d hours";
 static final String STAFF_HOURS_ERROR = "Couldn't find staff member.";
 
 public class Manager {
 
     public void counts() {
         int chefCount = Chef.countChefs();
         int waiterCount = Waiter.countWaiters();
         int bookedTablesCount = Table.countBookedTables();
         int customersCount = Customer.countCustomers();
 
         /*Print out the number of customers present and tables booked, 
          * and the number of chefs and waiters currently working*/
         System.out.println(String.format(CUSTOMER_REPORT_STRING, customersCount));
         System.out.println(String.format(CHEF_REPORT_STRING, chefCount));
         System.out.println(String.format(TABLE_REPORT_STRING, bookedTablesCount));
         System.out.println(String.format(WAITER_REPORT_STRING, waiterCount));
 
         // Alert the manager if more staff are needed for the shift
         if (customersCount/10 > chefCount/2) {
             int moreChefs = customersCount/10 - chefCount/2;
             System.out.println(String.format(MORE_CHEFS_STRING, moreChefs*2));
         }
         if (bookedTablesCount/2 > waiterCount) {
             int moreWaiters = bookedTablesCount/2 - waiterCount;
             System.out.println(String.format(MORE_WAITERS_STRING, moreWaiters));
         }
 
     }
 
     /*Admin methods to edit staff members' details and manage overtime.*/
 
      // Create a new staff member
     public Staff createStaff(int employeeNumber, String employeeRole, 
                               String firstName, String lastName) {
         Staff newStaff = new Staff(employeeNumber, employeeRole, firstName, lastName);
         return newStaff;
     }
 
     // Remove a staff member
     public void removeStaff(Staff staff) {
         staff = null;
     }
 
     // Edit staff member role
     public Staff editStaffRole(Staff staff, String employeeRole) {
         staff.setEmployeeRole(employeeRole);
         return staff;
     }
 
     // Edit staff member first name
     public Staff editStaffFirstName(Staff staff, String firstName) {
         staff.setFirstName(firstName);
         return staff;
     }
 
     // Edit staff member last name
     public Staff editStaffLastName(Staff staff, String lastName) {
         staff.setLastName(lastName);
         return staff;
     }
 
     // Manage staff members' shift hours
     public Staff setShiftHours(Staff staff, float shiftHours) {
         staff.setShiftHours(shiftHours);
         return staff;
     }
 
     // Manage staff members' total shift hours
     public Staff setTotalShiftHours(Staff staff, float totalShiftHours) {
         staff.setTotalShiftHours(totalShiftHours);
         return staff;
     }
 
     // Manage staff members' overtime
     public Staff setOvertime(Staff staff, float overtime) {
         staff.addOvertime(overtime);
         return staff;
     }
 
 
     /*Generate reports on the most popular items, busiest periods, most active customer,
      * and highest number of hours worked by staff members.*/
     public void generateReport(OrderStatus orderStatus) {
        
         /* Generate most popular items */
         // Create arrayList of all orders
         ArrayList<Order> allOrders = new ArrayList<>();
         allOrders.addAll(orderStatus.getOutstandingOrders());
         allOrders.addAll(orderStatus.getCompletedOrders());
 
         /*Create hashmap to store the quantities of the menu items,
          * as to map the amount of times an item has been 
          * ordered against the item name.*/
         HashMap<String, Integer> quantities = new HashMap<String, Integer>();
 
         for (Order order : allOrders) {
             if (order.isEmpty()) {continue;}
             for (MenuItem item : order.getOrder()) {
                 // Adds new item if it doesn't exist, increases quantity if it does
                 quantities.merge(item.getName(), item.getQuantity(), Integer::sum);
             }
         }
 
         // Names and quantities of the three most popular items
         String mostPopularItem = "";
         String secondMostPopularItem = "";
         String thirdMostPopularItem = "";
 
         int highestQuantity = 0;
         int secondHighestQuantity = 0;
         int thirdHighestQuantity = 0;
 
         // Loop through the hashmap and find the top 3 most popular items
         for (Entry<String, Integer> set : quantities.entrySet()) {
             if (set.getValue() > highestQuantity) {
                 thirdMostPopularItem = secondMostPopularItem;
                 thirdHighestQuantity = secondHighestQuantity;
 
                 secondMostPopularItem = mostPopularItem;
                 secondHighestQuantity = highestQuantity;
 
                 mostPopularItem = set.getKey();
                 highestQuantity = set.getValue();
             } else if (set.getValue() > secondHighestQuantity) {
                 thirdMostPopularItem = secondMostPopularItem;
                 thirdHighestQuantity = secondHighestQuantity;
 
                 secondMostPopularItem = set.getKey();
                 secondHighestQuantity = set.getValue();
             } else if (set.getValue() > thirdHighestQuantity) {
                 thirdMostPopularItem = set.getKey();
                 thirdHighestQuantity = set.getValue();
             }
         }
 
         System.out.println(POPULAR_ITEMS_STRING);
         System.out.println(String.format(POPULAR_ITEMS_FORMAT, mostPopularItem, highestQuantity));
         System.out.println(String.format(POPULAR_ITEMS_FORMAT, secondMostPopularItem, secondHighestQuantity));
         System.out.println(String.format(POPULAR_ITEMS_FORMAT, thirdMostPopularItem, thirdHighestQuantity));
 
         /* Most active customer */
         // Get arraylist of all customers
         ArrayList<Customer> customers = new ArrayList<>();
         customers = Customer.getAllCustomers();
 
         int mostOrders = 0;
         String customerName = "";
 
         // Loop through all customers to find the customer with the most items ordered
         for (Customer customer : customers) {
             if (customer.viewOrderHistory().size() > mostOrders) {
                 mostOrders = customer.viewOrderHistory().size();
                 customerName = customer.getName();
             }
         }
 
         if (customerName != "") {
             System.out.println("The customer with the most orders is " + customerName + ".");
         } else {
             System.out.println("Could not find the most active customer.");
         }
 
         /* Highest number of hours worked by staff members */
         // Get arraylist of all staff
         ArrayList<Staff> staffList = new ArrayList<>();
         staffList = Staff.getAllStaff();
 
         float mostHoursWorked = 0;
         String staffName = "";
 
         // Loop through all Staff and find who has the most hours worked
         for (Staff staff : staffList) {
             if (staff.getTotalShiftHours() > mostHoursWorked) {
                 mostHoursWorked = staff.getTotalShiftHours();
                 staffName = staff.getName();
             }
         }
 
         if (staffName != "") {
             System.out.println(String.format(MOST_HOURS_WORKED_STRING, staffName, mostHoursWorked));
         } else {
             System.out.println(STAFF_HOURS_ERROR);
         }
     }
 
 }
 
