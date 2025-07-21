package main;

import service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        library.loadData();

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Java Library System");

        do {
            printMenu();
            System.out.print("Enter choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                }
                case 2 -> {
                    System.out.print("Enter book ID to remove: ");
                    int id = scanner.nextInt();
                    library.removeBook(id);
                }
                case 3 -> {
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                }
                case 4 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    library.registerUser(name);
                }
                case 5 -> {
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter book ID to borrow: ");
                    int bookId = scanner.nextInt();
                    library.borrowBook(userId, bookId);
                }
                case 6 -> {
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter book ID to return: ");
                    int bookId = scanner.nextInt();
                    library.returnBook(userId, bookId);
                }
                case 7 -> library.listBooks();
                case 8 -> library.listUsers();
                case 9 -> {
                    System.out.println("Saving and exiting...");
                    library.saveData();
                    System.out.println("Bye!");
                }
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 9);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1)  Add Book");
        System.out.println("2)  Remove Book");
        System.out.println("3)  Search Book");
        System.out.println("4)  Register User");
        System.out.println("5)  Borrow Book");
        System.out.println("6)  Return Book");
        System.out.println("7)  List All Books");
        System.out.println("8)  List All Users");
        System.out.println("9)  Save & Exit");
        System.out.println("==========================");
    }
}
