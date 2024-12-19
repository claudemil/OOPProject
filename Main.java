import java.util.Scanner;


public class Main {

   static {
    Warehouse source = new Warehouse( 1, 1);
    // Parcel parcel2 = new Parcel("", 50, 2);
    // Parcel parcel3 = new Parcel("", 50, 2);
    // Parcel parcel4 = new Parcel("", 50, 2);

    Warehouse warehouse = new Warehouse( 2.3, 3.4);
    Parcel parcel1 = new Parcel("", 50, 2, warehouse);

    Customer customer = new Customer("emil", "banago", 10, 10);
    customer.addParcel(parcel1);
    DeliveryTracking track = new DeliveryTracking(parcel1, customer);
    Thread newThread = new Thread(track);
    newThread.start();
    paymentProcessor process = new paymentProcessor();
    process.processPayment(customer, parcel1,600);

    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



}
}