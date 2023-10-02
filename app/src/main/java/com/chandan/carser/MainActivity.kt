package com.chandan.carser


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.MenuItem

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    //Review
    private lateinit var newReview : RecyclerView
    private lateinit var newArlist : ArrayList<Model>
    lateinit var imageId : Array<Int>
    lateinit var header : Array<String>
    lateinit var packages : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Choose Your Car Type")



        imageId = arrayOf(
            R.drawable.hatchback,
            R.drawable.cross_mini,
            R.drawable.sedan_coupe,
            R.drawable.suv_muv,
            R.drawable.img_4,
            R.drawable.lrs,
        )

        header = arrayOf(
            getString(R.string.c1),
            getString(R.string.c2),
            getString(R.string.c3),
            getString(R.string.c4),
            getString(R.string.c5),
            getString(R.string.c6),
        )



        newReview = findViewById(R.id.rv)
        newReview.layoutManager = LinearLayoutManager(this)
        newReview.setHasFixedSize(true)

        newArlist = arrayListOf<Model>()
        getUserData()


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
                R.id.nav_order -> replacefragment(OrdersFrag(),it.title.toString())
                R.id.nav_profile -> replacefragment(ProfileFrag(),it.title.toString())
                R.id.my_loc -> replacefragmentA(AddressFrag())
                R.id.nav_us -> replacefragmentAbt(AboutFrag())

            }
            true
        }


    }

    private fun replacefragmentAbt(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle("About Us")
        val intent = Intent(this,Prof::class.java)
        startActivity(intent)
        finish()

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

    private fun getUserData() {
        for (i in imageId.indices){
            val model = Model(imageId[i],header[i])
            newArlist.add(model)
        }

        var adapter = TypeAdap(newArlist)
        newReview.adapter = adapter
        adapter.setOnItemClickListner(object : TypeAdap.onItemCliclListner{
            override fun onItemClick(position: Int) {
               // Toast.makeText(this@MainActivity,"Hii",Toast.LENGTH_SHORT).show()
               val intent = Intent(this@MainActivity,Pckges::class.java)
                startActivity(intent)
                //setTitle("Choose Your Package")

                }



        })
    }

    private fun replacefragment(fragment: Fragment, title: String) {
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