package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book firstBook = new Book("noname", 100);
        Book secondBook = new Book("Clean code", 500);
        Book thirdBook = new Book(null, -1);
        Book fourthBook = new Book("Clean code", 355);
        Book[] books = new Book[] {firstBook, secondBook, thirdBook, fourthBook};
        printBooks(books);
        swapBooks(books, 0, 3);
        printBooks(books);
        String name = "Clean code";
        printBooksWithName(books, name);
    }

    public static void printBooks(Book[] books) {
        System.out.println("All books in library");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            printABook(currentBook);
        }
        System.out.println();
    }

    public static void printBooksWithName(Book[] books, String name) {
        System.out.println("All books in library with name " + name);
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if (name.equals(currentBook.getName())) {
                printABook(currentBook);
            }
        }
        System.out.println();
    }

    public static void printABook(Book currentBook) {
        System.out.println("book name: " + currentBook.getName()
                + "; book size: "  + currentBook.getPage());
    }

    public static void swapBooks(Book[] books, int from, int to) {
        Book temp = books[from];
        books[from] = books[to];
        books[to] = temp;
    }
}
