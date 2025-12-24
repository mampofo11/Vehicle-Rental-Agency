public class RatesTestDriver {
    public static void main(String[] args) {
        VehicleRates carRates = new VehicleRates(24.95, 169.95, 514.95, 0.16, 14.95);
        VehicleRates suvRates = new VehicleRates(29.95, 189.95, 679.95, 0.16, 14.95);
        VehicleRates vanRates = new VehicleRates(36.95, 224.95, 687.95, 0.21, 19.95);

        CurrentRates current = new CurrentRates(carRates, suvRates, vanRates);

        System.out.println("--- CURRENT RATES ---");
        System.out.println("Car: " + current.getCarRates());
        System.out.println("SUV: " + current.getSUVRates());
        System.out.println("Minivan: " + current.getMinivanRates());

        // Update rates and show again
        current.setCarRates(new VehicleRates(25.00, 170.00, 520.00, 0.17, 15.00));
        System.out.println("\n--- UPDATED CAR RATES ---");
        System.out.println("Car: " + current.getCarRates());
    }
}
