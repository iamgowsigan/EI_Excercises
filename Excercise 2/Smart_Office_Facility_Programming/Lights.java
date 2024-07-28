package Smart_Office_Facility_Programming;

public class Lights implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            System.out.println("Lights turned on.");
        } else {
            System.out.println("Lights turned off.");
        }
    }
}
