📚 Library Management System
A simple Library Management System developed in Java to manage books, track lending records, and monitor patrons efficiently. This project demonstrates Object-Oriented Programming principles, SOLID design, and basic project structure.

🚀 Features
✅ Add, update, and remove books
✅ Manage library patrons
✅ Track book lending and returns
✅ Prevent duplicate book lending
✅ Flexible search by title, author, or ISBN
✅ Console-based interaction

🛠️ Technologies Used
Java (Core Java, OOP)

Collections Framework

Design Patterns (Strategy Pattern)

📂 Project Structure
LibraryManagementSystem/
├── src/
│   ├── book/                 # Book classes
│   ├── patron/               # Patron classes
│   ├── lendingSystem/        # Lending management
│   ├── InvertorySystem/      # Inventory management
│   ├── searchStrategy/       # Search functionality
│   └── Main.java             # Entry point
├── README.md
📐 Class Relationships and Design Overview
The Library Management System follows Object-Oriented Design principles with clearly defined relationships among its core classes:

The Inventory class maintains a One-to-Many Aggregation with the Book class. This means the library inventory holds multiple books, but books themselves can exist independently of the inventory.

The LendingDetails class has a Many-to-One Association with both the Patron and Book classes. Each lending record connects a specific patron and book, but a patron or book can be associated with multiple lending records over time.

The LendingSystem class exhibits a One-to-Many Composition relationship with LendingDetails. Lending records are considered part of the system, and their lifecycle depends on the system itself.

The Patron class has a One-to-Many Association with books through its borrowingHistory, which maps categories to authors and book titles, tracking a patron's borrowing activity.

The project employs the Strategy Design Pattern through the SearchStrategy interface. Concrete implementations like SearchByTitle, SearchByAuthor, and SearchByISBN allow flexible search functionality. This reflects Inheritance and Polymorphism, enabling different search behaviors at runtime.

This modular design promotes separation of concerns, reusability, and scalability, making it easier to extend features like search criteria, user management, or integration with databases in future enhancements.

✨ Quick Summary of Relationships
Class	Related To	Type of Relationship
Inventory	Book	One-to-Many Aggregation
LendingDetails	Patron, Book	Many-to-One Association
LendingSystem	LendingDetails	One-to-Many Composition
Patron	Book (via Map)	One-to-Many Association
SearchStrategy	Search Implementations	Inheritance (Strategy Pattern)

🎯 How It Works
Users can add new books to the system
Patrons can be registered
Books can be issued to patrons, with validation to avoid multiple issues of the same book
Books can be returned, and the system tracks availability
Search functionality is flexible and supports searching by title, author, or ISBN
