package UI;

import model.Reservation;
import resourcesAPI.HotelResource;


import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;

public class MainMenu {
    /*public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }*/

    //public static void main(String[] args) {
    public static void mainMenu() {
        String[] options = {"1-- find and reserve a room.",
                "2-- see my reservations.",
                "3-- create an account.",
                "4-- Admin menu.",
                "5-- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;

        do{
            System.out.println("Hello! Welcome To Hotel reservation System!");
            printMenu(options);
            //option = scanner.nextInt();
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.println("You Selected to make a new Reservation");
                        option1();
                        break;
                    case 2:
                        System.out.println("You Selected see my reservations");
                        option2();
                        break;
                    case 3:
                        System.out.println("You Selected create a new account");
                        option3();
                        break;
                    case 4:
                        System.out.println("You Selected to view admin Menu");
                        option4();
                        break;
                    case 5:
                        System.out.println("system will Exit now!...");
                        exit(0);

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
        //make a reservation
        System.out.println("Thanks for choosing option 1");
        System.out.println("please enter your email");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        //check if an account exists
        if (HotelResource.getCustomer(email) == null){
            System.out.print("No account exists for this email!\n"  + "please register first\n");
            return;
        }
        System.out.println("please enter your checkIn date");
        //Date checkIn = scanner.next();
        System.out.println("please enter your check Out date");
        System.out.println("please enter the room number you would like to make a reservation for");
        String roomNo = scanner.next();
        //HotelResource.bookARoom(email, HotelResource.getRoom(roomNo),);


    }
    private static void option2() {
        //see my reservations
        System.out.println("Thanks for choosing option 2");
        System.out.println("please enter your email");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        for (Reservation r :HotelResource.getCustomersReservation(email)) {
            System.out.println(r.toString());
        }
    }
    private static void option3() {
        //create a new account
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Creating an account..");
        System.out.println("please enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("please enter your last name:");
        String lastName = scanner.next();
        System.out.println("please enter your email ");
        String email = scanner.next();
        HotelResource.createACustomer(email, firstName,lastName);


    }
    private static void option4() {
        //admin view
        System.out.println("Thanks for choosing option 4");
        AdminMenu.adminMenu();
    }

}
