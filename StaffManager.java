import java.util.ArrayList;

public class StaffManager extends Staff {

  private ArrayList<Staff> staffCover;

  public StaffManager(int id, String firstName, String lastName, String role) {
    super(id, firstName, lastName, role);
    this.staffCover = new ArrayList<>();
  }

  public void addStaff(Staff newStaff) {
    staffCover.add(newStaff);
  }

  public void removeStaff(Staff Staff) {
    staffCover.remove(Staff);
  }

  public ArrayList<Staff> getStaffCover() {
    return staffCover;
  }

  public void editStaffDetails() {
    // Add implementation here
  }

}