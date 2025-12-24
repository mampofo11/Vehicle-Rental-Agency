import java.util.Scanner;

public class EmployeeUI implements UserInterface {
    private boolean quit = false;

    public void start(Scanner input) {
        while (!quit) {
            displayMenu();
            int selection = getSelection(input);
            execute(selection, input);
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Employee Menu ---");
        System.out.println("1. View Current Rates");
        System.out.println("2. View Available Vehicles");
        System.out.println("3. Estimate Rental Cost");
        System.out.println("4. Make Reservation");
        System.out.println("5. Display a Reservation");
        System.out.println("6. Cancel Reservation");
        System.out.println("7. Process Returned Vehicle");
        System.out.println("8. Quit");
    }

    private int getSelection(Scanner input) {
        int choice = -1;
        while (choice < 1 || choice > 8) {
            System.out.print("Enter your choice (1-8): ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
            }
            input.nextLine(); // consume newline
        }
        return choice;
    }

    private void execute(int selection, Scanner input) {
        String[] output;
        switch (selection) {
            case 1:
                int type = getVehicleType(input);
                if (type == 1) output = SystemInterface.getCarRates();
                else if (type == 2) output = SystemInterface.getSUVRates();
                else output = SystemInterface.getMinivanRates();
                displayResults(output);
                break;

            case 2:
                type = getVehicleType(input);
                if (type == 1) output = SystemInterface.getAvailCars();
                else if (type == 2) output = SystemInterface.getAvailSUVs();
                else output = SystemInterface.getAvailMinivans();
                displayResults(output);
                break;

            case 3:
                RentalDetails details = getRentalDetails(input);
                output = SystemInterface.calcRentalCost(details);
                displayResults(output);
                break;

            case 4:
                ReservationDetails res = getReservationDetails(input);
                output = SystemInterface.makeReservation(res);
                displayResults(output);
                break;

            case 5:
                String vin = getVIN(input);
                output = SystemInterface.getReservation(vin);
                displayResults(output);
                break;

            case 6:
                System.out.print("Enter credit card number: ");
                String cc = input.nextLine();
                vin = getVIN(input);
                output = SystemInterface.cancelReservation(cc, vin);
                displayResults(output);
                break;

            case 7:
                System.out.print("Enter credit card number: ");
                cc = input.nextLine();
                vin = getVIN(input);
                System.out.print("Number of days used: ");
                int days = input.nextInt();
                System.out.print("Number of miles driven: ");
                int miles = input.nextInt();
                input.nextLine(); // consume newline
                output = SystemInterface.processReturnedVehicle(vin, days, miles);
                displayResults(output);
                break;

            case 8:
                quit = true;
                System.out.println("Exiting Employee Interface...");
                break;
        }
    }

    private int getVehicleType(Scanner input) {
        int type = -1;
        while (type < 1 || type > 3) {
            System.out.print("Enter vehicle type (1-Car, 2-SUV, 3-Minivan): ");
            if (input.hasNextInt()) {
                type = input.nextInt();
            }
            input.nextLine();
        }
        return type;
    }

    private String getVIN(Scanner input) {
        System.out.print("Enter vehicle VIN: ");
        return input.nextLine();
    }

    private RentalDetails getRentalDetails(Scanner input) {
        int type = getVehicleType(input);
        System.out.print("Enter rental unit (d=days, w=weeks, m=months): ");
        char unit = input.nextLine().toLowerCase().charAt(0);
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.print("Enter estimated miles: ");
        int miles = input.nextInt();
        System.out.print("Add insurance? (true/false): ");
        boolean insurance = input.nextBoolean();
        input.nextLine(); // consume newline

        String vehicleType = (type == 1) ? "car" : (type == 2) ? "suv" : "minivan";
        return new RentalDetails(vehicleType, new TimePeriod(unit, quantity), miles, insurance);
    }

    private ReservationDetails getReservationDetails(Scanner input) {
        String vin = getVIN(input);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter credit card number: ");
        String cc = input.nextLine();
        System.out.print("Enter rental unit (d=days, w=weeks, m=months): ");
        char unit = input.nextLine().toLowerCase().charAt(0);
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.print("Add insurance? (true/false): ");
        boolean insurance = input.nextBoolean();
        input.nextLine(); // consume newline

        return new ReservationDetails(name, cc, new TimePeriod(unit, quantity), insurance, vin);
    }

    private void displayResults(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}