package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        Product[] products2 = new Product[5];
        products2[0] = new Product("Bread", 4);
        products2[1] = new Product("Egg", 10);
        products2[2] = null;
        products2[3] = new Product("Fish", 3);
        products2[4] = null;
        Product[] productCopy = new Product[10];
        System.arraycopy(products, 0, productCopy, 0, 5);
        for (Product product : productCopy) {
            System.out.println(product);
        }
    }
}
