package layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmzucolo.appconsultingapigit.R
import com.example.gmzucolo.appconsultingapigit.model.PullRequest

class ListPullRequestAdapter(
    private val listPullRequest: List<PullRequest>,
    private val context: Context
) : RecyclerView.Adapter<PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pull_request_list, parent, false)
        return PullRequestViewHolder(view)
    }

    override fun onBindViewHolder(holderPullRequest: PullRequestViewHolder, position: Int) {
        holderPullRequest.bindView(listPullRequest[position])
    }

    override fun getItemCount(): Int {
        return listPullRequest.size
    }
}

class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(pullrequest: PullRequest) {
        val title: TextView = itemView.findViewById(R.id.appCompatTextViewPullRequestTitle)
        val description: TextView =
            itemView.findViewById(R.id.appCompatTextViewPullRequestDescription)
        val avatar =
            itemView.findViewById<ImageView>(R.id.appCompatImageViewPullRequestUserAvatar)
        val user = itemView.findViewById<TextView>(R.id.appCompatTextViewPullRequestUserName)

        title.text = pullrequest.title
        description.text = pullrequest.description
//            user.text = pullrequest.user.toString()
    }
}