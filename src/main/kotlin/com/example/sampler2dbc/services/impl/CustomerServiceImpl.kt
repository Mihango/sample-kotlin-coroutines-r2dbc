package com.example.sampler2dbc.services.impl

import com.example.sampler2dbc.Customer
import com.example.sampler2dbc.CustomerRepository
import com.example.sampler2dbc.services.CustomerService
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl(
        private val customerRepository: CustomerRepository
) : CustomerService {
    override suspend fun save(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    override suspend fun findCustomer(id: UUID): Customer? {
        return customerRepository.findById(id)
    }

    override suspend fun getAllCustomers(): Flow<Customer> {
        return customerRepository.findAll()
    }
}