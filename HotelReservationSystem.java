import java.util.HashMap;
import java.util.Scanner;

public class HotelReservationSystem {

    static HashMap<Integer, String> rooms = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize rooms (Room number -> Empty)
        for (int i = 101; i <= 105; i++) {
            rooms.put(i, "Available");
        }

        int choice;

        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookRoom = sc.nextInt();
                    bookRoom(bookRoom);
                    break;

                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelRoom = sc.nextInt();
                    cancelBooking(cancelRoom);
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    static void viewRooms() {
        System.out.println("\nRoom Status:");
        for (int room : rooms.keySet()) {
            System.out.println("Room " + room + " : " + rooms.get(room));
        }
    }

    static void bookRoom(int roomNumber) {
        if (rooms.containsKey(roomNumber)) {
            if (rooms.get(roomNumber).equals("Available")) {
                rooms.put(roomNumber, "Booked");
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room already booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    static void cancelBooking(int roomNumber) {
        if (rooms.containsKey(roomNumber)) {
            if (rooms.get(roomNumber).equals("Booked")) {
                rooms.put(roomNumber, "Available");
                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("Room is not booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }
}