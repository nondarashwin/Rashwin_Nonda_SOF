package com.store.demo.model

import java.io.Serializable
import java.util.*
import javax.persistence.*
@Entity
@Table(name = "Stock")
@IdClass(Stock::class)
class Stock : Serializable {
    @Id
    @PrimaryKeyJoinColumn
    var storeId = 0

    @Id
    @PrimaryKeyJoinColumn
    var productId = 0
    var stock = 0

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is Stock) return false
        val stock1 = o
        return storeId == stock1.storeId && productId == stock1.productId && stock == stock1.stock
    }

    override fun hashCode(): Int {
        return Objects.hash(storeId, productId, stock)
    }

    constructor(storeId: Int, productId: Int, stock: Int) {
        this.storeId = storeId
        this.productId = productId
        this.stock = stock
    }

    constructor() {}

    override fun toString(): String {
        return "Stock{" +
                "storeId=" + storeId +
                ", productId=" + productId +
                ", stock=" + stock +
                '}'
    }
}