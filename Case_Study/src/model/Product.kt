package model

class Product {
     var productId:Int =0
    var productName:String=""
     var productType:String=""
     var productInfo:String=""
     var productCost:Int=0
    var productQuantity:Int=0
    var productContniuity:Boolean=true

    constructor(productId: Int=0, productName: String, productType: String, productInfo: String, productCost: Int,productQuantity:Int=0 ,productContniuity: Boolean) {
        this.productId = productId
        this.productName = productName
        this.productType = productType
        this.productInfo = productInfo
        this.productCost = productCost
        this.productQuantity=productQuantity
        this.productContniuity = productContniuity
    }



    

}