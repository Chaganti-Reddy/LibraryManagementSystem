package service;

import model.Book;
import model.User;
import utils.FileHandler;

import java.util.*;

public class LibraryService {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private int bookIdCounter = 1;
    private int userIdCounter = 1;

    public void loadData() {
        books = FileHandler.loadBooks();
        users = FileHandler.loadUsers();
        if (!books.isEmpty()) {
            bookIdCounter = Collections.max(books.keySet()) + 1;
        }
        if (!users.isEmpty()) {
            userIdCounter = Collections.max(users.keySet()) + 1;
        }
    }

    public void saveData() {
        FileHandler.saveBooks(books);
        FileHandler.saveUsers(users);
    }

    public void addBook(String title, String author) {
        Book book = new Book(bookIdCounter++, title, author);
        books.put(book.getId(), book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(int bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found)
            System.out.println("No matching books found.");
    }

    public void registerUser(String name) {
        User user = new User(userIdCounter++, name);
        users.put(user.getId(), user);
        System.out.println("User registered: " + user);
    }

    public void borrowBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        book.setAvailable(false);
        user.borrowBook(bookId);
        System.out.println("Book borrowed.");
    }

    public void returnBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }
        if (!user.getBorrowedBookIds().contains(bookId)) {
            System.out.println("This user hasn’t borrowed this book.");
            return;
        }
        book.setAvailable(true);
        user.returnBook(bookId);
        System.out.println("Book returned.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
