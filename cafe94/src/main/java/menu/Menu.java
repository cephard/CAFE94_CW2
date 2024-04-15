package menu;

import java.util.ArrayList;

public class Menu {
        private ArrayList<MenuItem> menu;

        public Menu() {
            this.menu = new ArrayList<>();
        }

        public void addItem(MenuItem menuItem) {
            menu.add(menuItem);
        }

        public MenuItem getItem(MenuItem menuItem){
            return menuItem;
        }
        private String croisantImage = "cafe94/src/main/resources/self/IMAGES/crossiant.png";
    private String avocadoToastImage = "cafe94/src/main/resources/self/IMAGES/Avocado_Toast.png";
    private String Caprese_Salad = "cafe94/src/main/resources/self/IMAGES/Caprese_Salad.png";
    private String grilled_Sandwich = "cafe94/src/main/resources/self/IMAGES/Grilled_Sandwich.png";
    private String blueberrymuffin = "cafe94/src/main/resources/self/IMAGES/Blueberry_Muffin.png";
    private String Quinoa_Salad = "cafe94/src/main/resources/self/IMAGES/Quinoa_Salad.png";
    private  String Veggie_Wrap = "cafe94/src/main/resources/self/IMAGES/Veggie_Wrap.jpg";
    private String Broth_Bowl = "cafe94/src/main/resources/self/IMAGES/Broth_Bowl.png";
    private String Chai_Latte = "cafe94/src/main/resources/self/IMAGES/Chai_Latte.png";
    private  String Cream_Bagel = "cafe94/src/main/resources/self/IMAGES/Cream_Bagel.png";
    private  String Fruit_Smoothie = "cafe94/src/main/resources/self/IMAGES/Fruit_Smoothie.png";
    private String Club_Sandwich = "cafe94/src/main/resources/self/IMAGES/Club_Sandwich.png";



    MenuItem croissant = new MenuItem("Croissant", "Pastry", 2.10, 230, false,1,croisantImage);
    MenuItem avocadoToast = new MenuItem("Avocado Toast", "Breakfast", 5.75, 320, true,1,avocadoToastImage);
    MenuItem capreseSaladd = new MenuItem("Caprese Salad", "Salad", 7.99, 250, false,1,Caprese_Salad);
    MenuItem grilledSandwich = new MenuItem("Grilled Sandwich", "Sandwich", 4.93, 4800, false,1,grilled_Sandwich);
    MenuItem blueBerryMuffin = new MenuItem("Blueberry Muffin", "Pastry", 2.99, 350, false,1,blueberrymuffin);
    MenuItem quionaSalad = new MenuItem("Quinoa Salad", "Salad", 7.19, 320, true,1,Quinoa_Salad);
    MenuItem veggieWrap = new MenuItem("Veggie Wrap", "Sandwich", 6.99, 280, true,1,Veggie_Wrap);
    MenuItem brothBowl = new MenuItem("Broth Bowl", "Soup", 7.99, 470, true,1,Broth_Bowl);
    MenuItem chaiLatte = new MenuItem("Chai Latte", "Coffee", 3.99, 1200, false,1,Chai_Latte);
    MenuItem creamBagel = new MenuItem("Cream Bagel", "Snack", 3.49, 350, false,1,Cream_Bagel);
    MenuItem fruitSmoothie = new MenuItem("Fruit Smoothie", "Beverage", 5.99, 200, true,1,Fruit_Smoothie);
    MenuItem clubSandwich = new MenuItem("Club Sandwich", "Sandwich", 8.49, 650, false,1,Club_Sandwich);
}

