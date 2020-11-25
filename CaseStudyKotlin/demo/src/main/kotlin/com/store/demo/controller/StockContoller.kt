package com.store.demo.controller

import com.store.demo.exception.StocksException
import com.store.demo.mail.SendMail
import com.store.demo.model.*
import com.store.demo.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@EnableAutoConfiguration
@RestController
@RequestMapping("/api")
class StockController {
    @Autowired
    private val productRepository: ProductRepository? = null

    @Autowired
    private val billedProductsRepository: BilledProductsRepository? = null

    @Autowired
    private val billsRepository: BillsRepository? = null

    @Autowired
    private val stockRepository: StockRepository? = null

    @Autowired
    private val storesRepository: StoresRepository? = null
    var sendMail = SendMail()
    fun sendMailToAdmin(stocks: List<Stock>?) {
        var message = "Dear Admin,<br><table border=1px><tr><th>Store Name</th><th>Product Name</th><th>Stock Remaining</th></tr>"
        if (stocks != null) {
            for (stock in stocks) {
                //System.out.println(stock.getStoreId());
                //System.out.println(storesRepository.findById(stock.getStoreId()).orElseThrow(() -> new StocksException("Store Not Found ")));
                val store: Store? = storesRepository?.findById(stock.storeId)?.orElseThrow({ StocksException("Store Not Found ") })
                val product: Product? = productRepository?.findById(stock.productId)?.orElseThrow({ StocksException("Product Not Found") })
                val temp = message + "<tr><td>" + (store?.name ?:"") + "</td><th>" + (product?.name ?: " ") + "</td><th>" + stock.stock + "</th></tr>"
                message = temp
            }
        }
        sendMail.sendMail("rashwinnonda@gmail.com", "Stock Update", "$message</table><br>your sincerely,<br>Machine")
    }

    fun sendMailToCustomer(bill: Bill) {
        val emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"

        val store: Store? = storesRepository?.findById(bill.storeId)?.orElseThrow({ StocksException("Store NotFound") })
        var message = "Dear Customer,<br>this is your bill for today's shopping<br><h5>Bill ID=" + bill.id + "/h5><h5>Store Name" + (store?.name
                ?: "") + "</h5> <table border=1px><tr><th>Product Name</th><th>Quantity</th><th>Unit Cost</th><th>totals</th></tr>"
        for (billedProduct in bill.getBilledProducts()) {
            val temp = message
            val product: Product? = productRepository?.findById(billedProduct.productId)?.orElseThrow({ StocksException("Product Not Found") })
            if (product != null) {
                message = temp + "<tr><td>" + product.name + "</td><th>" + billedProduct.quantity + "</th><th>" + billedProduct.cost + "</th><th>" + billedProduct.quantity * billedProduct.cost + "</th></tr>"
            }
        }
        sendMail.sendMail(bill.emailId!!, "Bill", message + "<tr><th>  </th>  <th>  </th><th>  </th><th>Amount=" + bill.totalAmount + "</th></tr></table><br>yours sincerely<br>Your Favourite Store ")
    }

    fun totalAmount(viewBilledProducts: List<BilledProduct>): Double {
        var total = 0.0



                for (viewBilledProduct in viewBilledProducts) {

                    val product: Product? = productRepository?.findById(viewBilledProduct.productId)?.orElseThrow({ StocksException("Product Not Found") })
                    if(product!=null){
                    total += (product.cost * viewBilledProduct.quantity).toDouble()}
                }



        return total
    }

    fun checkStock(viewBilledProducts: List<BilledProduct>, storeID: Int) {
        for (temp in viewBilledProducts) {
            val stock: Stock = stockRepository?.findByCondition(temp.productId, storeID)
                    ?: throw StocksException("Stock is not available for the given Product")
            if (stock.stock < temp.quantity) {
                throw StocksException("Stock is not available for the given Product")
            }
        }
    }

    @GetMapping(value = ["/products"])
    fun retrieveAllProducts(): MutableList<Product?>? {
        if (productRepository != null) {
            return productRepository.findAll()
        }
        return null;
    }

