package com.stores.stock.controller;

import com.stores.stock.model.*;
import com.stores.stock.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class StockController {
    @Autowired
    private Environment env;
    ProductRepository productRepository;
    //BillsRepository billsRepository;
    //StockRepository stockRepository;
    //StoresRepository storesRepository;
    //BilledProductsRepository billedProductsRepository;
    @GetMapping(value="/products")
    public List<Product> retreiveAllProducts(){
    return productRepository.findAll();

}
   /* @GetMapping(value="/bill")
    public List<Bill> retreiveAllBill(){
        return billsRepository.findAll();}
    @GetMapping(value="/stock")
    public List<Stock> retreiveAllStock(){
        return stockRepository.findAll();}
    @GetMapping(value="/store")
    public List<Store> retreiveAllStore(){
        return storesRepository.findAll();}
    @GetMapping(value="/billproduct")
    public List<BilledProduct> retreiveAllBilledProduct(){
        return billedProductsRepository.findAll();}*/
}
