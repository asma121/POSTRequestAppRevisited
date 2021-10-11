package com.example.postrequestapprevisited

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class myAdapter(private val users:ArrayList<ArrayList<String>>): RecyclerView.Adapter<myAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val userid= users[position][0]
        val username= users[position][1]
        val userlocation= users[position][2]
        holder.itemView.apply {
            tvid.text= userid
            tvname.text= username
            tvloction.text= userlocation
        }
    }

    override fun getItemCount()=users.size
}