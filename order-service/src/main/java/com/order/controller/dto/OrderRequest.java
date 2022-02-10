package com.order.controller.dto;

import com.order.models.Product;

public class OrderRequest {

    private String login;
    private Product product;

    public OrderRequest(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
            "login='" + login + '\'' +
            ", product=" + product +
            '}';
    }
}
