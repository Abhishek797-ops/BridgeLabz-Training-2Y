abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return title + " by " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    boolean reserveItem(String user);

    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean reserved;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 21;
    }

    public boolean reserveItem(String user) {
        if (!reserved) {
            reserved = true;
            return true;
        }
        return false;
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean reserved;

    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public boolean reserveItem(String user) {
        if (!reserved) {
            reserved = true;
            return true;
        }
        return false;
    }

    public boolean checkAvailability() {
        return !reserved;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = { new Book("B1", "Java", "A"), new Magazine("M1", "Tech", "B"),
                new DVD("D1", "Movie", "C") };
        for (LibraryItem it : items)
            System.out.println(it.getTitle() + " LoanDays:" + it.getLoanDuration());
        Reservable r = (Reservable) items[0];
        System.out.println("Reserve book:" + r.reserveItem("user1") + " Available:" + r.checkAvailability());
    }
}
