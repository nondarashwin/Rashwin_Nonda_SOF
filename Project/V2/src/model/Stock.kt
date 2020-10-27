package model

 class Stock(var storeId: Int, var productId: Int, var stock: Int) {

     fun setterStock(a:Int){
        this.stock=a
    }
}