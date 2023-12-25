package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .flatMap(Stream::ofNullable)
                .filter(product -> product.getStandard() - product.getActual() >= 0)
                .filter(product -> product.getStandard() - product.getActual() <= 3)
                .map(product -> new Label(product.getName(), (float) (product.getPrice() * 0.5)))
                .map(Label::toString)
                .toList();
    }
}