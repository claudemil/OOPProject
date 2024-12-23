public class Parcel {
    private static int parcelCount = 1;
    private int id;
    private String name;
    private double price;
    private double weight;
    private double baseRate;
    private double weightRate = 20;
    private String status;
    private Warehouse origin;

    public Parcel(String name, double price, double weight, Warehouse origin) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.origin = origin;
        this.status = "In " + origin.getWarehouseName();
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
        return this.origin;
    }

    public String getWarehouseName(){
        return this.origin.getWarehouseName();
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
            "ID: %-4d | Name: %-15s | Weight: %6.2f kg | Price: $%-8.2f | Status: %-40s | Origin: %-10s",
            id, name, weight, price, status, (origin != null ? origin.toString() : "None")
        );
    }
}
