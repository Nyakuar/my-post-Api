package dev.nyakuar.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.nyakuar.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts(){
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    if (posts != null)
                        displayPosts(posts)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
    }
    fun displayPosts(postsList:List<Post>){
        binding.rvViews.layoutManager= LinearLayoutManager(this)
        var PostsAdapter=PostsRvAdapter(postsList)
        binding.rvViews.adapter=PostsAdapter
    }


}

























