import java.util.List;
import java.util.Scanner;
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n*****Hotel Reservation System*****");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                System.out.print("Enter room category (Standard/Suite): ");
                String category;
                while (true) {
                    category = scanner.next();
                    if (category.equalsIgnoreCase("Standard") || category.equalsIgnoreCase("Suite")) {
                        break;
                    } else {
                        System.out.println("Invalid category. Please enter either 'Standard' or 'Suite'.");
                    }
                }
                List<Room> availableRooms = hotel.getAvailableRooms(category);
                System.out.println("Available Rooms:");
                for (Room room : availableRooms) {
                    System.out.println("Room Number: " + room.getRoomNumber() +"\t Category: " + room.getCategory());
                }
                
                    break;

                case 2:
                System.out.print("Enter your name: ");
                String guestName = scanner.next();
                System.out.print("Enter room category (Standard/Suite): ");
                String category1;
                while (true) {
                    category1 = scanner.next();
                    if (category1.equalsIgnoreCase("Standard") || category1.equalsIgnoreCase("Suite")) {
                        break;
                    } else {
                        System.out.println("Invalid category. Please enter either 'Standard' or 'Suite'.");
                    }
                }
                List<Room> availableRooms1 = hotel.getAvailableRooms(category1);
                System.out.println("Available Rooms:");
                for (Room room : availableRooms1) {
                    System.out.println("Room Number: " + room.getRoomNumber() +"\t Category: " + room.getCategory());
                }
                int roomNumber;
                while (true) {
                    System.out.print("Enter room number to book: ");
                    if (scanner.hasNextInt()) {
                        roomNumber = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid room number.");
                        scanner.next(); 
                    }
                }
                String paymentMethod;
                while (true) {
                    System.out.print("Enter your preferred payment method (cash/card): ");
                    paymentMethod = scanner.next().toLowerCase(); 
                    if (paymentMethod.equals("cash") || paymentMethod.equals("card")) {
                        break;
                    } else {
                         System.out.println("Invalid payment method. Please enter either 'cash' or 'card'.");
                           }
                            }
                hotel.makeReservation(guestName, roomNumber,paymentMethod);
                    break;

                case 3:
                    hotel.viewBookingDetails();
                    System.out.print("Enter your name: ");
                    String guestName1 = scanner.next();
                    System.out.print("Enter room number to cancel its reservation: ");
                    int roomNumber1 = scanner.nextInt();
                    hotel.cancelReservation(guestName1, roomNumber1);
                    break;
                    

                case 4:
                    hotel.viewBookingDetails();
                    break;
                   
                case 5:
                    System.out.println("Exiting Hotel Reservation System. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
