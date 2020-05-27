//

public class Taxi {
        
    /*
     * Put global fields here.
     */
    private double rate;
    private int capacity;
    private int passengers;
    
    
    public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        rate = 0.0;
        capacity = 0;
        passengers = 0;
    }
    
    public Taxi(double rate, int capacity) {
        this.rate = rate;
        this.capacity = capacity;
    }
    
    public double calculateFare(int passengersLeaving, int durationOfRide) {
        return passengersLeaving*durationOfRide*rate;
    }

    public boolean pickUp(int passengersLoading) {
        if (capacity < passengersLoading) {
            return false;
        }
        return true;
    }
}