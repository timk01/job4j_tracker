package ru.job4j.pojo;

import static ru.job4j.pojo.Shop.indexOfNull;

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

        /**
         * several nulls, replace nulls with product(s), if we have any, using arraycopy
         * actually need additional method to find indexes (not included here) + need to keep in mind we can have
         * several null in row
         * here i consequently replace it with lefovers of old array (not best tactic, but it works)
         * ((here most basic case))
         */

        System.out.println();
        Product[] products2 = new Product[6];
        products2[0] = new Product("Bread", 4);
        products2[1] = new Product("Egg", 10);
        products2[2] = null;
        products2[3] = new Product("Fish", 3);
        products2[4] = null;
        products2[5] = new Product("Water", 1);
        Product[] productCopy = new Product[10];
        int nullIndex = indexOfNull(products2);
        System.arraycopy(products2, 0, productCopy, 0, nullIndex);
        for (Product product : productCopy) {
            System.out.println(product);
        }
        System.out.println();
        System.arraycopy(
                products2,
                nullIndex + 1,
                productCopy, nullIndex,
                products2.length - nullIndex - 1
        );
        for (Product product : productCopy) {
            System.out.println(product);
        }
        System.out.println();
        System.arraycopy(
                products2,
                nullIndex + 1 + 2,
                productCopy,
                nullIndex + 1,
                products2.length - nullIndex - 1 - 2
                );
        productCopy[products2.length - 1 - 1] = null;
        for (Product product : productCopy) {
            System.out.println(product);
        }
    }
}
