package patron;

import book.Book;
import book.BookCategory;

import java.util.HashMap;
import java.util.Map;

public class Patron {

    private String id;

    private String name;

    private String Address;

    private String phoneNumber;

    private Map<BookCategory, Map<String, String>> borrowingHistory; // Map of Category -> Map of Author -> Title

    public Patron(String id, String name, String address, String phoneNumber, Book book) {
        this.id = id;
        this.name = name;
        this.Address = address;
        this.phoneNumber = phoneNumber;
        this.borrowingHistory = Map.of(
                book.getCategory(), Map.of(book.getAuthor(), book.getTitle())
        );
    }

    public Patron(String id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.Address = address;
        this.phoneNumber = phoneNumber;
        this.borrowingHistory = new HashMap<>();
    }

    public Patron() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<BookCategory, Map<String, String>> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(Map<BookCategory, Map<String, String>> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public void addBorrowingHistory(Book book, Patron patron) {
        patron.borrowingHistory.computeIfAbsent(book.getCategory(), k -> new HashMap<>())
                .put(book.getAuthor(), book.getTitle());
    }
}
