package Smart_Office_Facility_Programming;

public class AirConditioner implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            System.out.println("AC turned on.");
        } else {
            System.out.println("AC turned off.");
        }
    }
}
