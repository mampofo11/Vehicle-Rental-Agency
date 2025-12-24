public class CurrentRates {
    private VehicleRates[] rates = new VehicleRates[3];  // car, suv, minivan

    public CurrentRates(VehicleRates car, VehicleRates suv, VehicleRates minivan) {
        rates[0] = car;
        rates[1] = suv;
        rates[2] = minivan;
    }

    public VehicleRates getCarRates() { return rates[0]; }
    public void setCarRates(VehicleRates r) { rates[0] = r; }

    public VehicleRates getSUVRates() { return rates[1]; }
    public void setSUVRates(VehicleRates r) { rates[1] = r; }

    public VehicleRates getMinivanRates() { return rates[2]; }
    public void setMinivanRates(VehicleRates r) { rates[2] = r; }

    public double calcEstimatedCost(int vehicleType, TimePeriod estimatedRentalPeriod,  
                                int estimatedNumMiles, boolean dailyInsur) {
    VehicleRates rates;
    switch(vehicleType) {
        case 1: rates = getCarRates(); break;
        case 2: rates = getSUVRates(); break;
        case 3: rates = getMinivanRates(); break;
        default: return 0.0;
    }

    int totalDays = estimatedRentalPeriod.getUnit() == 'd' ? estimatedRentalPeriod.getQuantity() :
                    estimatedRentalPeriod.getUnit() == 'w' ? estimatedRentalPeriod.getQuantity() * 7 :
                    estimatedRentalPeriod.getQuantity() * 31;

    double cost = 0.0;

    if (estimatedRentalPeriod.getUnit() == 'd') {
        cost = rates.getDailyRate() * estimatedRentalPeriod.getQuantity();
    } else if (estimatedRentalPeriod.getUnit() == 'w') {
        cost = rates.getWeeklyRate() * estimatedRentalPeriod.getQuantity();
    } else {
        cost = rates.getMonthlyRate() * estimatedRentalPeriod.getQuantity();
    }

    cost += estimatedNumMiles * rates.getMileageChrg();

    if (dailyInsur) {
        cost += totalDays * rates.getDailyInsurRate();
    }

    return cost;
}

public double calcActualCost(VehicleRates rates, int numDaysUsed, int numMilesDriven, boolean dailyInsur) {
    int months = numDaysUsed / 31;
    int leftoverDaysAfterMonths = numDaysUsed % 31;

    int weeks = leftoverDaysAfterMonths / 7;
    int leftoverDays = leftoverDaysAfterMonths % 7;

    double cost = months * rates.getMonthlyRate()
                + weeks * rates.getWeeklyRate()
                + leftoverDays * (rates.getMonthlyRate() / 31.0);

    cost += numMilesDriven * rates.getMileageChrg();

    if (dailyInsur) {
        cost += numDaysUsed * rates.getDailyInsurRate();
    }

    return cost;
}
}