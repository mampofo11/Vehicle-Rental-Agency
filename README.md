# Vehicle Rental Agency (Java)

A console-based vehicle rental management system built in Java that simulates the core operations of a real-world rental agency. The application supports employee and manager workflows, vehicle reservations, rental cost estimation, and transaction tracking using object-oriented design principles.

---

## Features

### Employee Functionality
- View current rental rates for cars, SUVs, and minivans
- View available vehicles by type
- Estimate rental cost based on rental period, mileage, and optional insurance
- Make vehicle reservations using VIN and credit card information
- Display or cancel existing reservations
- Process returned vehicles and generate final charges

### Manager Functionality
- View and update rental rates
- View all vehicles, including reservation status
- View all active reservations
- View complete transaction history

---

## Technical Highlights

- Object-oriented design using inheritance, interfaces, and encapsulation
- Separation of concerns between UI, business logic, and data models
- Static system interface layer coordinating application logic
- Custom linked list implementation for vehicle storage
- Dynamic pricing with daily, weekly, and monthly rental options
- Mileage-based charges and optional daily insurance
- Quoted rates are preserved to ensure accurate billing even if prices change
- Dedicated test drivers for incremental testing and validation

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Custom Linked List
- Console-based User Interface
- Git and GitHub

---

## Project Structure

- AgencyRentalProgram.java
- EmployeeUI.java
- ManagerUI.java
- UserInterface.java
- SystemInterface.java
- Vehicle.java
- Car.java
- SUV.java
- Minivan.java
- VehicleNode.java
- Vehicles.java
- VehicleRates.java
- CurrentRates.java
- RentalDetails.java
- ReservationDetails.java
- TimePeriod.java
- Transaction.java
- Transactions.java
- VehicleTestDriver.java
- RatesTestDriver.java
- TransactionTestDriver.java
- SystemTestDriver.java
- .gitignore

---

## How to Run

### Compile
javac *.java

### Run
java AgencyRentalProgram

---

## Example Workflow

1. Launch the program
2. Select Employee or Manager interface
3. Navigate menus using numeric input
4. View available vehicles or rental rates
5. Estimate rental costs
6. Make or cancel reservations
7. Process returned vehicles and view transaction history

---

## Testing

The project includes multiple test drivers to verify system functionality:
- VehicleTestDriver for vehicle storage and retrieval
- RatesTestDriver for pricing calculations
- TransactionTestDriver for transaction tracking
- SystemTestDriver for full system integration testing

---

## Author

Marvin Ampofo  
Computer Science Major – Towson University
