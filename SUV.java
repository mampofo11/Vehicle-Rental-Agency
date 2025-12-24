public class SUV extends Vehicle {
    private int seating;
    private int cargo;

    public SUV(String description, int mpg, int seating, int cargo, String vin) {
        super(description, mpg, vin);
        this.seating = seating;
        this.cargo = cargo;
    }

    public String toString() {
        return description + " (SUV) MPG: " + mpg + " Seating: " + seating + " Cargo Storage: " + cargo + " cu. ft. VIN: " + vin;
    }
}