class Vehicle implements CarInterface {
    private String id;
    private String brand;
    private int publishYear;
    private double price;
    private String color;

    public Vehicle(String id, String brand, int publishYear, double price, String color) {
        this.id = id;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Publish Year: " + publishYear);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
    }
}
