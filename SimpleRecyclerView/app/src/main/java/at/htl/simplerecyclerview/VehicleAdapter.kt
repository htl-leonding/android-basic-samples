package at.htl.simplerecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.htl.simplerecyclerview.model.Vehicle
import kotlinx.android.synthetic.main.card_vehicle.view.*

class VehicleAdapter(val vehicles: List<Vehicle>,
                     val callback: (Any) -> Unit) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    class VehicleViewHolder(val vehicleItem: View) : RecyclerView.ViewHolder(vehicleItem)

    override fun onBindViewHolder(holder: VehicleViewHolder?, position: Int) {
        if (holder != null) {
            val vehicle = vehicles[position]
            holder.vehicleItem.tv_brand.text = vehicle.brand
            holder.vehicleItem.tv_model.text = vehicle.model
            holder.vehicleItem.iv_icon.setImageResource(vehicle.image)
            holder.vehicleItem.setOnClickListener{ callback (it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.card_vehicle, parent, false)
        return VehicleViewHolder(view)

    }

    override fun getItemCount() = vehicles.size


}