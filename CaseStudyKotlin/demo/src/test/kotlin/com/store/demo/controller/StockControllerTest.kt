package com.store.demo.controller

import com.store.demo.model.*
import com.store.demo.repository.*
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.stubbing.OngoingStubbing
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*
@SpringBootTest
internal class StockControllerTest {
    @InjectMocks
    var stockController: StockController? = null

    @MockBean
    var billedProductsRepository: BilledProductsRepository? = null

    @MockBean
    var billsRepository: BillsRepository? = null

    @MockBean
    var productRepository: ProductRepository? = null

    @MockBean
    var stockRepository: StockRepository? = null

    @MockBean
    var storesRepository: StoresRepository? = null
    //@Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }



    @Test
    fun addProduct() {
        val product = Product(1, "laptop", "electronics", "8gb RAM", 123, true)

        val responseEntity: ResponseEntity<Any?> = stockController!!.addProduct(product)
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
    }

    @Test
    fun addStore() {
        val store = Store(1, "nomore", "Tehran", true)
        val responseEntity: ResponseEntity<Any?> = stockController!!.addStore(store)
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
    }


}



private fun <T> OngoingStubbing<T>.thenReturn(store: Store): Store {
   return Store(1, "nomore", "Tehran", true)
}


