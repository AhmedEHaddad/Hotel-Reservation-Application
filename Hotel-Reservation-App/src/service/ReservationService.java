package service;

import model.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ReservationService {
    private static final Collection<IRoom> rooms = new HashSet<>();
    private static final Collection<Reservation> reservations = new HashSet<>();

    public static void addRoom(String roomNumber, double price, RoomType roomType) {
        Room room = new Room(roomNumber, price, roomType);
        rooms.add(room);
    }

    public static IRoom getARoom(String roomNumber) {
        for (IRoom room : rooms) {
            if (roomNumber.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        boolean found = false;
        Collection<IRoom> availableRooms = new HashSet<>();
        for(IRoom room : rooms){
            for(Reservation reservation: reservations){
                if((room.getRoomNumber() == reservation.getRoom().getRoomNumber()
                        && ((!checkInDate.after(reservation.getCheckInDate()) &&
                        !checkInDate.before(reservation.getCheckOutDate())) ||
                        (!checkOutDate.after(reservation.getCheckInDate()) &&
                                !checkInDate.before(reservation.getCheckOutDate())))) ||
                        (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
                    availableRooms.add(room);
                }
            }



        }
        System.out.println(availableRooms);
        return availableRooms;
    }



    public static Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customersReservations = new HashSet<>();
        for(Reservation reservation : reservations){
            if(reservation.getCustomer().equals(customer)){
                customersReservations.add(reservation);
            }
        }
        return customersReservations;
    }

    public static void printAllReservations(){
        System.out.println(reservations);
    }

    public static Collection<IRoom> getAllRooms() {
        return rooms;
    }
    public static Collection<Reservation> getAllReservations() {
        //if (reservations != null) {
            return reservations;
       // } else {
        //    System.out.println("there are  no reservations currently!");
       // }
    }

}
