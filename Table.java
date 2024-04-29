package booking;

public class Table {
    private final int numberOfSeats;
    private final int tableId;
    private boolean availability;

    private static int count;

    /**
     * Constructor
     */
    public Table(int tableId, int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setTableAvailability(boolean availability) {
        if (availability == false) {
            count++;
        } else if (availability == true && this.availability == false) {
            count--;
        }

        this.availability = availability;
    }

    public boolean getTableAvailable() {
        return availability;
    }

    public static int countBookedTables() {
        return count;
    }
}
