package com.order.models;

public enum Product {

    PIZZA("Пицца", 300D), ICE_CREAME ("Мороженное", 100D);

    private String name;
    private Double price;

    Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
