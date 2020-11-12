package com.stores.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BillingProduct")
public class BilledProduct {
    @Id
    private int billId;
    @Id
    private int productId;
    private int cost;
    private int quantity;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BilledProduct(int billId, int productId, int cost, int quantity) {
        this.billId = billId;
        this.productId = productId;
        this.cost = cost;
        this.quantity = quantity;
    }

    public BilledProduct() {
    }

    @Override
    public String toString() {
        return "BilledProduct{" +
                "billId=" + billId +
                ", productId=" + productId +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
