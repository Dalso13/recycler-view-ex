package com.jdw.listview_second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter(val items: MutableList<ListViewModel>): RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listview_item, parent, false)

        return ViewHolder(view)
    }
    // 전체 리사이클러뷰의 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : ListViewModel) {
            val rvText = itemView.findViewById<TextView>(R.id.listviewItem)

            rvText.text = item.text
        }
    }

    interface  ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    // viewbinding 작업 수행
    override fun onBindViewHolder(holder: ListViewAdapter.ViewHolder, position: Int) {

        if(itemClick != null) {
            holder.itemView.setOnClickListener {
                v -> itemClick?.onClick(v, position)
            }
        }

        holder.bindItems(items[position])
    }

}