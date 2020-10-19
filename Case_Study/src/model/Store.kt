package model

class Store{
    var storeId:Int=0
     var storeName=""
     var storeAddress=""
    var storeClosed:Boolean=true
    constructor(storeId: Int=0, storeName: String, storeAddress: String, storeContuity: Boolean=true) {
        this.storeId = storeId
        this.storeName = storeName
        this.storeAddress = storeAddress
        this.storeClosed = storeContuity
    }

}