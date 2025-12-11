package com.example.model

data class Order(
    val title: String,
    val from: String,
    val to: String,
    val price: String,
    val iconRes: Int
)

object OrderRepository {
    val orders = ArrayList<Order>()

    init {
        orders.add(Order("Ke RS Soedono", "SMK 5", "RS Soedono", "Rp15.000", com.example.mojek.R.drawable.ic_motorcycle))
        orders.add(Order("Ke Alun-alun", "Rumah", "Alun-alun", "Rp12.000", com.example.mojek.R.drawable.ic_motorcycle))
    }

    fun addOrder(order: Order) {
        orders.add(0, order) // Add to top
    }

    fun getRecentOrders(): List<Order> {
        return orders.take(3) // Return top 3
    }

    fun getAllOrders(): List<Order> {
        return orders
    }
}