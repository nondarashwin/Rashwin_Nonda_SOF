package com.store.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table
@Entity
@Table(name = "BillingProduct")
@IdClass(BilledProduct::class)
class BilledProduct : Serializable {
    @Id 
    @JsonIgnore
    var billId = 0
    @Id
    var productId = 0
    var cost = 0
    var quantity = 0

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is BilledProduct) return false
        val that = o
        return billId == that.billId && productId == that.productId && cost == that.cost && quantity == that.quantity
    }

    override fun hashCode(): Int {
        return Objects.hash(billId, productId, cost, quantity)
    }

    constructor(billId: Int, productId: Int, cost: Int, quantity: Int) {
        this.billId = billId
        this.productId = productId
        this.cost = cost
        this.quantity = quantity
    }

    constructor() {}

    override fun toString(): String {
        return "BilledProduct{" +
                "billId=" + billId +
                ", productId=" + productId +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}'
    }
}