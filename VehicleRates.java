public class VehicleRates {
    private double dailyRate, weeklyRate, monthlyRate, mileageCharge, dailyInsurance;

    public VehicleRates(double d, double w, double m, double perMile, double ins) {
        dailyRate = d;
        weeklyRate = w;
        monthlyRate = m;
        mileageCharge = perMile;
        dailyInsurance = ins;
    }

    public VehicleRates(VehicleRates other) {
        this(other.dailyRate, other.weeklyRate, other.monthlyRate, other.mileageCharge, other.dailyInsurance);
    }

    public double getDailyRate() { return dailyRate; }
    public double getWeeklyRate() { return weeklyRate; }
    public double getMonthlyRate() { return monthlyRate; }
    public double getMileageChrg() { return mileageCharge; }
    public double getDailyInsurRate() { return dailyInsurance; }

    public String toString() {
        return "Daily: $" + dailyRate + " Weekly: $" + weeklyRate + " Monthly: $" + monthlyRate +
               " Per Mile: $" + mileageCharge + " Daily Insurance: $" + dailyInsurance;
    }
}