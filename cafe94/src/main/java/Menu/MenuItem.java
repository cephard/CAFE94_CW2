package Menu;

public class MenuItem {
    private String name;
    private String type;
    private double price;
    private int calories;
    private boolean vegan;

    public MenuItem(String name, String type, double price, int calories, boolean vegan) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.calories = calories;
        this.vegan = vegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", vegan=" + vegan +
                '}';
    }
}


