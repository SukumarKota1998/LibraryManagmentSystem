package lendingSystem;

import book.Book;
import patron.Patron;


import java.time.LocalDateTime;
import java.util.Map;

public class LendingDetails {

    private Map<Patron, Book> loans;

    private LocalDateTime checkoutDate;

    private LocalDateTime returnDate;

    public LendingDetails(Map<Patron, Book> loans) {
        this.loans = loans;
        this.checkoutDate = LocalDateTime.now();
        this.returnDate = null;
    }

    public Map<Patron, Book> getLoans() {
        return loans;
    }

    public void setLoans(Map<Patron, Book> loans) {
        this.loans = loans;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
