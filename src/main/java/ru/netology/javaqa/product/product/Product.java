package ru.netology.javaqa.product.product;

public abstract class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean matches(String search) {
        if (getName().matches(search)) {
            return true;
        } else {
            return false;
        }
    }
}
