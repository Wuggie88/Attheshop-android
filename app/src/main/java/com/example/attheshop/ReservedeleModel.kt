package com.example.attheshop

import android.provider.BaseColumns

// constructors for creating database items
class ReservedeleModel {

    var id: Int = 0
    var productName: String? = null
    var quantity: Int = 0

    constructor(id: Int, productname: String, quantity: Int) {
        this.id = id
        this.productName = productname
        this.quantity = quantity
    }

    constructor(productname: String, quantity: Int) {
        this.productName = productname
        this.quantity = quantity
    }


}