package ru.netology.javaqa.product.product.book;

import ru.netology.javaqa.product.product.Product;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getAuthor().matches(search)) {
            return true;
        } else {
            return false;
        }
    }
}
