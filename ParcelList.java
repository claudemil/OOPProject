import java.util.HashMap;

public class ParcelList{
    private HashMap<Integer, Parcel> parcels;

    public ParcelList(){
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel){
        parcels.put(parcel.getId(), parcel);
    }

    public String toString(){
        StringBuilder parcelDetails = new StringBuilder();
        for(Parcel parcel : parcels.values()){
            parcelDetails.append(parcel.toString());
        }

        // return parcelDetails.toString().trim();}
        return parcelDetails.toString();
    }

    public Parcel getParcel(int id){
        return parcels.get(id);
    }

    public int getSize(){
        return parcels.size();
    }

}
