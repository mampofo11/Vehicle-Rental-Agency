public class ReservationDetails {
    private String customerName;
    private String creditCardNum;
    private TimePeriod rentalPeriod;
    private boolean insuranceSelected;
    private String vin;

    public ReservationDetails(String name, String card, TimePeriod period, boolean insurance, String vin) {
        this.customerName = name;
        this.creditCardNum = card;
        this.rentalPeriod = period;
        this.insuranceSelected = insurance;
        this.vin = vin;
    }

    public String getCustomerName() { return customerName; }
    public String getCreditCardNum() { return creditCardNum; }
    public TimePeriod getRentalPeriod() { return rentalPeriod; }
    public boolean isInsuranceSelected() { return insuranceSelected; }
    public String getVIN() { return vin; }

    public String toString() {
        return customerName +
                " (card #" + creditCardNum + "), " +
                "VIN: " + vin + ", " +
                rentalPeriod + 
                ", Insurance: " + (insuranceSelected ? "Yes" : "No");
    }
}