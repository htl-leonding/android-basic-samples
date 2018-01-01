package at.htl.simplerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import at.htl.simplerecyclerview.model.getSampleVehicles
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    init {
        mainActivityContext = this
    }

    companion object {
        lateinit var mainActivityContext: MainActivity
            private set
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)

        rv.layoutManager = LinearLayoutManager(this)
        // https://stackoverflow.com/questions/46076148/how-to-create-onclick-event-in-adapter-using-interface-android
        //rv.adapter = VehicleAdapter(getSampleVehicles(), { onClickListener(it as View) })
        rv.adapter = VehicleAdapter(getSampleVehicles())

    }

    /**
     * ACHTUNG: Damit die Views gefunden werden (R.id.*) muss die View importiert werden !!!
     * import kotlinx.android.synthetic.main.card_vehicle.*
     *
     * vgl. https://stackoverflow.com/questions/44950401/not-able-to-findviewbyid-in-kotlin-getting-error-type-inference-failed/44950543
     */
    fun onClickListener(view: View) {
        //println("Clicked $view")
        val model = view.findViewById<RecyclerView>(R.id.tv_model) as TextView
        val brand = view.findViewById<RecyclerView>(R.id.tv_brand) as TextView
        println("${brand.text} ${model.text} geklickt")
    }

    fun onClickListenerWithPosition(position: Int) {
        println("Clicked on $position: ${getSampleVehicles()[position]}")
    }

}
