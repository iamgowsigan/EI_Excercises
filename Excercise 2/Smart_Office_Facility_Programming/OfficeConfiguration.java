package Smart_Office_Facility_Programming;

import java.util.*;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, Room> rooms;

    private OfficeConfiguration() {
        rooms = new HashMap<>();
    }

    public static synchronized OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRooms(int numRooms) {
        rooms.clear();
        for (int i = 1; i <= numRooms; i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + numRooms + " meeting rooms: " + rooms.keySet() + ".");
    }

    public Room getRoom(int roomId) {
        return rooms.get(roomId);
    }

    public boolean roomExists(int roomId) {
        return rooms.containsKey(roomId);
    }
}
