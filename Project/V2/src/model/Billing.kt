package model


class Billing(var id: Int, var storeId: Int, var productIds: ArrayList<Product>, amount: Int) {
    var amount: Int = 0

    init {
        if (amount == -1) {
            for (i in productIds) {
                //println("${i.cost} ${i.quantity}")
                this.amount += i.cost * i.quantity
            }
        } else {
            this.amount = amount
        }
    }

}