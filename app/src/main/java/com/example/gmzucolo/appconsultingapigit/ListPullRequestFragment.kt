package com.example.gmzucolo.appconsultingapigit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gmzucolo.appconsultingapigit.model.PullRequest
import layout.ListPullRequestAdapter

class ListPullRequestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_pull_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtView2 = view.findViewById<TextView>(R.id.txtView2)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewListPullRequest)
        recyclerView.adapter = ListPullRequestAdapter(listPullRequest(), this.requireContext())
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

        txtView2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_repositoryFragment_to_listRepositoryFragment)
        }


    }

    private fun listPullRequest(): List<PullRequest> {
        return listOf(
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
            PullRequest("Gustavo Repo", "PullReques 01", "lalala"),
        )

    }
}