package com.example.sampler2dbc

import java.util.*

data class Customer(var id: UUID?, val firstName: String, val lastName: String)

data class Items(var id: UUID?,val name: String, val description: String, val price: Double)

data class Orders(var id: UUID?, val customerId: UUID)

data class OrderItem(var id: Int?, val itemId: UUID, val orderId: UUID)