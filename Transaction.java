public class Transaction {
    private String creditCardNum;
    private String customerName;
    private String vehicleType;
    private String rentalPeriod;
    private String milesDriven;
    private String rentalCost;

    public Transaction(String cc, String name, String type, String period, String miles, String cost) {
        creditCardNum = cc;
        customerName = name;
        vehicleType = type;
        rentalPeriod = period;
        milesDriven = miles;
        rentalCost = cost;
    }

    public String toString() {
        return customerName + " (card #" + creditCardNum + "), " + vehicleType + ", " + rentalPeriod + ", " + milesDriven + " mi $" + rentalCost;
    }
}
