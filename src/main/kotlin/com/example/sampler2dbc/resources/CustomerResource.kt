package com.example.sampler2dbc.resources

import com.example.sampler2dbc.Customer
import com.example.sampler2dbc.services.CustomerService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/customers")
class CustomerResource(
        private val customerService: CustomerService
) {
    @PostMapping
    suspend fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Customer> {
        val createdCustomer = customerService.save(customer)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer)
    }

    @GetMapping
    suspend fun getAllCustomers(): ResponseEntity<Flow<Customer>> =
            ResponseEntity.ok(customerService.getAllCustomers())
}