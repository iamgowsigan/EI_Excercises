package Smart_Office_Facility_Programming;

import java.util.*;

public class Room {
    private int id;
    private int capacity;
    private boolean occupied;
    private boolean booked;
    private List<Observer> observers;
    private Timer timer;

    public Room(int id) {
        this.id = id;
        this.observers = new ArrayList<>();
        this.timer = new Timer();
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
            return;
        }
        this.capacity = capacity;
        System.out.println("Room " + id + " maximum capacity set to " + capacity + ".");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(occupied);
        }
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        notifyObservers();
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getId() {
        return id;
    }

    public void startUnoccupiedTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!occupied && booked) {
                    setBooked(false);
                    setOccupied(false);
                    notifyObservers();
                    System.out.println("Room " + id + " is now unoccupied. Booking released. AC and lights off.");
                }
            }
        }, 5 * 60 * 1000);
    }

    public void stopUnoccupiedTimer() {
        timer.cancel();
        timer = new Timer();
    }

    public void checkStatus() {
        if (occupied) {
            System.out.println("Room " + id + " is now occupied.");
        } else {
            System.out.println("Room " + id + " is now unoccupied. Booking released. AC and lights off");
        }
    }
}
