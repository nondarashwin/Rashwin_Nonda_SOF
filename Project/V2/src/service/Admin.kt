package service

import doa.*
import model.Billing
import model.Product
import model.Stock
import model.Store
import java.util.*
import javax.mail.Transport
import kotlin.collections.ArrayList

class Admin {
    private fun displayProduct(p: Product) {
        if (p.continuity) {
            print("Product Id=" + p.id)
            print(" Product Name=" + p.name)
            print(" Product Cost=" + p.cost)
            print(" Product Type=" + p.type)
            println(" Product Info=" + p.info)
            if (p.quantity > 0) {
                println(" Product Info=" + p.info)
            }
        }
    }

    fun displayAllProducts() {
        val p = selectProductRecord()
        for (i in p) {
            displayProduct(i)
        }
    }

    fun addProduct() {
        val scanner = Scanner(System.`in`)
        print("Enter Name")
        val name = scanner.nextLine()
        print("Enter Type")
        val type = scanner.nextLine()
        print("Enter info")
        val info = scanner.nextLine()
        print("Enter Cost")
        val cost = scanner.nextInt()
        insert(Product(0, name, type, info, cost, 0, true))


    }

    fun addStock() {
        val sc = Scanner(System.`in`)
        print("Enter StoreId")
        val storeId = sc.nextInt()
        print("Enter ProductId ")
        val productId = sc.nextInt()
        print("Enter stock")
        val stock = sc.nextInt()
        insert(Stock(storeId, productId, stock))
    }

    fun updateStock() {

        val sc = Scanner(System.`in`)
        print("Enter StoreId")
        val storeId = sc.nextInt()
        print("Enter ProductId ")
        val productId = sc.nextInt()
        print("Enter stock")
        val stock = sc.nextInt()
        val s = searchStock(productId, storeId)
        s?.setterStock(s.stock.plus(stock))
        if (s != null) {
            updateStockRecord(s)
        }
    }

    private fun searchStock(productId: Int, storeId: Int): Stock? {
        val stock = selectStockRecord()

        for (i in stock) {
            if (i.productId == productId && i.storeId == storeId) {
                return i
            }
        }
        return null
    }


    fun updateStoreDetails() {
        val scanner = Scanner(System.`in`)
        print("Enter Store Id")
        val storeId = scanner.nextInt()
        val store = searchStore(storeId)
        if (store != null) {
            println("enter choice 1.store name 2.store address")
            val choice = scanner.nextInt()
            scanner.nextLine()
            when (choice) {
                1 -> {
                    print("Enter name")
                    store.name = scanner.nextLine()
                }
                2 -> {
                    print("Enter Address")
                    store.address = scanner.nextLine()
                }

            }
            updateStoreRecord(store)
        } else {
            print("Store Not found")
        }
    }

    fun billing() {
        val scanner = Scanner(System.`in`)
        print("Enter Store Id")
        val storeId = scanner.nextInt()
        scanner.nextLine()
        print("Enter Mail Id")
        val mail = scanner.nextLine()
        print("Enter number of products Bought")
        val n = scanner.nextInt()

        val products: ArrayList<Product> = ArrayList()
        for (i in 0 until n) {
            print("Enter Product Id")

            val product = searchProduct(scanner.nextInt())

            print("Enter Quantity")
            if (product != null) {
                product.quantity = scanner.nextInt()
                val stock = searchStock(product.id, storeId)
                if (stock?.stock!! > product.quantity && product.quantity > 0) {
                    products.add(product)
                    val a = stock.stock.minus(product.quantity)
                    stock.setterStock(a)
                    updateStockRecord(stock)
                } else {
                    println("asked quantity is not available")
                }
            }
        }
        val id = insert(Billing(0, storeId, products, -1))
        displayBill(id, mail)
    }

    fun updateProductDetails() {
        val scanner = Scanner(System.`in`)
        println("enter product id")
        val p = searchProduct(scanner.nextInt())
        if (p != null) {
            print("Enter choice")
            print(" 1.name 2.type 3.cost 4.info 5.exit")
            when (scanner.nextInt()) {
                1 -> {
                    println("Enter name")
                    p.name = scanner.nextLine()
                }
                2 -> {
                    println("enter type")
                    p.type = scanner.nextLine()
                }
                3 -> {
                    println("Enter Cost")
                    p.cost = scanner.nextInt()
                }
                4 -> {
                    println("Enter info")
                    p.info = scanner.nextLine()
                }

            }
            updateProductRecord(p)
        } else {
            print("Product Not found")
        }
    }

