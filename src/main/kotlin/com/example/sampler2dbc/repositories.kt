package com.example.sampler2dbc

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface CustomerRepository : CoroutineCrudRepository<Customer, UUID>

interface ItemsRepository : CoroutineCrudRepository<Items, UUID>

interface OrdersRepository : CoroutineCrudRepository<Orders, UUID>

interface OrderItemRepository : CoroutineCrudRepository<OrderItem, Int>