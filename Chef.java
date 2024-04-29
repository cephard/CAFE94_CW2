/*Class that manages the Chef employee role through counting 
* the amount of chefs present, being able to create new daily 
* specials and to move current menu items onto the specials board*/

public class Chef {

    private static int count = 0;

    {
        // counts the number of chefs
        count++;
    }

    public void completeOrder(Order completeOrder, OrderStatus orderStatus) {
        orderStatus.addCompletedOrder(completeOrder);
    }

    // Creates a new daily special
    public MenuItem createSpecial(String name, String type, double price, 
                                  int calories, boolean vegan, int quantity, String itemImagePath) {
        MenuItem newSpecial = new MenuItem(name, type, price, calories, vegan, quantity, itemImagePath);
        newSpecial.setSpecial();
        return newSpecial;
    }

    // Sets a prexisiting menuItem as the daily special
    public void setSpecialItem(MenuItem item) {
        item.setSpecial();
    }

    public static int countChefs() {
        return count;
    }

}
