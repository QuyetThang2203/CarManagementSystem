import java.util.Scanner;

class ShowOption {
    private Scanner scanner;
    private VehicleManagement vehicleManagement;

    public ShowOption() {
        scanner = new Scanner(System.in);
        vehicleManagement = new VehicleManagement();
    }

    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMainMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    showAllVehicles();
                    break;
                case 4:
                    saveDataToFile();
                    break;
                case 5:
                    loadDataFromFile();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private void displayMainMenu() {
        System.out.println("***** Vehicle Management System *****");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Remove a vehicle");
        System.out.println("3. Show all vehicles");
        System.out.println("4. Save data to file");
        System.out.println("5. Load data from file");
        System.out.println("0. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void addVehicle() {
        scanner.nextLine();

        System.out.print("Enter vehicle type (car, motorcycle, truck): ");
        String type = scanner.nextLine();
        System.out.print("Enter vehicle ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter vehicle brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter vehicle publish year: ");
        int publishYear = scanner.nextInt();
        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter vehicle color: ");
        String color = scanner.next();

        if (type.equalsIgnoreCase("car")) {
            System.out.print("Enter number of slots: ");
            int slots = scanner.nextInt();
            System.out.print("Enter engine type: ");
            String engineType = scanner.next();
            Car car = new Car(id, brand, publishYear, price, color, slots, engineType);
            vehicleManagement.addVehicle(car);
        } else if (type.equalsIgnoreCase("motorcycle")) {
            System.out.print("Enter capacity: ");
            int capacity = scanner.nextInt();
            Motorcycle motorcycle = new Motorcycle(id, brand, publishYear, price, color, capacity);
            vehicleManagement.addVehicle(motorcycle);
        } else if (type.equalsIgnoreCase("truck")) {
            System.out.print("Enter load weight: ");
            double loadWeight = scanner.nextDouble();
            Truck truck = new Truck(id, brand, publishYear, price, color, loadWeight);
            vehicleManagement.addVehicle(truck);
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    private void removeVehicle() {
        scanner.nextLine();

        System.out.print("Enter vehicle ID to remove: ");
        String removeId = scanner.nextLine();
        vehicleManagement.removeVehicle(removeId);
    }

    private void showAllVehicles() {
        vehicleManagement.showAllVehicles();
    }

    private void saveDataToFile() {
        scanner.nextLine();

        System.out.print("Enter filename to save data: ");
        String saveFilename = scanner.nextLine();
        vehicleManagement.saveToFile(saveFilename);
    }

    private void loadDataFromFile() {
        scanner.nextLine();

        System.out.print("Enter filename to load data: ");
        String loadFilename = scanner.nextLine();
        vehicleManagement.loadFromFile(loadFilename);
    }
}