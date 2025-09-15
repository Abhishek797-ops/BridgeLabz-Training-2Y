package OOPS.Constructors.AccessModifier;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Book b = new Book("12345", "Java Programming", "James");
        System.out.println(b.ISBN + " " + b.title + " " + b.getAuthor());

        EBook eb = new EBook("67890", "Python Basics", "Guido", "PDF");
        eb.showDetails();
    }
}

class EBook extends Book {
    String format;

    EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    void showDetails() {
        System.out.println(ISBN + " " + title + " " + format);
    }
}
