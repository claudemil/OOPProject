public class Parcel {
    private static int parcelCount = 1;
    private int id;
    private String name;
    private double price;
    private double weight;
    private double baseRate;
    private double weightRate = 20;
    private String status;
    private Warehouse warehouse;

    public Parcel(String name, double price, double weight, Warehouse warehouse) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.warehouse = warehouse;
        id = parcelCount++;
    }

    public double getPrice(){
        return price;
    }

    public double getWeight(){
        return weight;
    }

    public double getBaseRate(){
        return baseRate;
    }

    public double getWeightRate(){
        return weightRate;
    }

    public Warehouse getWarehouse(){
        return warehouse;
    }

    public int getId(){
        return id;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
