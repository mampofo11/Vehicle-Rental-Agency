public class Car extends Vehicle {
    private int seating;

    public Car(String description, int mpg, int seating, String vin) {
        super(description, mpg, vin);
        this.seating = seating;
    }

    public String toString() {
        return description + " (Car) MPG: " + mpg + " Seating: " + seating + " VIN: " + vin;
    }
}