    @DeleteMapping(value = ["/product/id/{id}"])
    fun deleteProducts(@PathVariable id: Int): ResponseEntity<Any?> {
        val product: Product? = productRepository?.findById(id)?.orElseThrow({ StocksException("Product Not found") })
        if (product != null) {
            product.continuity = false
        }
        val stocks: List<Stock?>? = product?.id?.let { stockRepository?.findByProductId(it) }
        if (stocks != null) {
            for (stock in stocks) {
                if (stock != null) {
                    if (stockRepository != null) {
                        stockRepository.delete(stock)
                    }
                }
            }
        }
        return addProduct(product)
    }

    @DeleteMapping(value = ["/store/id/{id}"])
    fun deleteStores(@PathVariable id: Int): ResponseEntity<Any?> {
        val store: Store? = storesRepository?.findById(id)?.orElseThrow({ StocksException("Store Not Found") })
        if (store != null) {
            if (!store.continuity) {
                throw StocksException("Store Not Found")
            }
        }
        if (store != null) {
            store.continuity = false
        }
        val stocks: List<Stock?>? = store?.id?.let { stockRepository?.findByStoreId(it) }
        if (stocks != null) {
            for (stock in stocks) {
                if (stockRepository != null) {
                    if (stock != null) {
                        stockRepository.delete(stock)
                    }
                }
            }
        }
        return addStore(store)
    }

    @GetMapping(value = ["/product/id/{id}"])
    fun retrieveByProducts(@PathVariable id: Int): Product? {

            return productRepository?.findById(id)?.orElseThrow()

    }

    @GetMapping(value = ["/product/name/{name}"])
    fun retrieveProductsByName(@PathVariable name: String?): List<Product?>? {
        return productRepository?.findByName(name)
    }

    @PostMapping("/product")
    fun addProduct(@RequestBody product: Product?): ResponseEntity<Any?> {
        //product.setContinuity(true);
        //System.out.println(product.toString());
        val product1: Product? = product?.let { productRepository?.save(it) }
        val headers = HttpHeaders()
        headers.add("Response-from", "ProductValue")
        return ResponseEntity<Any?>(product1, headers, HttpStatus.OK)
    }

    @GetMapping("/stock/isenough")
    fun checkStockAvailability(): List<Stock?>? {
        val stocks: List<Stock?>? = stockRepository?.findByStock()
        //MailHandler mailHandler=new MailHandler();
        sendMailToAdmin(stocks as List<Stock>?)
        return stocks
    }

    @GetMapping(value = ["/bills"])
    fun retrieveAllBills(): List<Bill?>? {
        val bills: List<Bill?>? = billsRepository?.findAll()
        if (bills != null) {
            for (bill in bills) {
                val billedProducts: List<BilledProduct?>? = bill?.id?.let { billedProductsRepository?.findByBillId(it) }
                if (bill != null) {
                    bill.setBilledProducts(billedProducts as List<BilledProduct>)
                }
            }
        }
        return bills
    }

    @GetMapping(value = ["/bill/id/{id}"])
    fun retrieveBill(@PathVariable id: Int): Bill {
        val bill: Bill = billsRepository?.findById(id)?.orElseThrow({ StocksException("Bill Id not found") })
                ?: throw StocksException("Bill Id Not found")
        val billedProducts: List<BilledProduct?>? = billedProductsRepository?.findByBillId(bill.id)
        bill.setBilledProducts(billedProducts as List<BilledProduct>)
        return bill
    }

    @GetMapping(value = ["/stock"])
    fun retrieveAllStocks(): List<Stock?>? {
        return stockRepository?.findAll()
    }

    @GetMapping(value = ["/stock/store/id/{id}"])
    fun retrieveStockByStoreId(@PathVariable id: Int): List<Stock?>? {
        return stockRepository?.findByStoreId(id)
    }

