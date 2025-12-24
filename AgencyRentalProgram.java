import java.util.Scanner;

public class AgencyRentalProgram {
    public static void main(String[] args) {
        // Set initial rates
        VehicleRates carRates = new VehicleRates(24.95, 169.95, 514.95, 0.16, 14.95);
        VehicleRates suvRates = new VehicleRates(29.95, 189.95, 679.95, 0.16, 14.95);
        VehicleRates vanRates = new VehicleRates(36.95, 224.95, 687.95, 0.21, 19.95);

        CurrentRates agencyRates = new CurrentRates(carRates, suvRates, vanRates);
        Vehicles agencyVehicles = new Vehicles();

        // Add vehicle data (use required VINs)
        agencyVehicles.add(new Car("Toyota Corolla", 32, 5, "CAR001"));
        agencyVehicles.add(new Car("Honda Civic", 31, 5, "CAR002"));
        agencyVehicles.add(new Car("Hyundai Elantra", 33, 5, "CAR003"));
        agencyVehicles.add(new SUV("Toyota RAV4", 30, 5, 6, "SUV004"));
        agencyVehicles.add(new SUV("Honda CR-V", 29, 5, 6, "SUV005"));
        agencyVehicles.add(new SUV("Ford Explorer", 24, 7, 8, "SUV006"));
        agencyVehicles.add(new SUV("Jeep Grand Cherokee", 23, 5, 7, "SUV007"));
        agencyVehicles.add(new Minivan("Toyota Sienna", 36, 9, "VAN008"));
        agencyVehicles.add(new Minivan("Honda Odyssey", 22, 7, "VAN009"));
        Transactions transactions = new Transactions();

        Scanner input = new Scanner(System.in);
        UserInterface ui;
        boolean quit = false;

        while (!quit) {
            ui = getUI(input);
            if (ui == null) {
                quit = true;
            } else {
                if (!SystemInterface.initialized()) {
                    SystemInterface.initSystem(agencyRates, agencyVehicles, transactions);
                }
                ui.start(input);
            }
        }

        System.out.println("System exited.");
    }

    public static UserInterface getUI(Scanner input) {
        while (true) {
            System.out.print("1 – Employee, 2 – Manager, 3 – Quit: ");
            int selection = input.nextInt();
            input.nextLine(); // consume newline

            switch (selection) {
                case 1:
                    return new EmployeeUI();
                case 2:
                    return new ManagerUI();
                case 3:
                    return null;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
