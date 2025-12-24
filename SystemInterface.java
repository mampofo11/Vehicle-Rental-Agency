import java.util.*;

public class SystemInterface {

    private static CurrentRates agencyRates;
    private static Vehicles agencyVehicles;
    private static Transactions transactionsHistory;

    public static void initSystem(CurrentRates rates, Vehicles vehicles, Transactions transactions) {
        agencyRates = rates;
        agencyVehicles = vehicles;
        transactionsHistory = transactions;
    }

    public static boolean initialized() {
        return agencyRates != null;
    }

    public static String[] getCarRates() {
        return new String[]{agencyRates.getCarRates().toString()};
    }

    public static String[] getSUVRates() {
        return new String[]{agencyRates.getSUVRates().toString()};
    }

    public static String[] getMinivanRates() {
        return new String[]{agencyRates.getMinivanRates().toString()};
    }

    public static String[] updateCarRates(VehicleRates newRates) {
        agencyRates.setCarRates(newRates);
        return new String[]{"Car rates updated successfully."};
    }

    public static String[] updateSUVRates(VehicleRates newRates) {
        agencyRates.setSUVRates(newRates);
        return new String[]{"SUV rates updated successfully."};
    }

    public static String[] updateMinivanRates(VehicleRates newRates) {
        agencyRates.setMinivanRates(newRates);
        return new String[]{"Minivan rates updated successfully."};
    }

    public static String[] calcRentalCost(RentalDetails details) {
        int type;
        if (details.getVehicleType().equalsIgnoreCase("car")) {
            type = 1;
        } else if (details.getVehicleType().equalsIgnoreCase("suv")) {
            type = 2;
        } else {
            type = 3;
        }

        double cost = agencyRates.calcEstimatedCost(
            type,
            details.getRentalPeriod(),
            details.getNumMilesDriven(),
            details.isInsuranceSelected()
        );
        return new String[]{"Estimated rental cost: $" + String.format("%.2f", cost)};
    }

    public static String[] getAvailCars() {
        ArrayList<String> available = new ArrayList<>();
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            Vehicle v = agencyVehicles.getNext();
            if (v instanceof Car && !v.isReserved()) {
                available.add(v.toString());
            }
        }
        return available.toArray(new String[0]);
    }

    public static String[] getAvailSUVs() {
        ArrayList<String> available = new ArrayList<>();
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            Vehicle v = agencyVehicles.getNext();
            if (v instanceof SUV && !v.isReserved()) {
                available.add(v.toString());
            }
        }
        return available.toArray(new String[0]);
    }

    public static String[] getAvailMinivans() {
        ArrayList<String> available = new ArrayList<>();
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            Vehicle v = agencyVehicles.getNext();
            if (v instanceof Minivan && !v.isReserved()) {
                available.add(v.toString());
            }
        }
        return available.toArray(new String[0]);
    }

    public static String[] getAllVehicles() {
        ArrayList<String> all = new ArrayList<>();
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            all.add(agencyVehicles.getNext().toString());
        }
        return all.toArray(new String[0]);
    }

    public static String[] makeReservation(ReservationDetails resv) {
        try {
            Vehicle v = agencyVehicles.getVehicle(resv.getVIN());
            v.setReservation(resv);
            v.setQuotedRates(getRatesBasedOnVehicle(v));
            return new String[]{"Reservation confirmed for " + v.getDescription()};
        } catch (Exception e) {
            return new String[]{"Reservation failed: " + e.getMessage()};
        }
    }

    public static String[] cancelReservation(String creditCardNum, String vin) {
        try {
            Vehicle v = agencyVehicles.getVehicle(vin);
            if (!v.isReserved()) {
                return new String[]{"Vehicle is not reserved."};
            }
            if (!v.getReservation().getCreditCardNum().equals(creditCardNum)) {
                return new String[]{"Credit card number does not match reservation."};
            }
            v.cancelReservation();
            return new String[]{"Reservation canceled successfully."};
        } catch (Exception e) {
            return new String[]{"Cancellation failed: " + e.getMessage()};
        }
    }

    public static String[] processReturnedVehicle(String vin, int daysUsed, int milesDriven) {
        try {
            Vehicle v = agencyVehicles.getVehicle(vin);
            if (!v.isReserved()) {
                return new String[]{"Vehicle was not reserved."};
            }

            ReservationDetails resv = v.getReservation();
            double finalCost = agencyRates.calcActualCost(
                v.getQuotedRates(),
                daysUsed,
                milesDriven,
                resv.isInsuranceSelected()
            );

            transactionsHistory.add(new Transaction(
                resv.getCreditCardNum(),
                resv.getCustomerName(),
                v.getDescription(),
                daysUsed + " days",
                milesDriven + "",
                String.format("%.2f", finalCost)
            ));

            v.cancelReservation();
            return new String[]{"Total charge: $" + String.format("%.2f", finalCost)};
        } catch (Exception e) {
            return new String[]{"Return failed: " + e.getMessage()};
        }
    }

    public static String[] getReservation(String vin) {
        try {
            Vehicle v = agencyVehicles.getVehicle(vin);
            if (!v.isReserved()) {
                return new String[]{"Vehicle with VIN " + vin + " is not currently reserved."};
            }
            return new String[]{v.getReservation().toString()};
        } catch (Exception e) {
            return new String[]{"Error: " + e.getMessage()};
        }
    }

    public static String[] getAllReservations() {
        ArrayList<String> reservs = new ArrayList<>();
        agencyVehicles.reset();
        while (agencyVehicles.hasNext()) {
            Vehicle v = agencyVehicles.getNext();
            if (v.isReserved()) {
                reservs.add(v.getReservation().toString());
            }
        }
        return reservs.toArray(new String[0]);
    }

    public static String[] getAllTransactions() {
        ArrayList<String> trans = new ArrayList<>();
        transactionsHistory.reset();
        while (transactionsHistory.hasNext()) {
            trans.add(transactionsHistory.getNext().toString());
        }
        return trans.toArray(new String[0]);
    }

    private static VehicleRates getRatesBasedOnVehicle(Vehicle v) {
        if (v instanceof Car) {
            return new VehicleRates(agencyRates.getCarRates());
        } else if (v instanceof SUV) {
            return new VehicleRates(agencyRates.getSUVRates());
        } else {
            return new VehicleRates(agencyRates.getMinivanRates());
        }
    }
}
