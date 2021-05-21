package com.example.attheshop

object EndPoints {
    //Connects to the database, Please change the IP to your own IPv4 Address
    val URL_ROOT = "http://192.168.0.139/AtTheShop/"
    val URL_GETDATA = URL_ROOT + "index.php"
    val URL_GETORDER1 = URL_ROOT + "ordre_1.php"
    val URL_GETORDER2 = URL_ROOT + "order_2.php"
    val URL_GETKUNDER1 = URL_ROOT + "kunder_1.php"
    val URL_GETBILER1 = URL_ROOT + "biler_1.php"
}