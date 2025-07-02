package book;

public class Book {

    private String title;

    private String author;

    private BookCategory category;

    private String isbn;

    private int publicationYear;

    private boolean isBorrowed;

    public Book(String title, String author, BookCategory category, String isbn, int publicationYear, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBookDetails() {
        return "Title: " + title + ", Author: " + author +
               ", ISBN: " + isbn + ", Publication Year: " + publicationYear +
               ", Borrowed: " + isBorrowed;
    }
}
