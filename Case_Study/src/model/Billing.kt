package model


class Billing {
    var billId: Int = 0
    var storeId: Int = 0
    var productIds: ArrayList<Product> = arrayListOf()
    var amount: Int = 0

    constructor(billId: Int, storeId: Int, productIds: ArrayList<Product>, amount: Int) {
        this.billId = billId
        this.storeId = storeId
        this.productIds = productIds
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