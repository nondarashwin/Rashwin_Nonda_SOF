package controller

import service.Admin
import doa.connectionClose
import doa.getConnection1
import java.util.*

fun main(){
    val viewAdmin=Admin()
    val sc=Scanner(System.`in`)
    var flag=true
    while(flag){
        println("1.Add Product \n2.Delete Product \n3.Update Product \n4.Add Store \n5.Delete Store \n6.update store details \n7.Add stock \n8.Update stock \n9.Check stock Availability \n10.bill \n11.display all product \n12.Total Sale Of Each product  \n13.highest selling product \n14.top performing store\n15.exit\n")
        val choice=sc.nextInt()
        getConnection1()
        when(choice){
            1->viewAdmin.addProduct()
            2->viewAdmin.deleteProduct()
            3->viewAdmin.updateProductDetails()
            4->viewAdmin.addStore()
            5->viewAdmin.deleteStore()
            6->viewAdmin.updateStoreDetails()
            7->viewAdmin.addStock()
            8->viewAdmin.updateStock()
            9->viewAdmin.checkStock()
            10->viewAdmin.billing()
            11->viewAdmin.displayAllProducts()
            12->viewAdmin.eachProductSold()
            13->viewAdmin.highestSellingProduct()
            14-> viewAdmin.topPerformingStore()
            else->flag=false
        }
connectionClose()
    }
}