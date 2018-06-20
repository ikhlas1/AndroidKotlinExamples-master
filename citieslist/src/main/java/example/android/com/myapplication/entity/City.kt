package example.android.com.myapplication.entity

/**
 * Created by hakim on 3/3/18.
 */
data class City(var listImage:Int=0,
                var detailImage:Int=0,
                var name:String,
                var touristNumber:String,
                var places:Array<String> = arrayOf<String>(),
                var description:String="") {
}