import java.util.InputMismatchException;
import java.util.Scanner;
//trajlkdjalkjdlkaew wtf vscode??

public class Main {

   static {
    // Warehouse source = new Warehouse( 1, 1);
    // // Parcel parcel2 = new Parcel("", 50, 2);
    // // Parcel parcel3 = new Parcel("", 50, 2);
    // // Parcel parcel4 = new Parcel("", 50, 2);

    
    // DeliveryTracking track = new DeliveryTracking(parcel1, customer);
    // Thread newThread = new Thread(track);
    // newThread.start();
    // paymentProcessor process = new paymentProcessor();
    // process.processPayment(customer, parcel1,600);

    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = new Warehouse("Warehouse A", 2.3, 3.4);
        // Parcel parcel1 = new Parcel("", 50, 2, warehouse);
        // Customer customer = new Customer("emil", "banago", 10, 10);
        // customer.addParcel(parcel1);

        while(true){
            try{
                System.out.println("Welcome to our Parcel Booking System!");
                System.out.println("Create a Customer account!");
                System.out.print("Name: ");
                String nameInput = sc.nextLine();
                System.out.print("Address: ");
                String addressInput = sc.nextLine();
                System.out.print("X coordinate: ");
                int xInput = sc.nextInt();
                System.out.print("Y coordinate: ");
                int yInput = sc.nextInt();
                sc.nextLine();
                Customer customer = new Customer(nameInput, addressInput, xInput, yInput);
                } catch(InputMismatchException e){
                    System.out.println("Invalid input!");
                    sc.nextLine();
                }
            }
        




        


}
}