package com.store.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class StickResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(StocksException::class)
    fun StockNotFound(exception: StocksException): ResponseEntity<Any?> {
        val exceptionResponse = ExceptionResponse(exception.message, LocalDateTime.now())
        return ResponseEntity<Any?>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}