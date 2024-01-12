public class Reservation {
    private String guestName;
    private int roomNumber;
    private Room room;
    private String payementMethod;

    public Reservation(String guestName, int roomNumber, Room room,String payementMethod) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.room = room;
        this.payementMethod = payementMethod;
    }

    public String getGuestName() {
        return guestName;
    }
    public String getPayementMethod() {
        return payementMethod;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void cancelReservation() {
        if (room != null) {
            room.cancelRoom();
        }
    }
}