    @GetMapping(value = ["/stock/product/id/{id}"])
    fun retrieveStockByProductId(@PathVariable id: Int): List<Stock?>? {
        return stockRepository?.findByProductId(id)
    }

    @PostMapping("/stock")
    fun addStock(@RequestBody stock: Stock): ResponseEntity<Any?> {

        // System.out.println(stock.toString());
        if (stock.stock < 0) {
            throw StocksException("stock cant be negative")
        }
        val product: Product? = productRepository?.findById(stock.productId)?.orElseThrow({ StocksException("Product Not Found") })
        if (product == null || !product.continuity) {
            throw StocksException("Product Not Found")
        }
        val store: Store? = storesRepository?.findById(stock.storeId)?.orElseThrow({ StocksException("Store Not Found") })
        if (store == null || !product.continuity) {
            throw StocksException("Store Not Found")
        }
        val tempStock: Stock? = stockRepository?.findByCondition(stock.productId, stock.storeId)
        if (tempStock != null) {
            //System.out.println("not null");
            stockRepository?.delete(tempStock)
            stock.stock = stock.stock + tempStock.stock
        }
        val stock1: Stock? = stockRepository?.save(stock)
        val headers = HttpHeaders()
        headers.add("Response-from", "ProductValue")
        return ResponseEntity<Any?>(stock1, headers, HttpStatus.OK)
    }

    @GetMapping(value = ["/store"])
    fun retrieveAllStores(): MutableList<Store?>? {
        return storesRepository?.findAll()
    }

    @GetMapping(value = ["/store/id/{id}"])
    fun retrieveStoresById(@PathVariable id: Int): Store? {
        return storesRepository?.findById(id)?.orElseThrow({ StocksException("Store Not Found") })
    }

    @PostMapping("/store")
    fun addStore(@RequestBody store: Store?): ResponseEntity<Any?> {

        val store1: Store? = store?.let { storesRepository?.save(it) }
        val headers = HttpHeaders()
        headers.add("Response-from", "ProductValue")
        return ResponseEntity<Any?>(store1, headers, HttpStatus.OK)
    }

    @GetMapping(value = ["/store/name/{name}"])
    fun retrieveStoresByName(@PathVariable name: String?): List<Store?>? {
        return storesRepository?.findByName(name)
    }

    @PostMapping("/bill")
    fun addBill(@RequestBody bill: Bill): ResponseEntity<Any?> {
        /*String emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
       if (!bill.getEmailId().matches(emailPattern)) {
            //throw new StocksException("Emailid is not valid");
            return;
        }*/
        checkStock(bill.getBilledProducts(), bill.storeId)
        bill.totalAmount = totalAmount(bill.getBilledProducts()).toInt()

        val bill1: Bill? = billsRepository?.save(bill)
        if (bill1 != null) {
            print(bill1.id)
            bill.id = bill1.id
        }
        val billedProducts = bill.getBilledProducts()
        val billedProducts1: MutableList<BilledProduct> = ArrayList()
        for (temp in billedProducts) {
            val stock: Stock? = bill1?.storeId?.let { stockRepository?.findByCondition(temp.productId, it) }
            if (stock != null) {
                if (stock.stock - temp.quantity >= 0) {
                    stockRepository?.delete(stock)
                    stock.stock = stock.stock - temp.quantity
                    stockRepository?.save(stock)
                    val product: Product? = productRepository?.findById(stock.productId)?.orElseThrow({ StocksException("Product Not Found") })
                    if (product != null) {
                        temp.cost = product.cost
                    }
                    temp.billId=bill.id
                    billedProducts1.add(temp)
                    print(temp)
                    billedProductsRepository?.save(temp)
                } else {

                    throw StocksException("Stock is Not available")
                }
            }
        }
        bill1?.setBilledProducts(billedProducts1)
        if (bill1 != null) {
            sendMailToCustomer(bill1)
        }
        val headers = HttpHeaders()
        headers.add("Response-from", "ProductValue")
        return ResponseEntity<Any?>(bill1, headers, HttpStatus.OK)
    }
}