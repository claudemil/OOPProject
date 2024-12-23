public class Warehouse {
    private String name;
    private double distanceRate = 50; //placeholder value
    // private Coordinates coordinates;
    // private Warehouse northNeighbor = null;
    // private Warehouse southNeighbor = null;

    // public Warehouse(String name, double x, double y){
    //     this.name = name;
    //     this.coordinates = new Coordinates(x, y);
    // }

    public Warehouse(String name){
        this.name = name;
    }

    // public double getDistance(Customer customer){
    //     return this.coordinates.distanceTo(customer.getCoordinates());
    // }

    public double getDistanceRate() {
        return distanceRate;
    }

    // public Coordinates getCoordinates() {
    //     return coordinates;
    // }

    // public void setNeighbors(Warehouse northNeighbor, Warehouse southNeighbor) {
    //     if (northNeighbor.coordinates == coordinates || southNeighbor.coordinates == coordinates) {
    //         throw new IllegalArgumentException("Neighbors must not be in the same location");
    //     }
        
    //     if (northNeighbor.coordinates.y() > coordinates.y()) {
    //         this.northNeighbor = northNeighbor;
    //     } else if (southNeighbor.coordinates.y() < coordinates.y()) {
    //         this.southNeighbor = southNeighbor;
    //     }
    // }

    // public Warehouse getNeighbor(boolean isNorth) {
    //     if (isNorth){
    //         return northNeighbor;
    //     } else {
    //         return southNeighbor;
    //     }
    // }

    public String getWarehouseName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getWarehouseName();
    }
}
