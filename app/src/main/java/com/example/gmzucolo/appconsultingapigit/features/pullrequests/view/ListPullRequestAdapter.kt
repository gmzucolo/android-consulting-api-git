package com.example.gmzucolo.appconsultingapigit.features.pullrequests.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.databinding.ItemPullRequestListBinding
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.PullRequest

class ListPullRequestAdapter(
    private val listener: PullRequestItemListener
) : RecyclerView.Adapter<ListPullRequestAdapter.PullRequestViewHolder>() {

    private val pullRequestList = ArrayList<PullRequest>()

    fun addPullRequestItems(pullRequestList: List<PullRequest>) {
        this.pullRequestList.addAll(pullRequestList)
        notifyDataSetChanged()
    }

    interface PullRequestItemListener {
        fun onClickedPullRequest(pullrequest: PullRequest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val binding: ItemPullRequestListBinding =
            ItemPullRequestListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PullRequestViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holderPullRequest: PullRequestViewHolder, position: Int) {
        holderPullRequest.binding(pullRequestList[position])
    }

    override fun getItemCount(): Int {
        return pullRequestList.size
    }


    inner class PullRequestViewHolder(
        private val itemBinding: ItemPullRequestListBinding,
        private val listener: PullRequestItemListener
    ) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        private lateinit var pullrequest: PullRequest

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun binding(item: PullRequest) = with(itemBinding) {
            pullrequest = item
            appCompatTextViewPullRequestTitle.text = item.title
            appCompatTextViewPullRequestDescription.text = item.description
            appCompatTextViewPullRequestUserName.text = item.username.toString()
        }

        override fun onClick(view: View?) {
            listener.onClickedPullRequest(pullrequest)
        }
    }
}