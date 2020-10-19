package Controller

import doa.*
import model.Billing
import model.Product
import model.Store
import java.util.*
import kotlin.collections.ArrayList

class Admin {
    fun displayProduct(p: Product) {

        print("Product Id=" + p.productId)
        print(" Product Name=" + p.productName)
        print(" Product Cost=" + p.productCost)
        print(" Product Type=" + p.productType)
        println (" Product Info=" + p.productInfo)
        if(p.productQuantity>0){
            println(" Product Info=" + p.productInfo)
        }

    }

    fun displayAllProducts() {
        var p = selectProductRecord()
        for (i in p) {
            print("*************")
            displayProduct(i)
        }
    }

    fun AddProduct() {
        var scanner = Scanner(System.`in`)
        print("Enter Name")
        var name = scanner.nextLine()
        print("Enter Type")
        var type = scanner.nextLine()
        print("Enter info")
        var info = scanner.nextLine()
        print("Enter Cost")
        var cost = scanner.nextInt()
        insert(Product(0, name, type, info, cost, 0, true))


    }
    fun billing(){
        var scanner=Scanner(System.`in`)
        var storeId=scanner.nextInt()
        print("Enter number of products Bought")
        var n=scanner.nextInt()

        var products:ArrayList<Product> =ArrayList()
        for(i in 0 until n-1){
            print("Enter Product Id")

            var product=searchProduct(scanner.nextInt())

            print("Enter Quantity")
            if(product!=null){
                product.productQuantity=scanner.nextInt()
                products.add(product)
            }
        }
       var id= insert(Billing(0,storeId,products,-1))

    }
    fun displayBill(id:Int){
        var bills= selectBillingRecord()
        for(i in  bills){
            if(i.billId==id){
            println("Bill No:${i.billId}")
            println("Store Id:${i.storeId}")
                println("total Amount:${i.amount}")
                println("ProductId Quantity UnitCost Cost")
            for(j in i.productIds){
               print("${j.productId} ${j.productQuantity} ${j.productCost} ${j.productQuantity*j.productCost}")
            }
            }
        }
    }
    fun AddStore() {
        var scanner = Scanner(System.`in`)
        println("Enter Store Name")
        var name = scanner.nextLine()
        print("Enter Store Address")
        var address = scanner.nextLine()
        insert(Store(0, name, address, true))


    }

    fun searchProduct(id: Int): Product? {
        var product = selectProductRecord()
        for (i in product) {
            if (i.productId == id) {
                return i
            }
        }
        return null

    }

    fun searchStore(id: Int): Store? {
        var product = selectStoreRecord()
        for (i in product) {
            if (i.storeId == id) {
                return i
            }
        }
        return null

    }

    fun checkStock() {
        var stock = selectStockRecord()

        for (i in stock) {
            if (i.Stock <= 10) {
                var store = searchStore(i.storeId)
                var product = searchProduct(i.productId)
                if (product != null) {
                    if (store != null) {
                        print("Store Name=" + store.storeName)
                        print("Store Address=" + store.storeAddress)
                        print("Product Name=" + product.productName)

                    }
                }
            }
        }
    }
    fun eachProductSold(){
var selling= countBillingProduct()
        print("Product Count")
        for(i in selling){
            print("${i.value}  ${i.key}")
        }

    }
}
