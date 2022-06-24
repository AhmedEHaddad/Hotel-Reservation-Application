package service;

import model.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ReservationService {
    private Collection<IRoom> rooms = new HashSet<>();
    private Collection<Reservation> reservations = new HashSet<>();

    public void addRoom(String roomNumber, double price, RoomType roomType) {
        Room room = new Room(roomNumber, price, roomType);
        rooms.add(room);
    }

    public IRoom getARoom(String roomNumber) {
        for (IRoom room : rooms) {
            if (roomNumber.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        boolean found = false;
        Collection<IRoom> findAvailableRooms = new HashSet<>();
        for(IRoom room : rooms){
            for(Reservation reservation: reservations){
                if((room.getRoomNumber() == reservation.getRoom().getRoomNumber()
                        && ((!checkInDate.after(reservation.getCheckInDate()) &&
                        !checkInDate.before(reservation.getCheckOutDate())) ||
                        (!checkOutDate.after(reservation.getCheckInDate()) &&
                                !checkInDate.before(reservation.getCheckOutDate())))) ||
                        (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
                    findAvailableRooms.add(room);}
            }



        }
        System.out.println(findAvailableRooms);
        return findAvailableRooms;
    }



    public Collection<Reservation> getCustomersReservation(Customer customer){
        Collection<Reservation> customersReservations = new HashSet<>();
        for(Reservation reservation : reservations){
            if(reservation.getCustomer().equals(customer)){
                customersReservations.add(reservation);
            }
        }
        return customersReservations;
    }

    public Collection<Reservation> printAllReservations(){
        return reservations;
    }

}
