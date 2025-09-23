import java.util.*;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void showBooks() {
        for (Book b : books)
            System.out.println(b.title + " by " + b.author);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Book b2 = new Book("Python", "Guido");
        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.showBooks();
    }
}
