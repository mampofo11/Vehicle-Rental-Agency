public abstract class Vehicle {
    protected String description;
    protected int mpg;
    protected String vin;
    protected ReservationDetails resv;
    protected VehicleRates quotedRates;

    public Vehicle(String description, int mpg, String vin) {
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        this.resv = null;
        this.quotedRates = null;
    }

    public String getDescription() { return description; }
    public int getMpg() { return mpg; }
    public String getVIN() { return vin; }
    public ReservationDetails getReservation() { return resv; }
    public VehicleRates getQuotedRates() { return quotedRates; }
    public boolean isReserved() { return resv != null; }

    public void setReservation(ReservationDetails resv) throws Exception {
        if (this.resv != null) throw new Exception("Vehicle already reserved.");
        this.resv = resv;
    }

    public void setQuotedRates(VehicleRates cost) {
        this.quotedRates = new VehicleRates(cost);
    }

    public void cancelReservation() throws Exception {
        if (this.resv == null) throw new Exception("No reservation exists.");
        this.resv = null;
    }

    public abstract String toString();
}