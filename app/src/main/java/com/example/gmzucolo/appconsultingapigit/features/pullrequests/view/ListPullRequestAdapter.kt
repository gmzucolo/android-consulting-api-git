package com.example.gmzucolo.appconsultingapigit.features.pullrequests.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.R
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.model.PullRequest

class ListPullRequestAdapter(
    private val listPullRequest: MutableList<PullRequest>
) : RecyclerView.Adapter<ListPullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pull_request_list, parent, false)
        return PullRequestViewHolder(view)
    }

    override fun onBindViewHolder(holderPullRequest: PullRequestViewHolder, position: Int) {
        holderPullRequest.bindView(listPullRequest[position])
    }

    override fun getItemCount(): Int {
        return listPullRequest.size
    }


    inner class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pullrequest: PullRequest) {
            with(pullrequest) {
                val mTitle = itemView.findViewById<TextView>(R.id.appCompatTextViewPullRequestTitle)
                mTitle.text = title.first().toString()
            }
        }
    }
}