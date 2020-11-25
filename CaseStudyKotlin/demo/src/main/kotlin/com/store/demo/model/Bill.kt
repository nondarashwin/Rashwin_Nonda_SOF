package com.store.demo.model

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "Billing")
class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0
    var storeId = 0
    var totalAmount = 0

    @Transient
    var emailId: String? = null

    @Transient
    private var billedProducts: List<BilledProduct> = ArrayList<BilledProduct>()
    override fun toString(): String {
        return "Bill{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", totalAmount=" + totalAmount +
                ", emailId='" + emailId + '\'' +
                ", billedProducts=" + billedProducts +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is Bill) return false
        val bill = o
        return id == bill.id && storeId == bill.storeId && totalAmount == bill.totalAmount && emailId == bill.emailId && getBilledProducts() == bill.getBilledProducts()
    }

    override fun hashCode(): Int {
        return Objects.hash(id, storeId, totalAmount, emailId, getBilledProducts())
    }

    fun getBilledProducts(): List<BilledProduct> {
        return billedProducts
    }

    fun setBilledProducts(billedProducts: List<BilledProduct>) {
        this.billedProducts = billedProducts
    }

    constructor(id: Int, storeId: Int, totalAmount: Int, emailId: String?, billedProducts: MutableList<BilledProduct>) {
        this.id = id
        this.storeId = storeId
        this.totalAmount = totalAmount
        this.emailId = emailId
        this.billedProducts = billedProducts
    }

    constructor() {}
}