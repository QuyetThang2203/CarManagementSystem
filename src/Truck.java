class Truck extends Vehicle {
    private double loadWeight;

    public Truck(String id, String brand, int publishYear, double price, String color, double loadWeight) {
        super(id, brand, publishYear, price, color);
        this.loadWeight = loadWeight;
    }

    public double getLoadWeight() {
        return loadWeight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Load Weight: " + loadWeight);
    }
}