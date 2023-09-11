package ru.job4j.poly;

public class FileStore implements Store {
    private String path;

    public FileStore() { }

    public FileStore(String path) {
        this.path = path;
    }

    @Override
    public void save(String data) {
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void foo() {
        System.out.println("ovveride foo");
    }
}