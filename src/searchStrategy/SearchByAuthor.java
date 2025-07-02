package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public Book search(List<Book> books, String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .findFirst()
                .orElse(null);
    }
}
