package example.android.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import example.android.com.myapplication.entity.City
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main.*

import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cityAdapter = CityAdapter(this,loadData())
        listcities.adapter = cityAdapter
        listcities.setOnItemClickListener { adapterView, view, i, l ->
            if (findViewById<View>(R.id.fragment2)!= null) {
                //val i = intent.getIntExtra("pos",0)
                val detailImages= arrayOf(R.drawable.paris_detail,R.drawable.london_detail,R.drawable.barcelone_detail,R.drawable.istanbul_detail,R.drawable.rome_detail)
                val namesTab = resources.getStringArray(R.array.cities)
                val touristsTab = resources.getStringArray(R.array.tourists)
                val placesTab = resources.getStringArray(R.array.places)
                val descTab = resources.getStringArray(R.array.description)
                val city = City(detailImage = detailImages[i],name = namesTab[i],touristNumber = touristsTab[i],places = placesTab,description = descTab[i])
                displayData(city)
            }
            else {
                // send the position to the detail activity
                startActivity(intentFor<DetailActivity>("pos" to i))
            }

        }

    }
    fun displayData(city:City){
        imageDetail.setImageResource(city.detailImage)
        cities.text = city.name
        tourists.text = "${city.touristNumber} de touristes par an"
        description.text = city.description
        places.text = getString(R.string.places)+city.places.joinToString(separator = ", ")

    }

    fun loadData():List<City> {

        val imagesTab = arrayOf(R.drawable.paris_list,R.drawable.london_list,R.drawable.barcelona_list,R.drawable.istanbul_list,R.drawable.roma_list)
        val namesTab = resources.getStringArray(R.array.cities)
        val touristsTab = resources.getStringArray(R.array.tourists)
        val list = mutableListOf<City>()
        for (i in 0..imagesTab.size-1) {
            list.add(City(listImage = imagesTab[i], name = namesTab[i], touristNumber = touristsTab[i]))

        }

        return  list
    }
}
