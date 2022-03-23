package com.example.gmzucolo.appconsultingapigit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListRepositoryAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private var titles = arrayOf(
        "gustavo 1",
        "gustavo 1",
        "gustavo 1",
        "gustavo 1",
        "gustavo 1",
        "gustavo 1",
        "gustavo 1",
        "gustavo 1"
    )
    private var descriptions = arrayOf(
        "lalalalalalala",
        "lalalalalalala",
        "lalalalalalala",
        "lalalalalalala",
        "lalalalalalala",
        "lalalalalalala",
        "lalalalalalala",
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDescription.text = descriptions[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemTitle: TextView = itemView.findViewById(R.id.appCompatTextViewRepositoryTitle)
    var itemDescription: TextView =
        itemView.findViewById(R.id.appCompatTextViewRepositoryDescription)

}
