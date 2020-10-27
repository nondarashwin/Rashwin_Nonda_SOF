package model


class Billing//println("${i.productCost} ${i.productQuantity}")
(var billId: Int, var storeId: Int, var productIds: ArrayList<Product>, amount: Int) {
    var amount: Int = 0

    init {
        if(amount==-1){
        for (i in productIds) {
            //println("${i.productCost} ${i.productQuantity}")
            this.amount += i.productCost*i.productQuantity
        }}
        else
        {
            this.amount=amount
        }
    }

}