class Car extends Vehicle {
    private int slots;
    private String engineType;

    public Car(String id, String brand, int publishYear, double price, String color, int slots, String engineType) {
        super(id, brand, publishYear, price, color);
        this.slots = slots;
        this.engineType = engineType;
    }

    public int getSlots() {
        return slots;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Slots: " + slots);
        System.out.println("Engine Type: " + engineType);
    }
}
