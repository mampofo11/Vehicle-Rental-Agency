import java.util.Scanner;

public class ManagerUI implements UserInterface {
    private boolean quit = false;

    public void start(Scanner input) {
        while (!quit) {
            displayMenu();
            int selection = getSelection(input);
            execute(selection, input);
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Manager Menu ---");
        System.out.println("1. View/Update Car Rates");
        System.out.println("2. View/Update SUV Rates");
        System.out.println("3. View/Update Minivan Rates");
        System.out.println("4. View All Vehicles");
        System.out.println("5. View All Reservations");
        System.out.println("6. View All Transactions");
        System.out.println("7. Quit");
    }

    private int getSelection(Scanner input) {
        int choice = -1;
        while (choice < 1 || choice > 7) {
            System.out.print("Enter your choice (1-7): ");
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
                viewOrUpdateRates(input, 1);
                break;
            case 2:
                viewOrUpdateRates(input, 2);
                break;
            case 3:
                viewOrUpdateRates(input, 3);
                break;
            case 4:
                output = SystemInterface.getAllVehicles();
                displayResults(output);
                break;
            case 5:
                output = SystemInterface.getAllReservations();
                displayResults(output);
                break;
            case 6:
                output = SystemInterface.getAllTransactions();
                displayResults(output);
                break;
            case 7:
                quit = true;
                System.out.println("Exiting Manager Interface...");
                break;
        }
    }

    private void viewOrUpdateRates(Scanner input, int type) {
        String[] currentRates;
        if (type == 1) currentRates = SystemInterface.getCarRates();
        else if (type == 2) currentRates = SystemInterface.getSUVRates();
        else currentRates = SystemInterface.getMinivanRates();

        System.out.println("\nCurrent Rates:");
        displayResults(currentRates);

        System.out.print("Would you like to update rates? (yes/no): ");
        String update = input.nextLine().trim().toLowerCase();

        if (update.equals("yes")) {
            System.out.print("Enter daily rate: ");
            double daily = input.nextDouble();
            System.out.print("Enter weekly rate: ");
            double weekly = input.nextDouble();
            System.out.print("Enter monthly rate: ");
            double monthly = input.nextDouble();
            System.out.print("Enter mileage charge: ");
            double mileage = input.nextDouble();
            System.out.print("Enter daily insurance rate: ");
            double insurance = input.nextDouble();
            input.nextLine(); // consume newline

            VehicleRates newRates = new VehicleRates(daily, weekly, monthly, mileage, insurance);

            if (type == 1)
                SystemInterface.updateCarRates(newRates);
            else if (type == 2)
                SystemInterface.updateSUVRates(newRates);
            else
                SystemInterface.updateMinivanRates(newRates);

            System.out.println("Rates updated successfully.");
        }
    }

    private void displayResults(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}