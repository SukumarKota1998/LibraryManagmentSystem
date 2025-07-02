import InvertorySystem.Inventory;
import book.Book;
import book.BookCategory;
import lendingSystem.LendingSystem;
import patron.Patron;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "A1", BookCategory.THRILLER, "B123#", 2020, false);
        Book book2 = new Book("Book2", "A2", BookCategory.SCIENCE_FICTION, "B456#", 2024, false);
        Book book3 = new Book("Book3", "A3", BookCategory.CHILDRENS_BOOKS, "B789#", 2000, false);

        Inventory inventory = new Inventory();
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);

        Patron patron1 = new Patron("1234", "P1", "Address1", "+91 9111111111");
        Patron patron2 = new Patron("56789", "P2", "Address2", "+91 8111111111");
        Patron patron3 = new Patron("6523", "P3", "Address3", "+91 6111111111");

        LendingSystem lendingSystem = new LendingSystem();
        String book1Result = lendingSystem.lendBook(book1, patron1, inventory);
        String book2Result = lendingSystem.lendBook(book2, patron2, inventory);
        String book3Result = lendingSystem.lendBook(book3, patron2, inventory);

        System.out.println(book1Result);
        System.out.println(book2Result);
        System.out.println(book3Result);

        System.out.println(patron2.getBorrowingHistory());

        lendingSystem.returnBook(book1, patron1);
        lendingSystem.returnBook(book2, patron2);
    }
}