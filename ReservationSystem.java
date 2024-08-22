import java.util.Scanner;

public class ReservationSystem {
    private static boolean[] slots = new boolean[10]; // 10 slots for simplicity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*** Online Reservation System ***");
            System.out.println("1. View Available Slots");
            System.out.println("2. Book a Slot");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewSlots();
                    break;
                case 2:
                    bookSlot(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the reservation system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void viewSlots() {
        System.out.println("\nAvailable Slots:");
        for (int i = 0; i < slots.length; i++) {
            System.out.println("Slot " + (i + 1) + ": " + (slots[i] ? "Booked" : "Available"));
        }
    }

    private static void bookSlot(Scanner scanner) {
        System.out.print("Enter the slot number (1-10) to book: ");
        int slotNumber = scanner.nextInt();

        if (slotNumber < 1 || slotNumber > 10) {
            System.out.println("Invalid slot number! Please choose between 1 and 10.");
        } else if (slots[slotNumber - 1]) {
            System.out.println("Sorry, this slot is already booked.");
        } else {
            slots[slotNumber - 1] = true;
            System.out.println("Slot " + slotNumber + " has been successfully booked.");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter the slot number (1-10) to cancel: ");
        int slotNumber = scanner.nextInt();

        if (slotNumber < 1 || slotNumber > 10) {
            System.out.println("Invalid slot number! Please choose between 1 and 10.");
        } else if (!slots[slotNumber - 1]) {
            System.out.println("This slot is not booked, so cannot be canceled.");
        } else {
            slots[slotNumber - 1] = false;
            System.out.println("Slot " + slotNumber + " has been successfully canceled.");
        }
    }
}