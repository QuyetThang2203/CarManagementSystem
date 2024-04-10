class Motorcycle extends Vehicle {
    private int capacity;

    public Motorcycle(String id, String brand, int publishYear, double price, String color, int capacity) {
        super(id, brand, publishYear, price, color);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Capacity: " + capacity);
    }
}
