package InvertorySystem;

import book.Book;
import searchStrategy.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    public Map<String, List<Book>> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.computeIfAbsent(book.getIsbn(), k -> new ArrayList<>()).add(book);
    }

    public void removeBook(Book book) {
        List<Book> books = inventory.get(book.getIsbn());
        if (books != null) {
            books.remove(book);
            if (books.isEmpty()) {
                inventory.remove(book.getIsbn());
            }
        }
    }

    public void updateBook(Book oldBook, Book newBook) {
        removeBook(oldBook);
        addBook(newBook);
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        for (List<Book> books : inventory.values()) {
            allBooks.addAll(books);
        }
        return allBooks;
    }

    public void displayAllAvailableBooks() {
        if (inventory.isEmpty()) {
            System.out.println("No books available in the inventory.");
            return;
        }

        System.out.println("Available Books:");
        for (List<Book> books : inventory.values()) {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() +
                        ", ISBN: " + book.getIsbn() +
                        ", Category: " + book.getCategory() +
                        ", Author: " + book.getAuthor());
            }
        }
    }

    public boolean isInventoryEmpty() {
        return inventory.isEmpty();
    }

    public boolean isBookAvailable(SearchStrategy searchStrategy, Book book, Inventory inventory) {
        if (inventory.isInventoryEmpty()) {
            return false;
        }

        return searchStrategy.search(inventory.getAllBooks(), book) != null;
    }
}
