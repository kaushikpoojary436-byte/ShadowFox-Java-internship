import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    static ArrayList<Contact> contacts = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== CONTACT MANAGER =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    addContact();
                    break;

                case "2":
                    viewContacts();
                    break;

                case "3":
                    searchContact();
                    break;

                case "4":
                    deleteContact();
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addContact() {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        if (!phone.matches("\\d+")) {
            System.out.println("Phone must contain numbers only!");
            return;
        }

        for (Contact c : contacts) {

            if (c.getPhone().equals(phone)) {
                System.out.println("Phone number already exists!");
                return;
            }
        }

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        if (!email.contains("@")) {
            System.out.println("Invalid email!");
            return;
        }

        contacts.add(new Contact(name, phone, email));

        System.out.println("Contact added!");
    }

    static void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    static void searchContact() {

        System.out.print("Enter name: ");

        String search = sc.nextLine().toLowerCase();

        for (Contact c : contacts) {

            if (c.getName().toLowerCase().contains(search)) {
                System.out.println(c);
            }
        }
    }

    static void deleteContact() {

        System.out.print("Enter phone number: ");

        String phone = sc.nextLine();

        for (Contact c : contacts) {

            if (c.getPhone().equals(phone)) {

                contacts.remove(c);

                System.out.println("Deleted successfully!");

                return;
            }
        }

        System.out.println("Contact not found!");
    }
}