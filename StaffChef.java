public class StaffChef extends Employee {

    public StaffChef(int id, String firstName, String lastName, String role) {
      super(id, firstName, lastName, role);
    }
  
    public void dailySpecial() {
      // Add implementation here
    }
  
    public void markOrderState(Order currentOrder) {
      currentOrder.setCooked(true);
    }
  
  }