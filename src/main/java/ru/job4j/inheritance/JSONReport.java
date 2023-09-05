package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String separator = System.lineSeparator();
        return "{" +  separator
                + "\t\"name\" : \"" + name + "\"," + separator
                + "\t\"body\" : \"" + body + "\"" + separator
                + "}";
    }
}
