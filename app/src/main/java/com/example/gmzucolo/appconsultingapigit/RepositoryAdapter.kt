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

class RepositoryAdapter(
    private val pullrequests: List<PullRequest>,
    private val context: Context
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val repoName: TextView = itemView.findViewById(R.id.appCompatTextViewRepositoryUserName)
        val title: TextView = itemView.findViewById(R.id.appCompatTextViewPullRequestTitle)
        val description: TextView =
            itemView.findViewById(R.id.appCompatTextViewPullRequestDescription)
        val avatar =
            itemView.findViewById<ImageView>(R.id.appCompatImageViewPullRequestUserAvatar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_pull_request_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pullrequest = pullrequests[position]
        holder.let {
            it.repoName.text = pullrequest.repoName
            it.title.text = pullrequest.title
            it.description.text = pullrequest.description
        }
    }

    override fun getItemCount(): Int {
        return pullrequests.size
    }
}