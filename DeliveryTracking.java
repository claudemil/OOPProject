public class DeliveryTracking implements Runnable {
    private Parcel parcel;
    private double location;
    private String destination;
    private Coordinates source;

    public DeliveryTracking(Parcel parcel, Customer customer) {
        this.parcel = parcel;
        this.source = parcel.getWarehouse().getCoordinates();
        this.destination = customer.getAddress();
    }

    // new edits
    // HERE


    //what the fuck

    @Override
    public void run() {
        double i = 0;
        double maxValue = 200; //Customer coordinates
        /*
         * if y is positive and parcel origin is positive then delivery time is halved
         * otherwise delivery time stays as it is
         */
        while (i <= maxValue) {
            if(i == maxValue * 0.25) {
                parcel.setStatus(String.format("Parcel %s is out of Warehouse", parcel.getName()));
            } else if (i == maxValue * 0.50) {
                parcel.setStatus(String.format("Parcel %s is in your local warehouse", parcel.getName()));
            } else if (i == maxValue * 0.75) {
                parcel.setStatus(String.format("Parcel is in transit to you", parcel.getName()));
            } else if (i == maxValue) {
                parcel.setStatus(String.format("Parcel successfully delivered!", parcel.getName()));
            }

            i += maxValue / 4;

            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
