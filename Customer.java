import java.util.HashMap;

public class Customer {
    private String name;
    private String address;
    private Coordinates coordinates;
    private HashMap<Integer, Parcel> parcelPair;

    public Customer(String name, String address, double x, double y) {
        this.name = name;
        this.address = address;
        this.coordinates = new Coordinates(x, y);
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

    @Override
    public String toString(){
        StringBuilder parcelDetails = new StringBuilder();
        for(Parcel parcel : parcelPair.values()){
            parcelDetails.append(parcel.toString()).append("\n");
        }

        // return parcelDetails.toString().trim();}
        return String.format(
            "Customer{name='%s', address='%s', coordinates=%s, parcels=\n%s}",
            name, address, coordinates, parcelDetails.toString());
    }
}
