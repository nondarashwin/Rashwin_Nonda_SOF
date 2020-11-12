package com.stores.stock.model;

import javax.persistence.*;

@Entity
@Table(name="Stock")
public class Stock {
    @Id
    private int storeId;
    @Id
    private int productId;
    private int stock;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Stock(int storeId, int productId, int stock) {
        this.storeId = storeId;
        this.productId = productId;
        this.stock = stock;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return "Stock{" +
                "storeId=" + storeId +
                ", productId=" + productId +
                ", stock=" + stock +
                '}';
    }
}
