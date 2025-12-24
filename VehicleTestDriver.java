public class VehicleTestDriver {
    public static void main(String[] args) {
        Vehicles vehicleList = new Vehicles();

        vehicleList.add(new Car("Toyota Prius", 57, 4, "ABD456"));
        vehicleList.add(new SUV("Honda Pilot Hybrid", 36, 7, 6, "KBS698"));
        vehicleList.add(new Minivan("Chrysler Pacifica Hybrid", 36, 9, "BFJ386"));

        System.out.println("--- VEHICLE LIST ---");
        vehicleList.reset();
        while (vehicleList.hasNext()) {
            System.out.println(vehicleList.getNext());
        }

        try {
            Vehicle found = vehicleList.getVehicle("KBS698");
            System.out.println("\nFound vehicle: " + found);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
