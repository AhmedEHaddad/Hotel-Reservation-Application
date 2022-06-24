package resourcesAPI;

import model.*;
import service.*;

import java.util.Collection;

public class AdminResource {
    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void createRooms(String roomNumber, double price, RoomType roomType) {
        ReservationService.addRoom(roomNumber, price, roomType);
        System.out.println("Your Room has been Created!");
    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomer() {
        return CustomerService.getAllCustomers();
    }
    public static Collection<Reservation> getAllReservations() {
        return ReservationService.getAllReservations();
    }

}
