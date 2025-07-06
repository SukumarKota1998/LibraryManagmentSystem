package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public Book search(List<Book> books, Book bookToSearch) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(bookToSearch.getAuthor()))
                .findFirst()
                .orElse(null);
    }
}
