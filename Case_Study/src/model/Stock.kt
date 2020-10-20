package model

class Stock {
    var storeId:Int=0
    var productId:Int=0
    open var  Stock:Int=0

    constructor(storeId: Int, productId: Int, Stock: Int) {
        this.storeId = storeId
        this.productId = productId
        this.Stock = Stock
    }
    fun setterStock(a:Int){
        this.Stock=a
    }
}