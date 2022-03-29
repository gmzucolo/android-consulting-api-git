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

class ListRepositoryFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: ListRepositoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_repository, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtView1 = view.findViewById<TextView>(R.id.txtView1)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewListRepository)
        recyclerView.adapter = ListPullRequestAdapter(fakePullRequests())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        txtView1.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_listRepositoryFragment_to_repositoryFragment)
        }


    }
}