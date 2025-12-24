public class Minivan extends Vehicle {
    private int cargo;

    public Minivan(String description, int mpg, int cargo, String vin) {
        super(description, mpg, vin);
        this.cargo = cargo;
    }

    public String toString() {
        return description + " (Minivan) MPG: " + mpg + " Cargo Storage: " + cargo + " cu. ft. VIN: " + vin;
    }
}