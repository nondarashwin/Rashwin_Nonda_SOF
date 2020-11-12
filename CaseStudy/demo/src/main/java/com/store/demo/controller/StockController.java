package com.store.demo.controller;

import com.store.demo.exception.StocksException;
import com.store.demo.mail.SendMail;
import com.store.demo.model.*;
import com.store.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api")
public class StockController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BilledProductsRepository billedProductsRepository;
    @Autowired
    private BillsRepository billsRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StoresRepository storesRepository;
    SendMail sendMail = new SendMail();

    public void sendMailToAdmin(List<Stock> stocks) {

        String message = "Dear Admin,<br><table border=1px><tr><th>Store Name</th><th>Product Name</th><th>Stock Remaining</th></tr>";
        for (Stock stock : stocks) {
            //System.out.println(stock.getStoreId());
            //System.out.println(storesRepository.findById(stock.getStoreId()).orElseThrow(() -> new StocksException("Store Not Found ")));
            Store store = storesRepository.findById(stock.getStoreId()).orElseThrow(() -> new StocksException("Store Not Found "));
            Product product = productRepository.findById(stock.getProductId()).orElseThrow(() -> new StocksException("Product Not Found"));
            String temp = message + "<tr><td>" + store.getName() + "</td><th>" + product.getName() + "</td><th>" + stock.getStock() + "</th></tr>";
            message= temp;
        }

        sendMail.sendMail("rashwinnonda@gmail.com", "Stock Update", message + "</table><br>your sincerely,<br>Machine");
    }

    public void sendMailToCustomer(Bill bill) {
        Store store = storesRepository.findById(bill.getStoreId()).orElseThrow(() -> new StocksException("Store NotFound"));
        String message = "Dear Customer,<br>this is your bill for today's shopping<br><h5>Bill ID=" + bill.getId() + "/h5><h5>Store Name" + store.getName() + "</h5> <table border=1px><tr><th>Product Name</th><th>Quantity</th><th>Unit Cost</th><th>totals</th></tr>";
        for (BilledProduct billedProduct : bill.getBilledProducts()) {
            String temp = message;
            Product product = productRepository.findById(billedProduct.getProductId()).orElseThrow(() -> new StocksException("Product Not Found"));
            message = temp + "<tr><td>" + product.getName() + "</td><th>" + billedProduct.getQuantity() + "</th><th>" + billedProduct.getCost() + "</th><th>" + (billedProduct.getQuantity() * billedProduct.getCost()) + "</th></tr>";
        }
        sendMail.sendMail(bill.getEmailId(), "Bill", message + "<tr><th>  </th>  <th>  </th><th>  </th><th>Amount=" + bill.getTotalAmount() + "</th></tr></table><br>yours sincerely<br>Your Favourite Store ");

    }

    public double totalAmount(List<BilledProduct> viewBilledProducts){
    double total=0;
    for(BilledProduct viewBilledProduct:viewBilledProducts){
        Product product=productRepository.findById(viewBilledProduct.getProductId()).orElseThrow(()->new StocksException("Product Not Found"));
        total+=(product.getCost()*viewBilledProduct.getQuantity());

    }
    return total;
}
    public void checkStock(List<BilledProduct> viewBilledProducts, int storeID) {
        for (BilledProduct temp : viewBilledProducts) {
            Stock stock = stockRepository.findByCondition(temp.getProductId(), storeID);
            if (stock == null) {
                throw new StocksException("Stock is not available for the given Product");
            }
            if (stock.getStock() < temp.getQuantity()) {
                throw new StocksException("Stock is not available for the given Product");
            }
        }
    }

    @GetMapping(value = "/products")
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @DeleteMapping(value = "/product/id/{id}")
    public ResponseEntity<Product> deleteProducts(@PathVariable int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new StocksException("Product Not found"));
        product.setContinuity(false);
        List<Stock> stocks = stockRepository.findByProductId(product.getId());
        for (Stock stock : stocks) {
            stockRepository.delete(stock);
        }

        return addProduct(product);


    }

    @DeleteMapping(value = "/store/id/{id}")
    public ResponseEntity<Store> deleteStores(@PathVariable int id) {
        Store store = storesRepository.findById(id).orElseThrow(() -> new StocksException("Store Not Found"));

        if (!store.isContinuity()) {
            throw new StocksException("Store Not Found");
        }
        store.setContinuity(false);
        List<Stock> stocks = stockRepository.findByStoreId(store.getId());
        for (Stock stock : stocks) {
            stockRepository.delete(stock);
        }
        return addStore(store);


    }

    @GetMapping(value = "/product/id/{id}")
    public Product retrieveByProducts(@PathVariable int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @GetMapping(value = "/product/name/{name}")
    public List<Product> retrieveProductsByName(@PathVariable String name) {
        return productRepository.findByName(name);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        //product.setContinuity(true);
        //System.out.println(product.toString());
        Product product1 = productRepository.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Response-from", "ProductValue");

        return new ResponseEntity(product1, headers, HttpStatus.OK);
    }

    @GetMapping("/stock/isenough")
    public List<Stock> checkStockAvailability() {
        List<Stock> stocks=stockRepository.findByStock();
        //MailHandler mailHandler=new MailHandler();
        sendMailToAdmin(stocks);
        return stocks;
    }

    @GetMapping(value = "/bills")
    public List<Bill> retrieveAllBills() {
        List<Bill> bills=billsRepository.findAll();

        for(Bill bill:bills){

            List<BilledProduct> billedProducts=billedProductsRepository.findByBillId(bill.getId());
            bill.setBilledProducts(billedProducts);
        }
        return bills;
    }

    @GetMapping(value = "/bill/id/{id}")
    public Bill retrieveBill(@PathVariable int id) {
        Bill bill=billsRepository.findById(id).orElseThrow(()->new StocksException("Bill Id not found"));
        if(bill==null){
            throw new StocksException("Bill Id Not found");
        }

        List<BilledProduct> billedProducts=billedProductsRepository.findByBillId(bill.getId());
        bill.setBilledProducts(billedProducts);
        return bill;

    }

    @GetMapping(value = "/stock")
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping(value = "/stock/store/id/{id}")
    public List<Stock> retrieveStockByStoreId(@PathVariable int id) {
        return stockRepository.findByStoreId(id);
    }

    @GetMapping(value = "/stock/product/id/{id}")
    public List<Stock> retrieveStockByProductId(@PathVariable int id) {
        return stockRepository.findByProductId(id);
    }

    @PostMapping("/stock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {

       // System.out.println(stock.toString());
        if (stock.getStock() < 0) {
            throw new StocksException("stock cant be negative");
        }
        Product product = productRepository.findById(stock.getProductId()).orElseThrow(() -> new StocksException("Product Not Found"));
        if (product == null || !product.isContinuity()) {
            throw new StocksException("Product Not Found");
        }
        Store store = storesRepository.findById(stock.getStoreId()).orElseThrow(() -> new StocksException("Store Not Found"));
        if (store == null || !product.isContinuity()) {
            throw new StocksException("Store Not Found");
        }
        Stock tempStock = stockRepository.findByCondition(stock.getProductId(), stock.getStoreId());
        if (tempStock != null) {
            //System.out.println("not null");
            stockRepository.delete(tempStock);
            stock.setStock(stock.getStock() + tempStock.getStock());
        }

        Stock stock1 = stockRepository.save(stock);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Response-from", "ProductValue");

        return new ResponseEntity(stock1, headers, HttpStatus.OK);
    }



    @GetMapping(value = "/store")
    public List<Store> retrieveAllStores() {
        return storesRepository.findAll();
    }
    @GetMapping(value = "/store/id/{id}")
    public Store retrieveStoresById(@PathVariable int id) {
        return storesRepository.findById(id).orElseThrow(()->new StocksException("Store Not Found"));
    }
    @PostMapping("/store")
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        //store.setContinuity(true);

        //System.out.println(store.toString());
        Store store1 = storesRepository.save(store);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Response-from", "ProductValue");

        return new ResponseEntity(store1, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/store/name/{name}")
    public Store retrieveStoresByName(@PathVariable String name) {
        return storesRepository.findByName(name);
    }


    @PostMapping("/bill")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
        checkStock(bill.getBilledProducts(), bill.getStoreId());
        bill.setTotalAmount((int) totalAmount(bill.getBilledProducts()));
        //Bill bill = new Bill();
        //bill.setStoreId(viewBill.getStoreId());
        //System.out.println(bill.toString());
        //bill.setTotalAmount(viewBill.getAmount());
        //System.out.println(bill.toString());
        Bill bill1 = billsRepository.save(bill);
        bill.setId(bill1.getId());
        List<BilledProduct> billedProducts =bill.getBilledProducts();
        List<BilledProduct> billedProducts1=new ArrayList<>();
        for (BilledProduct temp : billedProducts) {
            Stock stock = stockRepository.findByCondition(temp.getProductId(), bill1.getStoreId());
            if (stock != null || (stock.getStock() - temp.getQuantity()) >= 0) {

                    stockRepository.delete(stock);
                    stock.setStock(stock.getStock() - temp.getQuantity());
                    stockRepository.save(stock);
                Product product=productRepository.findById(stock.getProductId()).orElseThrow(()->new StocksException("Product Not Found"));
                    temp.setCost(product.getCost());
                    billedProducts1.add(temp);
                    billedProductsRepository.save(temp);

            } else {
                //billsRepository.delete(bill1);
                throw new StocksException("Stock is Not available");
            }

        }
        bill1.setBilledProducts(billedProducts1);
       sendMailToCustomer(bill1);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Response-from", "ProductValue");

        return new ResponseEntity(bill1, headers, HttpStatus.OK);
    }
}
