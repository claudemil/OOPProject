import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer("emil", "banago", 2, 5);
        DeliveryTracking tracker;

        Warehouse warehouse = new Warehouse("Warehouse A", 2.3, 3.4);
        Warehouse warehouse2 = new Warehouse("Warehouse B", 5, -7);
        Parcel parcel1 = new Parcel("Dumbbell", 100, 20, warehouse);
        Parcel parcel2 = new Parcel("Book", 375, 0.5, warehouse2);
        Parcel parcel3 = new Parcel("Cellphone", 12300, 0.1, warehouse2);
        Parcel parcel4 = new Parcel("Spray Paint",75,0.2, warehouse);
        Parcel parcel5 = new Parcel("Sandbag",500,40, warehouse);

        ParcelList parcels = new ParcelList();
        parcels.addParcel(parcel1);
        parcels.addParcel(parcel2);
        parcels.addParcel(parcel3);
        parcels.addParcel(parcel4);
        parcels.addParcel(parcel5);

        while(true){
            try{
                int parcelChoice;
                boolean intInput = false;
                
                while(intInput == false){
                    System.out.print("[1] To book parcels \n[2] To check for parcel status\n[3] To leave:");
                    parcelChoice = sc.nextInt();
                    sc.nextLine();

                    if(parcelChoice == 1){
                        boolean flag = false;

                        while(!flag){
                            System.out.println(parcels);
                            System.out.print("Input the id of the desired parcel [-1] to leave: ");
                            int parcelIdChoice = sc.nextInt();
                            sc.nextLine();

                                if(parcelIdChoice == -1){
                                    flag = true;
                                } else if(parcelIdChoice > parcels.getSize() || parcelIdChoice < 1){
                                    System.out.println("Id does not exist!");
                                } else{
                                    customer.addParcel(parcels.getParcel(parcelIdChoice));
                                    tracker = new DeliveryTracking(customer.getParcel(parcelIdChoice), customer);
                                    new Thread(tracker).start();
                                    System.out.println(customer +"\n");

                                    System.out.print("Order again? [1] Yes [2] No: ");
                                    int choice = sc.nextInt();
                                    sc.nextLine();

                                    if(choice == 1){
                                        //if choice is 1 then order again else go back to the first option interface
                                    } 
                                    else{
                                       flag = true;
                                    }
                                }
                         }
                    } else if(parcelChoice == 2){
                        boolean flag = false;

                        System.out.println(customer +"\n");
                        
                        while(!flag){
                            System.out.print("Input the id of the desired parcel to inspect [-1] to leave: ");
                            int parcelIdChoice = sc.nextInt();
                            sc.nextLine();

                            if(parcelIdChoice == -1){
                                flag = true;
                            }  else if(parcelIdChoice > parcels.getSize() || parcelIdChoice < 1){
                                System.out.println("Id does not exist!");
                            } else{
                                System.out.println(customer.getParcel(parcelIdChoice).getStatus());
                            }
                        }
                    } else if(parcelChoice == 3){
                        System.out.println("Exiting...");
                        return;
                    }
                     else{
                        System.out.println("Input outside of valid choices.");
                    }
                 }
            }
                catch(InputMismatchException e){
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    




        


}
}