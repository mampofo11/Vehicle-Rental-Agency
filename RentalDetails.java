public class RentalDetails {
    private String vehicleType;
    private TimePeriod rentalPeriod;
    private int numMilesDriven;
    private boolean insuranceSelected;

    public RentalDetails(String vehicleType, TimePeriod rentalPeriod, int numMilesDriven, boolean insuranceSelected) {
        this.vehicleType = vehicleType;
        this.rentalPeriod = rentalPeriod;
        this.numMilesDriven = numMilesDriven;
        this.insuranceSelected = insuranceSelected;
    }

    public String getVehicleType() { return vehicleType; }
    public TimePeriod getRentalPeriod() { return rentalPeriod; }
    public int getNumMilesDriven() { return numMilesDriven; }
    public boolean isInsuranceSelected() { return insuranceSelected; }

    public String toString() {
        return vehicleType + " for " + rentalPeriod + ", " + numMilesDriven + " mi, Insurance: " + (insuranceSelected ? "Yes" : "No");
    }
}