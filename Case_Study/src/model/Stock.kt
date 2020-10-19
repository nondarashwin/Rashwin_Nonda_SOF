package model

class Stock {
    var storeId:Int=0
    var productId:Int=0
    var Stock:Int=0

    constructor(storeId: Int, productId: Int, Stock: Int) {
        this.storeId = storeId
        this.productId = productId
        this.Stock = Stock
    }
    fun isStockAvailiable():Boolean{
        if(this.Stock<5){
            return false
        }
        return true
    }
}