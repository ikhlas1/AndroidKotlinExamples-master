package example.android.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import example.android.com.myapplication.entity.City
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val i = intent.getIntExtra("pos",0)
        val detailImages= arrayOf(R.drawable.paris_detail,R.drawable.london_detail,R.drawable.barcelone_detail,R.drawable.istanbul_detail,R.drawable.rome_detail)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        val placesTab = resources.getStringArray(R.array.places)
        val descTab = resources.getStringArray(R.array.description)
        val city = City(detailImage = detailImages[i],name = namesTab[i],touristNumber = touristsTab[i],places = placesTab,description = descTab[i])
        displayData(city)

    }


    fun displayData(city:City){
        imageDetail.setImageResource(city.detailImage)
        cities.text = city.name
        tourists.text = "${city.touristNumber} de touristes par an"
        description.text = city.description
        places.text = getString(R.string.places)+city.places.joinToString(separator = ", ")

    }
}
