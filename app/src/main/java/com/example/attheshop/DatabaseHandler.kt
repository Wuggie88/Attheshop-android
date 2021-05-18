package com.example.attheshop

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues

class DatabaseHandler(context: Context, name: String?,
                      factory: SQLiteDatabase.CursorFactory?, version: Int) :
        SQLiteOpenHelper(context, DATABASE_NAME,
                factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_PRODUCTNAME
                + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS)
        onCreate(db)
    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "lagerliste.db"
        val TABLE_PRODUCTS = "reservedele"

        val COLUMN_ID = "_id"
        val COLUMN_PRODUCTNAME = "productname"
        val COLUMN_QUANTITY = "quantity"
    }

    fun addProduct(product: ReservedeleModel) {

        val values = ContentValues()
        values.put(COLUMN_PRODUCTNAME, product.productName)
        values.put(COLUMN_QUANTITY, product.quantity)

        val db = this.writableDatabase

        db.insert(TABLE_PRODUCTS, null, values)
        db.close()
    }

    fun findProduct(productname: String): ReservedeleModel? {
        val query =
                "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME =  \"$productname\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var product: ReservedeleModel? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val name = cursor.getString(1)
            val quantity = Integer.parseInt(cursor.getString(2))
            product = ReservedeleModel(id, name, quantity)
            cursor.close()
        }

        db.close()
        return product
    }

    fun deleteProduct(productname: String): Boolean {

        var result = false

        val query =
                "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME = \"$productname\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            val id = Integer.parseInt(cursor.getString(0))
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                    arrayOf(id.toString()))
            cursor.close()
            result = true
        }
        db.close()
        return result
    }

    fun findAll(): ArrayList<ReservedeleModel> {
        val query =
            "SELECT * FROM $TABLE_PRODUCTS"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var product: ReservedeleModel? = null

        val productList: ArrayList<ReservedeleModel> = ArrayList()
        /*
        val idList: ArrayList<Int> = ArrayList()
        val nameList: ArrayList<String> = ArrayList()
        val quantityList: ArrayList<Int> = ArrayList()
        */
        if (cursor.moveToFirst()) {
            do {
                /*
                idList.add(Integer.parseInt(cursor.getString(0)))
                nameList.add(cursor.getString(1))
                quantityList.add(Integer.parseInt(cursor.getString(2)))
                */
                val id = Integer.parseInt(cursor.getString(0))
                val name = cursor.getString(1)
                val quantity = Integer.parseInt(cursor.getString(2))
                product = ReservedeleModel(id, name, quantity)
                productList.add(product)

            } while (cursor.moveToNext())


            cursor.close()
        }

        db.close()
        return productList
    }


}
