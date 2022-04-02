package com.example.gmzucolo.appconsultingapigit.features.repositories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.R
import com.example.gmzucolo.appconsultingapigit.features.repositories.model.Repository

class ListRepositoryAdapter(
    private val listRepositories: MutableList<Repository>
) : RecyclerView.Adapter<ListRepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repository_list, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holderRepository: RepositoryViewHolder, position: Int) {
        holderRepository.bindView(listRepositories[position])
    }

    override fun getItemCount(): Int {
        return listRepositories.size
    }


    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(repository: Repository) {
            with(repository) {
                val mTitle = itemView.findViewById<TextView>(R.id.appCompatTextViewRepositoryTitle)
                mTitle.text = title.first().toString()
            }
        }
    }
}
