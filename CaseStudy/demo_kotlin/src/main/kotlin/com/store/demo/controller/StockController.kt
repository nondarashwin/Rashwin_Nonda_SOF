package com.store.demo.controller

import com.store.demo.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.store.demo.DemoApplication.*
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
    var sendMail: SendMail = SendMail()
    fun sendMailToAdmin(stocks: List<Stock?>) {
        var message = "Dear Admin,<br><table border=1px><tr><th>Store Name</th><th>Product Name</th><th>Stock Remaining</th></tr>"
        for (stock in stocks) {
            val store: Store = storesRepository.findById(stock.storeId).orElseThrow({ StocksException("Store Not Found ") })
            val product: Product = productRepository.findById(stock.productId).orElseThrow({ StocksException("Product Not Found") })
            val temp = message + "<tr><td>" + store.name + "</td><th>" + product.name + "</td><th>" + stock.stock + "</th></tr>"
            message = temp
        }
        sendMail.sendMail("rashwinnonda@gmail.com", "Stock Update", "$message</table><br>your sincerely,<br>Machine")
    }
    fun sendMailToCustomer(bill: Bill) {
        val store: Store = storesRepository.findById(bill.storeId).orElseThrow({ StocksException("Store NotFound") })
        var message = "Dear Customer,<br>this is your bill for today's shopping<br><h5>Bill ID=" + bill.id + "/h5><h5>Store Name" + store.name + "</h5> <table border=1px><tr><th>Product Name</th><th>Quantity</th><th>Unit Cost</th><th>totals</th></tr>"
        for (billedProduct in bill.getBilledProducts()) {
            val temp = message
            val product: Product = productRepository.findById(billedProduct.productId).orElseThrow({ StocksException("Product Not Found") })
            message = temp + "<tr><td>" + product.name + "</td><th>" + billedProduct.quantity + "</th><th>" + billedProduct.cost + "</th><th>" + billedProduct.quantity * billedProduct.cost + "</th></tr>"
        }
        sendMail.sendMail(bill.emailId, "Bill", message + "<tr><th>  </th>  <th>  </th><th>  </th><th>Amount=" + bill.totalAmount + "</th></tr></table><br>yours sincerely<br>Your Favourite Store ")
    }
    open  fun totalAmount(viewBilledProducts: kotlin.collections.List<BilledProduct?>): kotlin.Double{
        val total: kotlin.Double = 0.0
        for (  viewBilledProduct: BilledProduct? in viewBilledProducts) {
            val product: Product? = productRepository.findById(viewBilledProduct.productId).orElseThrow({StocksException("Product Not Found")})
            total += (product.cost * viewBilledProduct.quantity).toDouble()
        }
        return total
    }
    open  fun checkStock(viewBilledProducts: kotlin.collections.List<BilledProduct?>, storeID: Int){
        for (  temp: BilledProduct? in viewBilledProducts) {
            val stock: Stock? = stockRepository.findByCondition(temp.productId, storeID)
            if (stock == null){
                throw StocksException("Stock is not available for the given Product")
            }
            if (stock.stock < temp.quantity){
                throw StocksException("Stock is not available for the given Product")
            }
        }
    }
    /*@DeleteMapping(value = "/product/id/{id}")
    public ResponseEntity<Product> deleteProducts(@PathVariable int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new StocksException("Product Not found"));
        product.setContinuity(false);
        List<Stock> stocks = stockRepository.findByProductId(product.getId());
        for (Stock stock : stocks) {
            stockRepository.delete(stock);
        }

        return addProduct(product);


    }*/
    @DeleteMapping(value = "/product/id/{id}")
    fun delecteProducts(@Pathvariable id:Int):ResponseEntity<Product>{
        product:Product= productRepository.findById(id).orElseThrow(()->new StocksException("Product Not found"))

    }
    @GetMapping("/products")
    fun retriveAllProducts():List<Product>{
        return productRepositorty.findAll();
    }

}