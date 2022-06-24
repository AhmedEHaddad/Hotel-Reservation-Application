package UI;

import model.*;
import resourcesAPI.*;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AdminMenu {

    private static final String[] options = {"1. See all Customers.",
            "2. See all Rooms.",
            "3. See all Reservations.",
            "4. Add a Room.",
            "5. Back to Main Menu",
    };
    public static void adminMenu(){
        Scanner scanner = new Scanner(System.in);
        int option = 1;

        do{

            printMenu(options);
            //option = scanner.nextInt();
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.println("You Selected see all customers...");
                        option1();
                        break;
                    case 2:
                        System.out.println("You Selected see all rooms...");
                        option2();
                        break;
                    case 3:
                        System.out.println("You Selected see all reservations..");
                        option3();
                        break;
                    case 4:
                        System.out.println("You Selected add a room...");
                        option4();
                        break;
                    case 5:
                        System.out.println("returning to main menu!...");
                        MainMenu.mainMenu();

                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }


        } while ( option != 5);

    }
    //helper functions
    public static void printMenu(String[] options){
        System.out.println("---------------------------");
        for (String option : options){
            System.out.println(option);
        }
        System.out.println("Choose your option : ");
        System.out.println("---------------------------");
    }
    //adminMenu

    // Options
    private static void option1() {
        System.out.println("Thanks for choosing option 1");
        Collection<Customer> allCustomers =AdminResource.getAllCustomer();
        for (Customer customer: allCustomers){
            System.out.println(customer.toString());
        }

    }
    private static void option2() {
        System.out.println("Thanks for choosing option 2");
        Collection<IRoom> allRooms =AdminResource.getAllRooms();
        for (IRoom room: allRooms){
            System.out.println(room.toString());
        }
    }
    private static void option3() {
        System.out.println("Thanks for choosing option 3");
        Collection<Reservation> allReservations =AdminResource.getAllReservations();
        for (Reservation reservation: allReservations){
            System.out.println(reservation.toString());
        }
    }
    private static void option4() {
        System.out.println("Thanks for choosing option 4");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Number of the Room you wish to Add:");
        String roomID = scanner.next();
        System.out.println("Enter the Room Type single/double of the Room");
        /*RoomType roomType;
        try {
            String roomTypeInput = scanner.next();
            if (roomTypeInput.equals("single")){
                roomType = RoomType.SINGLE;
            } else if (roomTypeInput.equals("double")) {
                roomType = RoomType.DOUBLE;
            }else {
                System.out.println("Please Enter pne of the defined values single/double:");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        RoomType roomType = RoomType.valueOf(scanner.next());
        System.out.println("Enter the Room Price per Night");
        double roomPrice = scanner.nextDouble();

        AdminResource.createRooms(roomID, roomPrice, roomType);
    }

}
