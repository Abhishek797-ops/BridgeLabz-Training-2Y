class Book {
    private static String libraryName = "City Library";
    private final String isbn;
    private String title, author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("12345", "Java Basics", "James Gosling");
        Book book2 = new Book("67890", "Data Structures", "Robert Lafore");
        Book.displayLibraryName();
        book1.displayDetails();
        book2.displayDetails();
    }
}
