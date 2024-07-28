package Smart_Office_Facility_Programming;

public class BookingCommand implements Command {
    private Room room;
    private String time;
    private int duration;

    public BookingCommand(Room room, String time, int duration) {
        this.room = room;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public void execute() {
        if (room.isBooked()) {
            System.out.println("Room " + room.getId() + " is already booked during this time. Cannot book.");
        } else {
            room.setBooked(true);
            room.stopUnoccupiedTimer();
            System.out.println("Room " + room.getId() + " booked from " + time + " for " + duration + " minutes.");
        }
    }
}
