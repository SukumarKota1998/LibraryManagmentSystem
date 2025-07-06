package searchStrategy;

import book.Book;

import java.util.List;

public interface SearchStrategy {
    Book search(List<Book> books, Book book);
}
