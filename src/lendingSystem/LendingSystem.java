package lendingSystem;

import InvertorySystem.Inventory;
import book.Book;
import patron.Patron;
import searchStrategy.SearchByAuthor;
import searchStrategy.SearchByISBN;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LendingSystem {

    private final List<LendingDetails> lendingDetailsList = new ArrayList<>();

    public String lendBook(Book book, Patron patron, Inventory inventory) {
        boolean isBook1Available = new Inventory().isBookAvailable(new SearchByISBN(), book.getIsbn(), inventory);
        if (!isBook1Available) return "Book is not available";

        lendingDetailsList.add(new LendingDetails(Map.of(patron, book)));
        new Inventory().removeBook(book);
        new Patron().addBorrowingHistory(book, patron);

        return  book.getTitle() + " was given to " + patron.getName() + " at " + LocalDateTime.now();
    }

    public void returnBook(Book book, Patron patron) {
        for (LendingDetails details : lendingDetailsList) {
            if (details.getLoans().containsKey(patron) && details.getLoans().get(patron).equals(book)) {
                details.setReturnDate(LocalDateTime.now());
                lendingDetailsList.remove(details);
                new Inventory().addBook(book);
                break;
            }
        }
    }

    public List<LendingDetails> getLendingDetailsList() {
        return lendingDetailsList;
    }

    public List<LendingDetails> getUnreturnedBooks() {
        List<LendingDetails> unreturnedBooks = new ArrayList<>();
        for (LendingDetails details : lendingDetailsList) {
            if (details.getReturnDate() == null) {
                unreturnedBooks.add(details);
            }
        }
        return unreturnedBooks;
    }

    public List<LendingDetails> getAllReturnedBooks() {
        List<LendingDetails> returnedBooks = new ArrayList<>();
        for (LendingDetails details : lendingDetailsList) {
            if (details.getReturnDate() != null) {
                returnedBooks.add(details);
            }
        }
        return returnedBooks;
    }
}
