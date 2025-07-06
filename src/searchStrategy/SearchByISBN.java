package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByISBN implements SearchStrategy {
    @Override
    public Book search(List<Book> books, Book bookToSearch) {
        return books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(bookToSearch.getIsbn()))
                .findFirst()
                .orElse(null);
    }
}
