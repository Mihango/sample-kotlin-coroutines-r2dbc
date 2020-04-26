package com.example.sampler2dbc.services

import com.example.sampler2dbc.Customer
import kotlinx.coroutines.flow.Flow
import java.util.*

interface CustomerService {
    suspend fun save(customer: Customer): Customer
    suspend fun findCustomer(id: UUID): Customer?
    suspend fun getAllCustomers(): Flow<Customer>
}