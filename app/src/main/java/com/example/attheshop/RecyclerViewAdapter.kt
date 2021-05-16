package com.example.attheshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter  internal constructor(context: Context?, data: List<String>, data2: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val mData: List<String> // Data der skal fyldes.
    private val mData2: List<String>
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data // constuerer data
        mData2 = data2
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mData[position]
        holder.myTextView.text = animal //tilføjer data til rows i recyclerview
        val sounds = mData2[position]
        holder.mySounds.text = sounds
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var myTextView: TextView
        var mySounds: TextView

        init {
            myTextView = itemView.findViewById(R.id.firstRow)
            mySounds = itemView.findViewById(R.id.secondRow)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            @Suppress("DEPRECATION")
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }
    }

    // convenience method for getting data at click position
    fun getItem(id: Int): String {
        return mData[id]
    }

    // allows clicks events to be caught
    // Needs to be able to change between multiple listeners depending on activity
    fun setClickListener(itemClickListener: Biler) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}