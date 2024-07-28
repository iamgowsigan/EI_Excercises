package Smart_Office_Facility_Programming;

public class CancelBookingCommand implements Command {
    private Room room;

    public CancelBookingCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        if (!room.isBooked()) {
            System.out.println("Room " + room.getId() + " is not booked. Cannot cancel booking.");
        } else {
            room.setBooked(false);
            System.out.println("Booking for Room " + room.getId() + " cancelled successfully.");
        }
    }
}
