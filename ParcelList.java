import java.util.HashMap;


public class ParcelList{
    private HashMap<Integer, Parcel> parcels;

    public ParcelList(){
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel){
        parcels.put(parcel.getId(), parcel);
    }

    // public String toString(){
    //     StringBuilder parcelDetails = new StringBuilder();
    //     for(Parcel parcel : parcels.values()){
    //         parcelDetails.append(parcel.toString());
    //     }

    //     // return parcelDetails.toString().trim();}
    //     return parcelDetails.toString();
    // }

    public Parcel getParcel(int id){
        return parcels.get(id);
    }

    public int getSize(){
        return parcels.size();
    }

    @Override
    public String toString() {
        // Build the header
        StringBuilder parcelDetails = new StringBuilder();
        parcelDetails.append("================================================================================================================\n");
        parcelDetails.append("ID   | Name            | Weight    | Price     | Status                                   | Warehouse\n");
        parcelDetails.append("================================================================================================================\n");

        // Build rows for each parcel
        for (Parcel parcel : parcels.values()) {
            String warehouseName;
            if (parcel.getWarehouse() != null) {
                warehouseName = parcel.getWarehouseName();
            } else {
                warehouseName = "None";
            }

            parcelDetails.append(String.format(
                "%-4d | %-15s | %6.2f kg | $%-8.2f | %-40s | %-10s%n",
                parcel.getId(),
                parcel.getName(),
                parcel.getWeight(),
                parcel.getPrice(),
                parcel.getStatus(),
                warehouseName
            ));
        }

        // Add the footer
        parcelDetails.append("================================================================================================================\n");

        return parcelDetails.toString();
    }

}
