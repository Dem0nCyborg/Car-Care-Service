package com.chandan.carser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_packages.*

class PackageH : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    private lateinit var listViewAdater : ExpandabeLVAdapter
    private lateinit var chapterlist : List<String>
    private lateinit var topicList : HashMap<String,List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages)

        showList()

        listViewAdater = ExpandabeLVAdapter(this,chapterlist,topicList)
        Elist.setAdapter(listViewAdater)







            val homeFrag = HomeFrag()
            val fragment : Fragment


            supportFragmentManager.findFragmentByTag(HomeFrag::class.java.simpleName)





            drawerLayout = findViewById(R.id.drawerlayout)
            val navView : NavigationView = findViewById(R.id.nav_view1)

            toggle = ActionBarDrawerToggle(this,drawerLayout , R.string.open,R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {

                it.isChecked = true

                when(it.itemId){

                    R.id.nav_home -> replacefragmentM(HmeFragment())
                    R.id.nav_order -> changeTO(OrdersFrag(),it.title.toString())
                    R.id.nav_profile -> changeTO(ProfileFrag(),it.title.toString())
                    R.id.my_loc -> replacefragmentA(AddressFrag())
                    R.id.nav_us -> changeTO(AboutFrag(),it.title.toString())
                }
                true
            }


        }

    private fun showList() {
        chapterlist = ArrayList()
        topicList = HashMap()

        (chapterlist as ArrayList<String>).add("PREMIUM WASH")
        (chapterlist as ArrayList<String>).add("DECOMPRESSION WASH")
        (chapterlist as ArrayList<String>).add("EXPRESS DETAIL")
        (chapterlist as ArrayList<String>).add("PAINT ENHANCEMENT DETAIL")
        (chapterlist as ArrayList<String>).add("PAINT PROTECTION DETAIL")
        (chapterlist as ArrayList<String>).add("CERAMIC COATING")
        (chapterlist as ArrayList<String>).add("COATING & PFF MAINTANCE WASH")

        val topic1 : MutableList<String> = ArrayList()
        topic1.add("INTERIOR VACUUMING\n" +
                "FLOOR MATT CLEANING\n" +
                "WHEEL & TIRE CLEANING\n" +
                "FOAM SPRAY & RINSE \n" +
                "HAND WASH & RINSE\n" +
                "AIR & TOWEL DRY\n" +
                "SPRAY WAX COATING\n" +
                "INTERIOR WIPEDOWN\n" +
                "GLASS CLEANING (IN & OUT)\n" +
                "TIRE & TRIM DRESSING")
        val topic2 : MutableList<String> = ArrayList()
        topic2.add("INTERIOR WIPEDOWN\n" +
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
                "TIRE & TRIM DRESSING")


        val topic3 : MutableList<String> = ArrayList()
        topic3.add("INTERIOR CLEANING & CONDITIONING\n" +
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
                "TIRE & TRIM DRESSING")

        val topic4 : MutableList<String> = ArrayList()
        topic4.add("INTERIOR CLEANING & CONDITIONING\n" +
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
                "TIRE & TRIM DRESSING")

        val topic5 : MutableList<String> = ArrayList()
        topic5.add("INTERIOR CLEANING & CONDITIONING\n" +
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
                "INCLUDES 3 MAINTENANCE WASH")

        val topic6 : MutableList<String> = ArrayList()
        topic6.add("INTERIOR CLEANING + CONDITIONING\n" +
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
                "INCLUDES 3 MAINTENANCE WASH")

        val topic7 : MutableList<String> = ArrayList()
        topic7.add("WHEEL & TIRE CLEANING\n" +
                "FOAM SPRAY & RINSE \n" +
                "HAND WASH & RINSE\n" +
                "AIR & TOWEL DRY\n" +
                "SPRAY SEALANT COATING\n" +
                "GLASS CLEANING (IN & OUT)\n" +
                "TIRE & TRIM DRESSING")

        topicList[chapterlist[0]] = topic1
        topicList[chapterlist[1]] = topic2
        topicList[chapterlist[2]] = topic3
        topicList[chapterlist[3]] = topic4
        topicList[chapterlist[4]] = topic5
        topicList[chapterlist[5]] = topic6
        topicList[chapterlist[6]] = topic7

    }

    private fun replacefragmentA(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle("Address")
        val intent = Intent(this,Location::class.java)
        startActivity(intent)
        finish()

    }

    private fun changeTO(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    fun replacefragmentM(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle("Choose Your Car Type")
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()


    }




        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            if(toggle.onOptionsItemSelected(item)) {
                return true
            }

            return super.onOptionsItemSelected(item)
        }


}