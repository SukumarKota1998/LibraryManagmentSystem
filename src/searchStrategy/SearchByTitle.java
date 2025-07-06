package searchStrategy;

import book.Book;

import java.util.List;

public class SearchByTitle implements SearchStrategy {
    @Override
    public Book search(List<Book> books, Book bookToSearch) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(bookToSearch.getTitle()))
                .findFirst()
                .orElse(null);
    }
}
