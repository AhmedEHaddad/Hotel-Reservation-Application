package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, double price, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
        //this.setPrice(0.0);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
