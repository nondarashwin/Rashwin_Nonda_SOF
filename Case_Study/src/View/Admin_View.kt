package View

import Controller.Admin
import doa.connectionClose
import doa.getConnection1
import java.util.*

fun main(){
    var view_admin=Admin()
    var sc=Scanner(System.`in`)
    var flag=true
    while(flag){
        println(" 1.Add Product \n 2.Add Store \n 3.Check Stock Availability \n 4.Update Stock \n 5.Add Stock \n 6.bill \n 7.display all product \n 8.Total Sale Of Each product \n 9.update Product \n 10.update store details\n 11.highest selling product \n 12.exit\n")
        var choice=sc.nextInt()
        getConnection1()
        when(choice){

            1->view_admin.AddProduct()
            2->view_admin.AddStore()
            3->view_admin.checkStock()
            4->view_admin.updateStock()
            5->view_admin.addStock()
            6->view_admin.billing()
            7->view_admin.displayAllProducts()
            8->view_admin.eachProductSold()
            9->view_admin.updateProductDetails()
            10->view_admin.updateStoreDetails()
            11->view_admin.highestSellingProduct()
            else->flag=false
        }
connectionClose()
    }
}