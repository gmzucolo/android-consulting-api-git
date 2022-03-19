package com.example.gmzucolo.appconsultingapigit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class RepositoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_repository, container, false)
        val txtView2 = view.findViewById<TextView>(R.id.txtView2)

        txtView2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_repositoryFragment_to_listRepositoryFragment)
        }

        return view
    }
}