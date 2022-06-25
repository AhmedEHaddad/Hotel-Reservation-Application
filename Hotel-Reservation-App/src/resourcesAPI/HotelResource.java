package resourcesAPI;

import model.*;
import service.*;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email, firstName, lastName);
        System.out.println("Your account has been Created!");
    }
    public static IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);
    }
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = CustomerService.getCustomer(customerEmail);
        return ReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }
    public static Collection<Reservation> getCustomersReservation(String customerEmail){
        /*
        Collection<Reservation> reservations = ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail))
        if(reservations == null){
            System.out.println("Customer has no reservations at the moment");
        }
        */
        return ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));
    }
    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }
}
