package Controller

import doa.*
import model.Billing
import model.Product
import model.Stock
import model.Store
import java.util.*
import kotlin.collections.ArrayList

class Admin {
    fun displayProduct(p: Product) {

        print("Product Id=" + p.productId)
        print(" Product Name=" + p.productName)
        print(" Product Cost=" + p.productCost)
        print(" Product Type=" + p.productType)
        println(" Product Info=" + p.productInfo)
        if (p.productQuantity > 0) {
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

    fun addStock() {
        var sc = Scanner(System.`in`)
        print("Enter StoreId")
        var storeId = sc.nextInt()
        print("Enter ProductId ")
        var productId = sc.nextInt()
        print("Enter Stock")
        var stock = sc.nextInt()
        insert(Stock(storeId, productId, stock))
    }

    fun updateStock() {

        var sc = Scanner(System.`in`)
        print("Enter StoreId")
        var storeId = sc.nextInt()
        print("Enter ProductId ")
        var productId = sc.nextInt()
        print("Enter Stock")
        var stock = sc.nextInt()
        var s= searchStock(productId,storeId)
        if (s != null) {
            s.setterStock(s?.Stock?.plus(stock))
        }
        if (s != null) {
            updateStockRecord(s)
        }
    }

    fun searchStock(productId: Int, storeId: Int): Stock? {
        var stock = selectStockRecord()
        for (i in stock) {
            if (i.productId == productId && i.storeId == storeId) {
                return i
            }
        }
        return null
    }

    fun addStore() {
        var sc = Scanner(System.`in`)
        print("Enter store name")
        var storeName = sc.nextLine()
        print("enter store Address")
        var storeAddress = sc.nextLine()
        insert(Store(0, storeName, storeAddress, true))
    }

fun updateStoreDetails(){
    var scanner = Scanner(System.`in`)
    print("Enter Store Id")
    var storeId = scanner.nextInt()
    var store=searchStore(storeId)
    if(store!=null){
        println("enter choice 1.store name 2.store address")
        var choice=scanner.nextInt()
        scanner.nextLine()
        when(choice){
            1->{
                print("Enter name")
                store.storeName=scanner.nextLine()
            }
            2->{
                print("Enter Address")
                store.storeAddress=scanner.nextLine()
            }

        }
        updateStoreRecord(store)
    }
    else{
        print("Store Not found")
    }
}
    fun billing() {
        var scanner = Scanner(System.`in`)
        print("Enter Store Id")
        var storeId = scanner.nextInt()
        print("Enter number of products Bought")
        var n = scanner.nextInt()

        var products: ArrayList<Product> = ArrayList()
        for (i in 0 until n) {
            print("Enter Product Id")

            var product = searchProduct(scanner.nextInt())

            print("Enter Quantity")
            if (product != null) {
                product.productQuantity = scanner.nextInt()
                var stock = searchStock(product.productId, storeId)
                if (stock?.Stock!! > product.productQuantity) {
                    products.add(product)
                    var a = stock?.Stock?.minus(product.productQuantity)
                    stock.setterStock(a)
                    updateStockRecord(stock)
                } else {
                    println("asked quantity is not available")
                }
            }
        }
        var id = insert(Billing(0, storeId, products, -1))
        displayBill(id)
    }
    fun updateProductDetails(){
        var scanner = Scanner(System.`in`)
        println("enter product id")
        var p=searchProduct(scanner.nextInt())
        if(p!=null){
            print("Enter choice")
            print(" 1.name 2.type 3.cost 4.info 5.exit")
            var choice:Int=scanner.nextInt()
            when(choice){
                1-> {println("Enter name")
                    p.productName=scanner.nextLine()}
                2->{
                    println("enter type")
                p.productType=scanner.nextLine()}
                3->{
                    println("Enter Cost")
                    p.productCost=scanner.nextInt()
                }
                4->{
                    println("Enter info")
                    p.productInfo=scanner.nextLine()
                }

            }
            updateProductRecord(p)
        }
        else
        {
            print("Product Not found")
        }
    }
    fun displayBill(id: Int) {
        var bills = selectBillingRecord()
        for (i in bills) {
            println(i.amount)
            if (i.billId == id) {
                println("Bill No:${i.billId}")
                println("Store Id:${i.storeId}")
                println("total Amount:${i.amount}")
                println("ProductId Quantity UnitCost Cost")
                for (j in i.productIds) {
                    println("${j.productId} ${j.productQuantity} ${j.productCost} ${j.productQuantity * j.productCost}")
                }
            }
        }
        checkStock()
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
                        print(" Store Address=" + store.storeAddress)
                        print(" Product Name=" + product.productName)
                        println(" Stock Remaining="+i.Stock)
                    }
                }
            }
        }
    }

    fun eachProductSold() {
        var selling = countBillingProduct()
        println("ProductId Count")
        for (i in selling) {
            println("${i.key}  ${i.value}")
        }

    }
    fun highestSellingProduct() {
        var selling = countBillingProduct()
        var value=0
        var key=0
       // println("ProductId Count")
        for (i in selling) {
            if(i.value>=value){
                value=i.value
                key=i.key
            }
        }
        var p=searchProduct(key)
        if (p != null) {
            println("product name:${p.productName}")
            println("Total Sold:$value")
        }


    }
}
