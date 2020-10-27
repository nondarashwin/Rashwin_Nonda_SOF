package model

class Store(var storeId: Int = 0, var storeName: String, var storeAddress: String, storeContuity: Boolean = true) {
    var storeClosed:Boolean= storeContuity

}