    private fun displayBill(id: Int, mailId: String) {
        val bills = selectBillingRecord()
        var message = """Dear Customer,<br>this is your bill for today's shopping<br>
            <h5>Bill ID=$id</h5>
            <table border=1px><tr><th>Product Name</th><th>Quantity</th><th>Unit Cost</th><th>totals</th></tr>
                """
        for (i in bills) {

            if (i.id == id) {
                println("Bill No:${i.id}")
                println("Store Id:${i.storeId}")
                println("total Amount:${i.amount}")
                println("ProductName Quantity UnitCost Cost")
                for (j in i.productIds) {
                    val p = searchProduct(j.id)
                    if (p != null) {
                        println("${p.name} ${j.quantity} ${j.cost} ${j.quantity * j.cost}")
                        val temp = message
                        message = temp.plus("<tr><td>${p.name}</td><th>${j.quantity}</th><th>${j.cost}</th><th>${j.quantity * j.cost}</th></tr>")
                    }

                }
                val temp = message
                message = temp.plus("<tr><th>  </th>  <th>  </th><th>  </th><th>Amount=${i.amount}</th></tr></table><br>yours sincerely<br>Your Favourite Store ")

                Transport.send(plainMail(message, mailId))
            }
        }
        checkStock()
    }

    fun addStore() {
        val scanner = Scanner(System.`in`)
        println("Enter Store Name")
        val name = scanner.nextLine()
        print("Enter Store Address")
        val address = scanner.nextLine()
        insert(Store(0, name, address, true))


    }

    private fun searchProduct(id: Int): Product? {
        val product = selectProductRecord()
        for (i in product) {
            if (i.id == id && i.continuity) {
                return i
            }
        }
        return null

    }

    private fun searchStore(id: Int): Store? {
        val product = selectStoreRecord()
        for (i in product) {
            if (i.id == id && i.continuity) {
                return i
            }
        }
        return null

    }

    fun deleteStore() {
        val sc = Scanner(System.`in`)
        print("Enter the id")
        val id = sc.nextInt()
        val p = searchStore(id)
        if (p != null) {
            deleteStoreRecord(p)
        }
    }

    fun deleteProduct() {
        val sc = Scanner(System.`in`)
        print("Enter the id")
        val id = sc.nextInt()
        val p = searchProduct(id)
        if (p != null) {
            deleteProductRecord(p)
        }
    }

    fun topPerformingStore() {
        val storeSell = countStoreAmount()
        var value = 0
        var key = 0
        // println("ProductId Count")
        for (i in storeSell) {
            if (i.value >= value) {
                value = i.value
                key = i.key
            }
        }
        val s = searchStore(key)
        if (s != null) {
            println("Store name=" + s.name)
            println("Store Address=" + s.address)
            println("Store Revenue=$value")
        }
    }

    fun checkStock() {
        val stock = selectStockRecord()
        var message = "Dear Admin,<br>"
        for (i in stock) {
            if (i.stock <= 10) {
                val store = searchStore(i.storeId)
                val product = searchProduct(i.productId)
                if (product != null) {
                    if (store != null) {
                        print("Store Name=" + store.name)
                        print(" Store Address=" + store.address)
                        print(" Product Name=" + product.name)
                        println(" stock Remaining=" + i.stock)
                        val temp = message.plus("Store Name=${store.name} Store Address=${store.address} Product Name=${product.name} stock Remaining=${i.stock}<br> ")
                        message = temp
                    }
                }
            }
        }
        val temp = message.plus("<br>your sincerely,<br>Machine")
        Transport.send(plainMail(temp))
    }

    fun eachProductSold() {
        val selling = countBillingProduct()
        println("ProductId Count")
        for (i in selling) {
            println("${i.key}  ${i.value}")
        }

    }

    fun highestSellingProduct() {
        val selling = countBillingProduct()
        var value = 0
        var key = 0
        // println("ProductId Count")
        for (i in selling) {
            if (i.value >= value) {
                value = i.value
                key = i.key
            }
        }
        val p = searchProduct(key)
        if (p != null) {
            println("product name:${p.name}")
            println("Total Sold:$value")
        }


    }
}
