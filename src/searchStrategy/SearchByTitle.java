package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByTitle implements SearchStrategy {
    @Override
    public Book search(List<Book> books, String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
