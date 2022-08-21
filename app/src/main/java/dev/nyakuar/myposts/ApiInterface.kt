package dev.nyakuar.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.sql.RowId

interface ApiInterface  {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getpostById(@Path("id") postId:Int):Call<Post>
    @GET("/posts/{id}/comments")
    fun  getcommentId(@Path("id")commentId: Int):Call<List<CommentActivity>>


}


//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//
//interface ApiInterface {
//    @GET("/posts")
//    fun getPosts(): Call<List<Post>>
//
//    @GET("/posts/{id}")
//    fun getpostById(@Path("id") postId:Int):Call<Post>
//
//
//}