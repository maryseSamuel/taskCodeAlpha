import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= 8; i++) {
            if (i <= 6) {
                rooms.add(new Room(i, "Standard"));
            } else {
                rooms.add(new Room(i, "Suite"));
            }
        }
    }
    public void makeReservation(String guestName, int roomNumber, String payement) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            room.bookRoom();
            reservations.add(new Reservation(guestName, roomNumber,room,payement));
            System.out.println("Reservation successful! Room booked for " + guestName);
        }
        else if(!room.isAvailable()) {
            System.out.println("Unfortunately, The Room you want to reserve is not available ");
        }
         else {
            System.out.println("Room does not exist.");
        }
    }
    public void cancelReservation(String guestName, int roomNumber) {
        Iterator<Reservation> iterator = reservations.iterator();
        while (iterator.hasNext()) {
        Reservation reservation = iterator.next();

        if (reservation.getGuestName().equalsIgnoreCase(guestName) && reservation.getRoomNumber() == roomNumber) {
            reservation.cancelReservation();
            iterator.remove();
            System.out.println("Reservation cancelled successfully.");
            return; 
        }
    }

    System.out.println("Reservation not found with the given guest name and room number.");
}
    
    public ArrayList<Room> getAvailableRooms(String category) {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    



    public void viewBookingDetails() {
        System.out.println("\nBooking Details:");
        if(reservations.isEmpty())
            System.out.println(" No reservations found!" );
        else{
        for (Reservation reservation : reservations) {
            System.out.println("Guest: " + reservation.getGuestName() +"\t Room Number: " + reservation.getRoomNumber()
            +"\t Payement Method: " + reservation.getPayementMethod());
        }
    }
    }

    private Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}