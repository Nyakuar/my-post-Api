package dev.nyakuar.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.nyakuar.myposts.databinding.ActivityCommentBinding


class PostsRvAdapter(var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentpost = postList.get(position)

        holder.bindingView.tvpostbody.text = currentpost.body
        holder.bindingView.tvposttittle.text = currentpost.tittle
        val context = holder.itemView.context
        holder.bindingView.rvcommentlist.setOnClickListener {
            val intent = Intent(holder.itemView.context, CommentActivity::class.java)
            intent.putExtra("POST_ID", currentpost.id)
            context.startActivity(intent)

        }


//       with(holder.bindingView) override fun getItemCount(): Int {
        with(holder.bindingView){
            tvposttittle.text=currentpost.tittle
            tvpostbody.text=currentpost.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =
            ActivityCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: ActivityCommentBinding):
    RecyclerView.ViewHolder(bindingView.root) {


}