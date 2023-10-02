package com.chandan.carser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pckges : AppCompatActivity() {

    private lateinit var newReview : RecyclerView
    private lateinit var newArlist : ArrayList<Packs>
    private lateinit var packs : Array<String>
    private lateinit var price : Array<Int>
    lateinit var subpack : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pckges)
        setTitle("Choose Your Package")

        packs = arrayOf(
            "PREMIUM WASH",
            "DECOMPRESSION WASH",
            "EXPRESS DETAIL",
            "PAINT ENHANCEMENT DETAIL",
            "PAINT PROTECTION DETAIL",
            "CERAMIC COATING",
            "COATING & PFF MAINTENANCE WASH"
        )

        subpack = arrayOf(
            "INTERIOR VACUUMING\nFLOOR MATT CLEANING\nWHEEL & TIRE CLEANING\nFOAM SPRAY & RINSE \nHAND WASH & RINSE\nAIR & TOWEL DRY\nSPRAY WAX COATING\nINTERIOR WIPEDOWN\nGLASS CLEANING (IN & OUT)\nTIRE & TRIM DRESSING",
            "INTERIOR WIPEDOWN\n" +
                    "FLOOR MATT CLEANING\n" +
                    "ENGINE CLEANING & DRESSING\n" +
                    "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "CERAMIC WASH & RINSE\n" +
                    "IRON DECONTAMINATION\n" +
                    "CLAY TREATMENT\n" +
                    "AIR & TOWEL DRY\n" +
                    "PASTE WAX COATING\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING",
            "INTERIOR CLEANING & CONDITIONING\n" +
                    "FLOOR MATT CLEANING\n" +
                    "ENGINE CLEANING & DRESSING\n" +
                    "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "HAND WASH & RINSE\n" +
                    "IRON DECONTAMINATION\n" +
                    "CLAY TREATMENT\n" +
                    "AIR & TOWEL DRY\n" +
                    "ALL IN ONE POLISHNIG\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING",
            "INTERIOR CLEANING & CONDITIONING\n" +
                    "FLOOR MATT CLEANING\n" +
                    "ENGINE CLEANING & DRESSING\n" +
                    "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "HAND WASH & RINSE\n" +
                    "IRON DECONTAMINATION\n" +
                    "CLAY TREATMENT\n" +
                    "AIR & TOWEL DRY\n" +
                    "ONE STEP PAINT POLISHNIG\n" +
                    "IPA PANEL WIPEDOWN\n" +
                    "SPRAY SEALANT COATING\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING",
            "INTERIOR CLEANING & CONDITIONING\n" +
                    "FLOOR MATT CLEANING\n" +
                    "ENGINE CLEANING & DRESSING\n" +
                    "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "HAND WASH & RINSE\n" +
                    "IRON DECONTAMINATION\n" +
                    "CLAY TREATMENT\n" +
                    "AIR & TOWEL DRY\n" +
                    "PAINT COMPOUNDING & POLISHNIG\n" +
                    "IPA PANEL WIPEDOWN\n" +
                    "PAINT SEALANT APPLICATION\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING\n" +
                    "INCLUDES 3 MAINTENANCE WASH",
            "INTERIOR CLEANING + CONDITIONING\n" +
                    "FLOOR MATT CLEANING\n" +
                    "ENGINE CLEANING & DRESSING\n" +
                    "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "HAND WASH & RINSE\n" +
                    "IRON DECONTAMINATION\n" +
                    "CLAY TREATMENT\n" +
                    "AIR & TOWEL DRY\n" +
                    "PAINT COMPOUNDING & POLISHNIG\n" +
                    "IPA PANEL WIPEDOWN\n" +
                    "CERAMIC COATING APPLICATION\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING\n" +
                    "INCLUDES 3 MAINTENANCE WASH",
            "WHEEL & TIRE CLEANING\n" +
                    "FOAM SPRAY & RINSE \n" +
                    "HAND WASH & RINSE\n" +
                    "AIR & TOWEL DRY\n" +
                    "SPRAY SEALANT COATING\n" +
                    "GLASS CLEANING (IN & OUT)\n" +
                    "TIRE & TRIM DRESSING"
        )


        price = arrayOf(

        )

        newReview = findViewById(R.id.packv)
        newReview.layoutManager = LinearLayoutManager(this)
        newReview.setHasFixedSize(true)

        newArlist = arrayListOf<Packs>()
        getUserdata()

    }

    private fun getUserdata() {

        for (i in packs.indices){
            val model = Packs(packs[i])
            newArlist.add(model)
        }

        var adapt = Packadap(newArlist)
        newReview.adapter = adapt
        adapt.itemClicklistner(object : Packadap.onItemClickListner{
            override fun onItemClicked(position: Int) {
                val intent = Intent(this@Pckges,Buy::class.java)
                intent.putExtra("Packs",newArlist[position].packs)
                intent.putExtra("Subpack",subpack[position])
                startActivity(intent)

            }


        })




    }
}