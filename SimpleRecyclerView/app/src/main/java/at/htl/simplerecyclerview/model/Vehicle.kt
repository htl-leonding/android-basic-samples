package at.htl.simplerecyclerview.model

import at.htl.simplerecyclerview.R

data class Vehicle(val brand: String, val model: String, val image: Int)

fun getSampleVehicles(): List<Vehicle> {

    return listOf(
            Vehicle("Opel", "1200", R.drawable.opel_1200_1960),
            Vehicle("Opel", "GT", R.drawable.opel_gt_1970),
            Vehicle("Opel", "Kadett B", R.drawable.opel_kadett_b_1970),
            Vehicle("Opel", "Kapitän P 2,5", R.drawable.opel_kapitaen_1956),
            Vehicle("Opel", "Rekord C", R.drawable.opel_rekord_c_1970)
    )
}