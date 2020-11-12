package com.stores.stock.model;

import java.util.List;

public class ViewBill {
    private int id;
    private int storeId;
    private int amount;
    private List<BilledProduct> billedProducts;

    public ViewBill(int id, int storeId, int amount, List<BilledProduct> billedProducts) {
        this.id = id;
        this.storeId = storeId;
        this.amount = amount;
        this.billedProducts = billedProducts;
    }

    public ViewBill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<BilledProduct> getBilledProducts() {
        return billedProducts;
    }

    public void setBilledProducts(List<BilledProduct> billedProducts) {
        this.billedProducts = billedProducts;
    }
}
