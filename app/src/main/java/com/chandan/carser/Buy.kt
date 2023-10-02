package com.chandan.carser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class Buy : AppCompatActivity(), PaymentResultListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
        val packhead : TextView = findViewById(R.id.b)
        val subpack : TextView = findViewById(R.id.c)
        var book : Button = findViewById(R.id.book)
        var order : Button = findViewById(R.id.order)
        var cod : Button = findViewById(R.id.cod)

        val bundle : Bundle? = intent.extras
        val Packs = bundle!!.getString("Packs")
        val subpacks = bundle!!.getString("Subpack")
        packhead.text = Packs
        subpack.text = subpacks


        order.setOnClickListener{
            order.visibility = View.INVISIBLE
          cod.visibility = View.VISIBLE
            book.visibility = View.VISIBLE


            book.setOnClickListener {
                Checkout.preload(applicationContext)
                makePayment()
            }
            cod.setOnClickListener {
                Toast.makeText(this,"Wait for Sometime",Toast.LENGTH_SHORT).show()
            }

        }




    }

    private fun makePayment() {
        val co = Checkout()
        co.setKeyID("rzp_test_eCUSn4OMmvjXEg")
        try {
            val options = JSONObject()
            options.put("name","Car Care")
            options.put("description","Hello")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","INR");
            options.put("amount","50000")//pass amount in currency subunits

            val retryObj = JSONObject()
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            val prefill = JSONObject()
            prefill.put("email","")
            prefill.put("contact","")

            options.put("prefill",prefill)
            co.open(this,options)
        }catch (e: Exception){
            Toast.makeText(this,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this,"Successful $p0",Toast.LENGTH_LONG).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this,"Error $p1",Toast.LENGTH_LONG).show()
    }
}
