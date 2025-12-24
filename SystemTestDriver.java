
public class SystemTestDriver {
    public static void main(String[] args) {
        // Setup initial rates
        VehicleRates carRates = new VehicleRates(24.95, 169.95, 514.95, 0.16, 14.95);
        VehicleRates suvRates = new VehicleRates(29.95, 189.95, 679.95, 0.16, 14.95);
        VehicleRates minivanRates = new VehicleRates(36.95, 224.95, 687.95, 0.21, 19.95);
        CurrentRates agencyRates = new CurrentRates(carRates, suvRates, minivanRates);

        // Setup vehicles
        Vehicles agencyVehicles = new Vehicles();
        agencyVehicles.add(new Car("Batmobile", 57, 4, "DCU001"));
        agencyVehicles.add(new SUV("Invinsible Jet", 36, 7, 6, "WWM426"));
        agencyVehicles.add(new Minivan("Krypto", 36, 9, "BFJ386"));

        // Setup empty transactions
        Transactions transactionsHistory = new Transactions();

        // Initialize system
        SystemInterface.initSystem(agencyRates, agencyVehicles, transactionsHistory);

        // --- Test: View Current Rates ---
        System.out.println(">>> Car Rates:");
        printArray(SystemInterface.getCarRates());

        System.out.println(">>> SUV Rates:");
        printArray(SystemInterface.getSUVRates());

        System.out.println(">>> Minivan Rates:");
        printArray(SystemInterface.getMinivanRates());

        // --- Test: Update Rates ---
        System.out.println(">>> Updating Car Rates...");
        SystemInterface.updateCarRates(new VehicleRates(26.95, 175.95, 520.95, 0.17, 15.95));
        printArray(SystemInterface.getCarRates());

        // --- Test: View Available Vehicles ---
        System.out.println(">>> Available Cars:");
        printArray(SystemInterface.getAvailCars());

        System.out.println(">>> Available SUVs:");
        printArray(SystemInterface.getAvailSUVs());

        System.out.println(">>> Available Minivans:");
        printArray(SystemInterface.getAvailMinivans());

        // --- Test: Estimate Rental Cost ---
        RentalDetails rentalDetails = new RentalDetails("car", new TimePeriod('d', 5), 300, true);
        System.out.println(">>> Estimated Rental Cost for Car:");
        printArray(SystemInterface.calcRentalCost(rentalDetails));

        // --- Test: Make Reservation ---
        ReservationDetails reservation = new ReservationDetails(
            "Jane Smith", 
            "1234567812345678", 
            new TimePeriod('d', 5), 
            true, 
            "ABD456"
        );
        System.out.println(">>> Making Reservation:");
        printArray(SystemInterface.makeReservation(reservation));

        // --- Test: View All Reservations ---
        System.out.println(">>> Current Reservations:");
        printArray(SystemInterface.getAllReservations());

        // --- Test: Cancel Reservation ---
        System.out.println(">>> Cancelling Reservation:");
        printArray(SystemInterface.cancelReservation("1234567812345678", "ABD456"));

        // --- Re-Make reservation to test vehicle return ---
        SystemInterface.makeReservation(reservation);

        // --- Test: Process Returned Vehicle ---
        System.out.println(">>> Processing Returned Vehicle:");
        printArray(SystemInterface.processReturnedVehicle("ABD456", 5, 310));

        // --- Test: View All Transactions ---
        System.out.println(">>> Transaction History:");
        printArray(SystemInterface.getAllTransactions());
    }

    private static void printArray(String[] lines) {
        for (String line : lines) {
            System.out.println(lines != null ? line : "null");
        }
    }
}