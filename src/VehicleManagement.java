import java.io.*;
import java.util.ArrayList;
import java.util.List;
class VehicleManagement {
    private List<Vehicle> vehicles;

    public VehicleManagement() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String id) {
        Vehicle vehicle = findVehicleById(id);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void showAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.showInfo();
            System.out.println("*************************");
        }
    }

    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }


    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : vehicles) {
                writer.println(vehicle.getId());
                writer.println(vehicle.getBrand());
                writer.println(vehicle.getPublishYear());
                writer.println(vehicle.getPrice());
                writer.println(vehicle.getColor());

                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    writer.println("Car");
                    writer.println(car.getSlots());
                    writer.println(car.getEngineType());
                } else if (vehicle instanceof Motorcycle) {
                    Motorcycle motorcycle = (Motorcycle) vehicle;
                    writer.println("Motorcycle");
                    writer.println(motorcycle.getCapacity());
                } else if (vehicle instanceof Truck) {
                    Truck truck = (Truck) vehicle;
                    writer.println("Truck");
                    writer.println(truck.getLoadWeight());
                }

                writer.println("*************************");
            }
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " +e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String id = line;
                String brand = reader.readLine();
                int publishYear = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                String color = reader.readLine();

                line = reader.readLine();
                if (line.equals("Car")) {
                    int slots = Integer.parseInt(reader.readLine());
                    String engineType = reader.readLine();
                    Car car = new Car(id, brand, publishYear, price, color, slots, engineType);
                    vehicles.add(car);
                } else if (line.equals("Motorcycle")) {
                    int capacity = Integer.parseInt(reader.readLine());
                    Motorcycle motorcycle = new Motorcycle(id, brand, publishYear, price, color, capacity);
                    vehicles.add(motorcycle);
                } else if (line.equals("Truck")) {
                    double loadWeight = Double.parseDouble(reader.readLine());
                    Truck truck = new Truck(id, brand, publishYear, price, color, loadWeight);
                    vehicles.add(truck);
                }
                reader.readLine();
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
}
