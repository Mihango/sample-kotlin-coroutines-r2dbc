package com.example.sampler2dbc

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table(value = "CUSTOMER")
data class Customer(
        @Id
        @Column(value = "ID")
        var customerId: UUID?,
        @Column(value = "FIRST_NAME")
        val firstName: String,
        @Column(value = "LAST_NAME")
        val lastName: String) : Persistable<UUID> {

    @JsonIgnore
    override fun isNew(): Boolean {
        val new = customerId == null
        if (new) {
            customerId = UUID.randomUUID()
        }
        return new
    }

    @JsonIgnore
    override fun getId(): UUID? = customerId

}

data class Items(
        @Id
        var id: UUID?,
        val name: String,
        val description: String,
        val price: Double)

data class Orders(
        @Id
        var id: UUID?,
        val customerId: UUID)

data class OrderItem(
        @Id
        var id: Int?,
        val itemId: UUID,
        val orderId: UUID)