package com.example.gmzucolo.appconsultingapigit.features.pullrequests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.R
import com.example.gmzucolo.appconsultingapigit.databinding.FragmentListPullRequestBinding
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.fakePullRequests

class ListPullRequestFragment : Fragment() {

    private var binding: FragmentListPullRequestBinding by autoCleared()

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
    private fun showPullRequestsDataResult(result: ResultDataWithListPullRequest?) {
        result?.let {
            val resultMapped = it.toPullRequestListResult()
            binding.recyclerViewListPullRequest.visible()
            ListPullRequestAdapter.addAllPulRequests(result.toPullRequesList())
        }
    }

}