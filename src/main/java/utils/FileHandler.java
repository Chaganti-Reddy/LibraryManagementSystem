package utils;

import model.Book;
import model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private static final String BOOKS_FILE = "data/books.dat";
    private static final String USERS_FILE = "data/users.dat";

    // Save books to file
    public static void saveBooks(Map<Integer, Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKS_FILE))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    // Save users to file
    public static void saveUsers(Map<Integer, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    // Load books from file
    @SuppressWarnings("unchecked")
    public static Map<Integer, Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKS_FILE))) {
            return (Map<Integer, Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    // Load users from file
    @SuppressWarnings("unchecked")
    public static Map<Integer, User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            return (Map<Integer, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }
}
