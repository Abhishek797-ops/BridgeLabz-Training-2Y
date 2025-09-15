package OOPS.Constructors;

import java.util.Scanner;

class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Is available? (true/false): ");
        boolean available = sc.nextBoolean();

        LibraryBook b1 = new LibraryBook(title, author, price, available);
        System.out.println("Book created: " + b1.title + " by " + b1.author);

        b1.borrowBook();
        b1.borrowBook(); // try again to see not available
        sc.close();
    }
}
