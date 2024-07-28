package Smart_Office_Facility_Programming;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OfficeConfiguration office = OfficeConfiguration.getInstance();

        // Adding observers
        Lights lights = new Lights();
        AirConditioner ac = new AirConditioner();

        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "Config":
                    if (parts[1].equals("room") && parts[2].equals("count")) {
                        int numRooms = Integer.parseInt(parts[3]);
                        office.configureRooms(numRooms);
                    } else if (parts[1].equals("room") && parts[2].equals("max") && parts[3].equals("capacity")) {
                        int roomId = Integer.parseInt(parts[4]);
                        int capacity = Integer.parseInt(parts[5]);
                        if (office.roomExists(roomId)) {
                            office.getRoom(roomId).setCapacity(capacity);
                        } else {
                            System.out.println("Invalid room number. Please enter a valid room number.");
                        }
                    }
                    break;
                case "Add":
                    if (parts[1].equals("occupant")) {
                        int roomId = Integer.parseInt(parts[2]);
                        int numPeople = Integer.parseInt(parts[3]);
                        if (!office.roomExists(roomId)) {
                            System.out.println("Room " + roomId + " does not exist.");
                            break;
                        }
                        Room room = office.getRoom(roomId);
                        room.addObserver(lights);
                        room.addObserver(ac);
                        if (numPeople >= 2) {
                            room.setOccupied(true);
                            room.stopUnoccupiedTimer();
                            System.out.println("Room " + roomId + " is now occupied by " + numPeople
                                    + " persons. AC and lights turned on.");
                        } else {
                            room.setOccupied(false);
                            room.startUnoccupiedTimer();
                            if (numPeople == 0) {
                                System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
                            } else {
                                System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
                            }
                        }
                    }
                    break;
                case "Block":
                    if (parts[1].equals("room")) {
                        try {
                            int roomId = Integer.parseInt(parts[2]);
                            String time = parts[3];
                            int duration = Integer.parseInt(parts[4]);
                            Room room = office.getRoom(roomId);
                            if (room == null) {
                                System.out.println("Invalid room number. Please enter a valid room number.");
                                break;
                            }
                            Command bookCommand = new BookingCommand(room, time, duration);
                            bookCommand.execute();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room number. Please enter a valid room number.");
                        }
                    }
                    break;
                case "Cancel":
                    if (parts[1].equals("room")) {
                        try {
                            int roomId = Integer.parseInt(parts[2]);
                            Room room = office.getRoom(roomId);
                            if (room == null) {
                                System.out.println("Invalid room number. Please enter a valid room number.");
                                break;
                            }
                            Command cancelCommand = new CancelBookingCommand(room);
                            cancelCommand.execute();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room number. Please enter a valid room number.");
                        }
                    }
                    break;
                case "Room":
                    if (parts[1].equals("status")) {
                        try {
                            int roomId = Integer.parseInt(parts[2]);
                            Room room = office.getRoom(roomId);
                            if (room == null) {
                                System.out.println("Invalid room number. Please enter a valid room number.");
                                break;
                            }
                            room.checkStatus();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room number. Please enter a valid room number.");
                        }
                    }
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}
