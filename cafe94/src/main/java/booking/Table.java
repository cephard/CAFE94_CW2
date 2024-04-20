package booking;

public class Table {
    private final int numberOfSeats;
    private final int tableId;
    private boolean availability;

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
        this.availability = availability;
    }

    public boolean getTableAvailable() {
        return availability;
    }
}
