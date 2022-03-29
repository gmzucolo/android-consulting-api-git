package com.example.gmzucolo.appconsultingapigit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.model.fakePullRequests
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
        recyclerView.adapter = ListPullRequestAdapter(fakePullRequests())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        txtView2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_repositoryFragment_to_listRepositoryFragment)
        }


    }

}