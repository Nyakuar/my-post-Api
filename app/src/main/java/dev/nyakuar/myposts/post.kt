package dev.nyakuar.myposts

import android.content.ClipData
import android.icu.text.CaseMap
import android.security.identity.AccessControlProfileId
class Item(){
    var id: Int=0
}

data class Post(
    var userId:Int,
    var tittle:String,
    var id: Int,
    var body: String)


data class Comment(
    var postId:Int,
    var id: Int,
    var name:String,
    var email:String,
    var body: String,
    var tittle: String,
)
//fun <T> compareIds(item1:T,item2:T,): T{
//    var output = (item1.toString()+ item2.toString())
//    println(output)
//    return item1
//}