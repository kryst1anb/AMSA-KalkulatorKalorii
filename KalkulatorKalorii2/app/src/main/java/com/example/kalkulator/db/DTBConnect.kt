package com.example.kalkulator.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

class DTBConnect(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        internal const val DATABASE_NAME = "Product_DB"
        internal const val DATABASE_VERSION = 1
        internal const val TABLE_NAME = "Products"
        internal const val COL_ID = "Id"
        internal const val COL_NAME = "Name"
        internal const val COL_KCAL = "Kcal"
        internal const val COL_FAT = "Fat"
        internal const val COL_PROTEIN = "Protein"
        internal const val COL_CARBO = "Carbo"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = db!!.execSQL("CREATE TABLE $TABLE_NAME( " +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME TEXT," +
                "$COL_KCAL DOUBLE," +
                "$COL_FAT DOUBLE," +
                "$COL_PROTEIN DOUBLE," +
                "$COL_CARBO DOUBLE)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun getYourProducts(): MutableList<Product>{
        val query = "SELECT * FROM $TABLE_NAME"

        val db = this.writableDatabase
        val cursor = db.rawQuery(query,null,null)
        val yourproducts = mutableListOf<Product>()

        while (cursor.moveToNext())
        {
            val product_id = Integer.parseInt(cursor.getString(0))
            val product_name = (cursor.getString(1))
            val product_kcal = (cursor.getDouble(2))
            val product_fat = (cursor.getDouble(3))
            val product_protein = (cursor.getDouble(4))
            val product_carbo = (cursor.getDouble(5))

            val product = Product(product_id, product_name, product_kcal, product_fat, product_protein, product_carbo)

            yourproducts.add(product)
        }
        cursor.close()
        db.close()
        return yourproducts
    }

    fun deleteFromYourProducts(productid: Int) {
        val db = this.writableDatabase
        db!!.execSQL("DELETE FROM $TABLE_NAME WHERE $COL_ID = \"$productid\" ")
        db.close()
    }

    fun addToYourProducts(product: Product){

        val values = ContentValues()
        values.put(COL_NAME, product.name)
        values.put(COL_KCAL, product.kcal)
        values.put(COL_FAT, product.fat)
        values.put(COL_PROTEIN, product.protein)
        values.put(COL_CARBO, product.carbo)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun checkYourProducts(name: String):Int{
        val db = readableDatabase
        val cursor = db.query(TABLE_NAME, arrayOf(COL_ID),"$COL_NAME = ?", arrayOf(name),null,null,null,null)

        if(cursor.count>0){
            cursor.moveToFirst()
            val id = cursor.getInt(0)
            cursor.close()
            return id
        }else{
            cursor.close()
            return -1
        }
    }
}