package com.example.gmzucolo.appconsultingapigit.features.repositories.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.databinding.ItemRepositoryListBinding
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.Repository

class ListRepositoryAdapter(
    private val listener: RepositoryItemListener
) : RecyclerView.Adapter<ListRepositoryAdapter.RepositoryViewHolder>() {

    private val repositoryList = ArrayList<Repository>()

    fun addRepositoryItems(repositoryList: List<Repository>) {
        this.repositoryList.addAll(repositoryList)
        notifyDataSetChanged()
    }

    interface RepositoryItemListener {
        fun onClickedRepository(repository: Repository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding: ItemRepositoryListBinding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holderRepository: RepositoryViewHolder, position: Int) {
        holderRepository.binding(repositoryList[position])
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }


    inner class RepositoryViewHolder(
        private val itemBiding: ItemRepositoryListBinding,
        private val listener: RepositoryItemListener
    ) : RecyclerView.ViewHolder(itemBiding.root), View.OnClickListener {

        private lateinit var repository: Repository

        init {
            itemBiding.root.setOnClickListener(this)
        }

        fun binding(item: Repository) = with(itemBiding) {
            repository = item
            appCompatTextViewRepositoryName.text = item.name
            appCompatTextViewRepositoryDescription.text = item.description
            appCompatTextViewPullRequestUserName.text = item.owner.login
            appCompatTextViewRepositoryNumberForks.text = item.forksCount.toString()
            appCompatTextViewRepositoryStars.text = item.stargazersCount.toString()
        }

        override fun onClick(view: View?) {
            listener.onClickedRepository(repository)
        }
    }
}

