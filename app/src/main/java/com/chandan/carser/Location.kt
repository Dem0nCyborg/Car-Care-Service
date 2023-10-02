package com.chandan.carser

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.navigation.NavigationView

class Location : AppCompatActivity() {

    private lateinit var tvLatitude : TextView
    private lateinit var tvLomgitude : TextView
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient



    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this)
        tvLatitude = findViewById(R.id.tv_latitude)
        tvLatitude = findViewById(R.id.tv_latitude)

        getCurrentLocatin()




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


    private fun getCurrentLocatin() {
        if(checkPermission()){

            if(isLocationEnabled()){

                //Final Longitute And Latitude
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this){ task->

                    val loaction : android.location.Location?=task.result
                    if (loaction == null){
                        Toast.makeText(this,"Location Not Accessible", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Location Received", Toast.LENGTH_SHORT).show()
                        tvLatitude.text=""+loaction.latitude
                        tvLomgitude.text=""+loaction.longitude
                        requestPermission()
                    }

                }

            }else{

                //setting open here
                Toast.makeText(this,"Turn On Location", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)

            }


        }else{

        }

        //request permission
        requestPermission()
        return
    }



    private fun isLocationEnabled(): Boolean {

        val locationManager : LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManager.isProviderEnabled(
            LocationManager.GPS_PROVIDER)

    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,arrayOf( android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_ACCESS_LOCATION
        )
    }

    private fun checkPermission(): Boolean {

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            return true
        }

        return false

    }

    private companion object{
        private const val PERMISSION_REQUEST_ACCESS_LOCATION = 100
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_ACCESS_LOCATION){

            if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Granted",Toast.LENGTH_SHORT).show()
                getCurrentLocatin()
            }else{
                Toast.makeText(this,"Denied",Toast.LENGTH_SHORT).show()
            }

        }

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
