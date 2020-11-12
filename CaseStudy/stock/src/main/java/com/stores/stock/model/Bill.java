package com.stores.stock.model;

import javax.persistence.*;

@Entity
@Table(name="Bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int storeId;
    private int amount;

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

    public Bill(int id, int storeId, int amount) {
        this.id = id;
        this.storeId = storeId;
        this.amount = amount;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", amount=" + amount +
                '}';
    }
}
