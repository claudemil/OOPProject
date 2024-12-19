public class paymentProcessor implements paymentProcessing{
    @Override
    public void processPayment(Customer customer, Parcel parcel, double payment) {
        double baseCost = 5;
        double deliveryCost = parcel.getWarehouse().getDistance(customer) * parcel.getWarehouse().getDistanceRate() + (parcel.getWeight() * parcel.getWeightRate()) + parcel.getPrice() + baseCost;
        double roundedCost = Math.ceil(deliveryCost * 100)/100;
        if(payment < deliveryCost){
            double remaining = Math.ceil((roundedCost-payment) * 100)/100;
            System.out.println("Your payment is " + remaining + " off");
        } else {
            double change = Math.ceil((payment-roundedCost) * 100 ) / 100;
            System.out.println("Successfully paid!\n" + change +" As change");
        }
    }

}
