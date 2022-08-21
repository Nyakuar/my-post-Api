package dev.nyakuar.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.nyakuar.myposts.databinding.ActivityCommentBinding
import dev.nyakuar.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    lateinit var binding:  ActivityCommentBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_comment)
        setContentView(binding.root)
        obtainpostId()
        fetchPost()
    }
    fun obtainpostId(){
        postId = intent.extras?.getInt("POST_ID")?:0
        }
        fun fetchPost(){
            var ApiClient=ApiClient.buildClient(ApiInterface::class.java)
            var request = ApiClient.getpostById(postId)


            request.enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    var post = response.body()
                    if (post != null) {
                        binding.tvpostbody .text = post.body
                        binding.tvposttittle.text = post.tittle

                    }
                }
                override fun onFailure(call: Call<Post>, t: Throwable) {

                }
            } )
                }

}


