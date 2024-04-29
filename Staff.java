/*Class to create staff mmebers, view details, and see shift hours, and overtime*/

import java.util.ArrayList;

public class Staff {

    private float shiftHours;
    private float totalShiftHours;
    private int employeeNumber;
    private String employeeRole;
    private String firstName;
    private String lastName;

    private static ArrayList<Staff> staff = new ArrayList<>();

    public Staff(int employeeNumber, String employeeRole, String firstName, String lastName){
        this.employeeNumber = employeeNumber;
        this.employeeRole = employeeRole;
        this.firstName = firstName;
        this.lastName = lastName;
        staff.add(this);
    }

    // Getters and Setters
    public static ArrayList<Staff> getAllStaff() {
        return staff;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setShiftHours(float shiftHours){
        this.shiftHours = shiftHours;
    }

    public float getShiftHours(){
        return shiftHours;
    }

    public void setTotalShiftHours(float totalShiftHours){
        this.totalShiftHours = totalShiftHours;
    }

    public float getTotalShiftHours(){
        return totalShiftHours;
    }

    public float addOvertime(float overtime){
        return totalShiftHours + overtime;
    }

}
