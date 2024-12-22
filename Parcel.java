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
        this.status = "In " + warehouse.getWarehouseName();
        this.id = parcelCount++;
    }

    public double getPrice(){
        return this.price;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getBaseRate(){
        return this.baseRate;
    }

    public double getWeightRate(){
        return this.weightRate;
    }

    public Warehouse getWarehouse(){
        return this.warehouse;
    }

    public String getWarehouseName(){
        return this.warehouse.getWarehouseName();
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
 
    }

    public String toString() {
        return String.format(
            "ID: %-4d | Name: %-15s | Weight: %6.2f kg | Price: $%-8.2f | Status: %-40s | Warehouse: %-10s",
            id, name, weight, price, status, (warehouse != null ? warehouse.toString() : "None")
        );
    }
}
