import InvertorySystem.Inventory;
import book.Book;
import book.BookCategory;
import lendingSystem.LendingSystem;
import patron.Patron;
import searchStrategy.SearchByAuthor;
import searchStrategy.SearchByISBN;
import searchStrategy.SearchByTitle;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "A1", BookCategory.THRILLER, "B123#", 2020, false);
        Book book2 = new Book("Book2", "A2", BookCategory.SCIENCE_FICTION, "B456#", 2024, false);
        Book book3 = new Book("Book3", "A3", BookCategory.CHILDRENS_BOOKS, "B789#", 2000, false);

        Inventory inventory = new Inventory();
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);

        inventory.displayAllAvailableBooks();

        Patron patron1 = new Patron("1234", "P1", "Address1", "+91 9111111111");
        Patron patron2 = new Patron("56789", "P2", "Address2", "+91 8111111111");
        Patron patron3 = new Patron("6523", "P3", "Address3", "+91 6111111111");

        LendingSystem lendingSystem = new LendingSystem();
        String firstLendingResult = lendingSystem.lendBook(book1, patron1, inventory, new SearchByISBN());
        String secondLendingResult = lendingSystem.lendBook(book2, patron2, inventory, new SearchByAuthor());
        String thirdLendingResult = lendingSystem.lendBook(book3, patron2, inventory, new SearchByTitle());
        String fourthLendingResult = lendingSystem.lendBook(book3, patron2, inventory, new SearchByTitle());

        System.out.println(firstLendingResult);
        System.out.println(secondLendingResult);
        System.out.println(thirdLendingResult);
        System.out.println(fourthLendingResult);

        patron1.displayBorrowingHistory();

        lendingSystem.returnBook(book1, patron1);
        lendingSystem.returnBook(book2, patron2);
    }
}