package com.example.attheshop

object EndPoints {
    //Connects to the database, Please change the IP to your own IPv4 Address
    private val URL_ROOT = "http://192.168.0.139/AtTheShop/"
    val URL_GETDATA = URL_ROOT + "index.php"
    val URL_GETORDER1 = URL_ROOT + "ordre_1.php"
    val URL_GETORDER2 = URL_ROOT + "order_2.php"
}