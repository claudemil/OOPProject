import java.util.HashMap;

public class Customer {
    private String name;
    private String address;
    private Coordinates coordinates;
    private HashMap<Integer, Parcel> parcelPair;

    // public Customer(String name, String address, double x, double y) {
    //     this.name = name;
    //     this.address = address;
    //     this.coordinates = new Coordinates(x, y);
    //     this.parcelPair = new HashMap<>();
    // }

    public Customer(String name, String address){
        this.name = name;
        this.address = address;
        this.parcelPair = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelPair.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(int id) {
        return parcelPair.get(id);
    }

    public void checkParcelLocation(int id){
        System.out.println(parcelPair.get(id).getStatus());
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void printParcels() {
        System.out.println("================================================================================================================");
        System.out.println("Customer: " + this.name);
        System.out.println("================================================================================================================");

        if (parcelPair.size() == 0) {
            System.out.println("No parcels booked.");
        } else {
            // Print table header
            System.out.println("ID   | Name            | Weight    | Price     | Status                                   | Origin");
            System.out.println("================================================================================================================");

            // Iterate over parcels and print their details
            for (Parcel parcel : parcelPair.values()) { // Assuming ParcelList has a `getParcels` method
                String warehouseName;
                if (parcel.getWarehouse() != null) {
                    warehouseName = parcel.getWarehouseName();
                } else {
                    warehouseName = "None";
                }

                System.out.println(String.format(
                    "%-4d | %-15s | %6.2f kg | $%-8.2f | %-40s | %-10s",
                    parcel.getId(),
                    parcel.getName(),
                    parcel.getWeight(),
                    parcel.getPrice(),
                    parcel.getStatus(),
                    warehouseName
                ));
            }

            System.out.println("================================================================================================================");
        }
}
}
