package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book firstBook = new Book("noname", 100);
        Book secondBook = new Book("Clean code", 500);
        Book thirdBook = new Book(null, -1);
        Book fourthBook = new Book("Design manual", 355);
        Book fifthBook = new Book("Clean code", 355);
        Book[] books = new Book[] {firstBook, secondBook, thirdBook, fourthBook, fifthBook};
        System.out.println("All books in library");
        for (int i = 0; i < books.length; i++) {
            System.out.println("book name: " + books[i].getName() + " book size: " + books[i].getPage());
        }
        swapBooks(books, 0, 2);
        System.out.println(System.lineSeparator() + "Books with name \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            if ("Clean code".equals(currentBook.getName())) {
                System.out.println(currentBook.getName() + ", " + currentBook.getPage());
            }
        }
    }

    private static void swapBooks(Book[] books, int from, int to) {
        Book temp = books[from];
        books[from] = books[to];
        books[to] = temp;
    }
}
