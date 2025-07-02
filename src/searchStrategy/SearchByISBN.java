package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByISBN implements SearchStrategy {
    @Override
    public Book search(List<Book> books, String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);
    }
}
