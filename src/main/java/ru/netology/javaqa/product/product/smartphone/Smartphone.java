package ru.netology.javaqa.product.product.smartphone;

import ru.netology.javaqa.product.product.Product;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getManufacturer().matches(search)) {
            return true;
        } else {
            return false;
        }
    }
}
