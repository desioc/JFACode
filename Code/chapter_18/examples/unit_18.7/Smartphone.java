public class Smartphone {
    private String model;
    private String brand;
    private int price;

    public Smartphone (String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    public Smartphone (String brand, String model, int price) {
        this(brand, model);
        this.price = price;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public String toString() {
        return brand +" "+ model;
    }
}