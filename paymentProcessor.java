public class paymentProcessor implements paymentProcessing{
    @Override
    public boolean processPayment(Customer customer, Parcel parcel, double payment) {
        double baseCost = 5;
        double deliveryCost = parcel.getWarehouse().getDistance(customer) * parcel.getWarehouse().getDistanceRate() + (parcel.getWeight() * parcel.getWeightRate()) + parcel.getPrice() + baseCost;
        double roundedCost = Math.ceil(deliveryCost * 100)/100;
        System.out.println("\n==============================");
        System.out.println("           RECEIPT           ");
        System.out.println("==============================");
        System.out.printf("Item Price:          $%.2f%n", parcel.getPrice());
        System.out.printf("Weight Cost:         $%.2f%n", parcel.getWeight() * parcel.getWeightRate());
        System.out.printf("Distance Cost:       $%.2f%n", parcel.getWarehouse().getDistance(customer) * parcel.getWarehouse().getDistanceRate());
        System.out.printf("Base Cost:           $%.2f%n", baseCost);
        System.out.println("------------------------------");
        System.out.printf("Total Cost:          $%.2f%n", roundedCost);
        System.out.println("==============================");
        if(payment < deliveryCost){
            double remaining = Math.ceil((roundedCost-payment) * 100)/100;
            System.out.printf("Payment Received:    $%.2f%n", payment);
            System.out.printf("Insufficient Payment! Remaining: $%.2f%n", remaining);
            System.out.println("==============================\n");
            return false;
        } else {
            double change = Math.ceil((payment-roundedCost) * 100 ) / 100;
            System.out.printf("Payment Received:    $%.2f%n", payment);
            System.out.printf("Change Returned:     $%.2f%n", change);
            System.out.println("==============================");
            System.out.println("   Thank You! Visit Again!");
            System.out.println("==============================\n");
            return true;
        }
    }

    public double calculateCost(Customer customer, Parcel parcel) {
        double baseCost = 5;
        double deliveryCost = parcel.getWarehouse().getDistance(customer) * parcel.getWarehouse().getDistanceRate()
                + (parcel.getWeight() * parcel.getWeightRate()) + parcel.getPrice() + baseCost;
        return Math.ceil(deliveryCost * 100) / 100; 
    }

}
