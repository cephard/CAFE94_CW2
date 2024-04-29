/*Class to manage and track employee clock-in/out times */

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Employee {

    // LinkedLists to store the clock in and out times as the order is important
    private LinkedList<LocalDateTime> clockInTimes;
    private LinkedList<LocalDateTime> clockOutTimes;
    public int employeeNumber;

    public Employee() {
        this.clockInTimes = new LinkedList<>();
        this.clockOutTimes = new LinkedList<>();
    }

    public void clockIn() {
        this.clockInTimes.add(LocalDateTime.now());
    }

    public LocalDateTime getLastClockInTime(){
        return this.clockInTimes.getLast();
    }

    public void clockOut() {
        this.clockOutTimes.add(LocalDateTime.now());
    }

    public LocalDateTime getLastClockOutTime(){
        return this.clockOutTimes.getLast();
    }
    
}
