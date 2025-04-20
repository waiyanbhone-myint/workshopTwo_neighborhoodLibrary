package com.ps;
import java.util.Scanner;

public class Main {
    //Created an array to store 20 books
    static Book[] inventory = new Book[20];
    static Scanner scanner = new Scanner(System.in);
    //static Book book = new Book();

    public static void main(String[] args) {
        loadBooks();
        System.out.println("Books loaded! Total books: " + inventory.length);
        showHomeScreen();
    }

    //Put 20 books into the array
    public static void loadBooks() {
        inventory[0] = new Book(1, "ISBN001", "Broken Clue");
        inventory[1] = new Book(2, "ISBN002", "Midnight Trace");
        inventory[2] = new Book(3, "ISBN003", "Betrayal's Mask");
        inventory[3] = new Book(4, "ISBN004", "Hidden Dagger");
        inventory[4] = new Book(5, "ISBN005", "Galactic Echo");
        inventory[5] = new Book(6, "ISBN006", "Ion Storm");
        inventory[6] = new Book(7, "ISBN007", "Neon Dawn");
        inventory[7] = new Book(8, "ISBN008", "Xenosis");
        inventory[8] = new Book(9, "ISBN009", "Radiant Hearts");
        inventory[9] = new Book(10, "ISBN010", "Amethyst Sky");
        inventory[10] = new Book(11, "ISBN011", "Moonlit Haven");
        inventory[11] = new Book(12, "ISBN012", "Autumn Ember");
        inventory[12] = new Book(13, "ISBN013", "Dragonspire");
        inventory[13] = new Book(14, "ISBN014", "Arcane Moon");
        inventory[14] = new Book(15, "ISBN015", "Emerald Oath");
        inventory[15] = new Book(16, "ISBN016", "Crystal Thorn");
        inventory[16] = new Book(17, "ISBN017", "Gentle Storm");
        inventory[17] = new Book(18, "ISBN018", "Solitary Way");
        inventory[18] = new Book(19, "ISBN019", "Urban Dawn");
        inventory[19] = new Book(20, "ISBN020", "Fragment of Blue");
    }

    public static void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        System.out.println("ID   ISBN        Title");

        boolean found = false;

        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.printf("%-4d %-10s %-25s\n",
                        book.getId(), book.getIsbn(), book.getTitle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
            return;
        }

        System.out.print("Enter the ID of the book to check out (or 0 to go back): ");
        int selectedId = scanner.nextInt();
        scanner.nextLine();

        if (selectedId == 0) return;

        for (Book book : inventory) {
            if (book.getId() == selectedId && !book.isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Book checked out to " + name);
                return;
            }
        }

        System.out.println("Invalid ID or book already checked out.");
    }

    public static void showCheckedOutBooks() {
        System.out.println("\nChecked Out Books:");
        System.out.println("ID   ISBN        Title                    Checked Out To");

        boolean found = false;

        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.printf("%-4d %-10s %-25s %-15s\n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.print("Enter 'C' to check in a book or 'X' to return to menu: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.equals("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Book book : inventory) {
                if (book.getId() == id && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book checked in.");
                    return;
                }
            }

            System.out.println("Invalid ID or book is not checked out.");
        }
    }



    public static void showHomeScreen() {
        while (true) {
            System.out.println("\nWelcome to the Neighborhood Library.");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                showAvailableBooks();
            } else if (choice == 2) {
                showCheckedOutBooks();
            } else if (choice == 3) {
                System.out.println("Thank you for visiting the library!");
                break;  // exit the loop
            } else {
                System.out.println("Please try again.");
            }
        }

}}
