import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer(null, null, 0, 0);
        DeliveryTracking tracker;
        String customerName;
        String customerAddress;
        double customerX;
        double customerY;

        Warehouse warehouse = new Warehouse("Warehouse A", 2.3, 3.4);
        Warehouse warehouse2 = new Warehouse("Warehouse B", 5, -7);
        Parcel parcel1 = new Parcel("Dumbbell", 100, 20, warehouse);
        Parcel parcel2 = new Parcel("Book", 375, 0.5, warehouse2);
        Parcel parcel3 = new Parcel("Cellphone", 12300, 0.1, warehouse2);
        Parcel parcel4 = new Parcel("Spray Paint",75,0.2, warehouse);
        Parcel parcel5 = new Parcel("Sandbag",500,40, warehouse);
        Parcel parcel6 = new Parcel("Computer", 5700, 3, warehouse);
        Parcel parcel7 = new Parcel("Plate", 200, 0.5, warehouse2);
        Parcel parcel8 = new Parcel("Plastic Bottle", 75, 0.1, warehouse2);
        Parcel parcel9 = new Parcel("Electric Lamp",1200,0.7, warehouse);
        Parcel parcel10 = new Parcel("Aircon",11400,10, warehouse);
        
        paymentProcessor checkPayment = new paymentProcessor();

        ParcelList parcels = new ParcelList();
        parcels.addParcel(parcel1);
        parcels.addParcel(parcel2);
        parcels.addParcel(parcel3);
        parcels.addParcel(parcel4);
        parcels.addParcel(parcel5);
        parcels.addParcel(parcel5);
        parcels.addParcel(parcel6);
        parcels.addParcel(parcel7);
        parcels.addParcel(parcel8);
        parcels.addParcel(parcel9);
        parcels.addParcel(parcel10);

        boolean creation = false;
        while(!creation){
            try{
                System.out.println("Welcome to 'This Parcel Booking & Delivery System'!");
                System.out.println("To access our features, first you must create an account!");

                while(true){
                    System.out.print("Customer name: ");
                    customerName = sc.nextLine();

                    if(customerName.matches("[a-zA-z ]+")){
                        break;
                    } else{
                        System.out.println("Invalid name. Avoid using special characters!");
                    }
                }

                while(true){
                    System.out.print("Address: ");
                    customerAddress = sc.nextLine();

                    if(customerAddress.matches("[a-zA-Z ]+")){
                        break;
                    } else{
                        System.out.println("Invalid address. Avoid using special characters!");
                    }
                }

                while(true){
                    try{
                        System.out.print("X coordinate: ");
                        customerX = sc.nextInt();
                        sc.nextLine();
                        break;
                    }catch(InputMismatchException e){
                        System.out.println("Input numbers only!");
                        sc.nextLine();
                    }
                }

                while(true){
                    try{
                        System.out.print("Y coordinate: ");
                        customerY = sc.nextInt();
                        sc.nextLine();
                        break;
                    }catch(InputMismatchException e){
                        System.out.println("Input valid numbers!");
                        sc.nextLine();
                    }
                }

                customer = new Customer(customerName, customerAddress, customerX, customerY);
                System.out.printf("Account successfully created!\nWelcome, %s!\n\n", customerName);
                System.out.println("=== Customer Details ===");
                System.out.printf("Name       : %s\n", customerName);
                System.out.printf("Address    : %s\n", customerAddress);
                System.out.printf("X Coord.   : %.2f\n", customerX);
                System.out.printf("Y Coord.   : %.2f\n", customerY);
                System.out.println("========================\n");
                creation = true;
            } catch(InputMismatchException e){
                System.out.println("Invalid input!");
            }
        }


        while(true){
            try{
                int parcelChoice;
                boolean intInput = false;
                
                while(!intInput){
                    System.out.print("[1] To book parcels \n[2] To check for parcel status\n[3] To leave: ");
                    parcelChoice = sc.nextInt();
                    sc.nextLine();

                    if(parcelChoice == 1){
                        boolean flag = false;

                        while(!flag){
                            System.out.println(parcels.toString());
                            System.out.print("Input the id of the desired parcel [-1] to leave: ");
                            int parcelIdChoice = sc.nextInt();
                            sc.nextLine();

                                if(parcelIdChoice == -1){
                                    flag = true;
                                } else if(parcelIdChoice > parcels.getSize() || parcelIdChoice < 1){
                                    System.out.println("Id does not exist!");
                                } else{
                                    boolean paid = false;
                                    int choice = 0;

                                    while(!paid){
                                        System.out.println("The price of this parcel is " + checkPayment.calculateCost(customer, parcels.getParcel(parcelIdChoice)));
                                        System.out.print("Payment here [0] to exit: ");
                                        double customerPayment = sc.nextDouble();
                                        sc.nextLine();
                                        if(customerPayment == 0){
                                            System.out.println("Payment interface exiting...");
                                            break;
                                        }
                                        paid = checkPayment.processPayment(customer, parcels.getParcel(parcelIdChoice), customerPayment);
                                        customer.addParcel(parcels.getParcel(parcelIdChoice));
                                        
                                    
                                    }
                                    if(paid){
                                        tracker = new DeliveryTracking(customer.getParcel(parcelIdChoice), customer);
                                        new Thread(tracker).start();
                                        customer.printParcels();
                                    }

                                    System.out.print("Order again? [1] Yes [2] No: ");
                                    choice = sc.nextInt();
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

                        customer.printParcels();
                            
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
            //     } catch(NullPointerException e){
            //     System.out.println("Invalid input! null");
            // }
        }
    }
}
}
