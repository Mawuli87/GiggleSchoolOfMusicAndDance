package com.messieyawo.gigglemusicpiano

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.messieyawo.gigglemusicpiano.activities.HomeActivity
import com.messieyawo.gigglemusicpiano.viewmodel.OnBoardingAdapter
import com.messieyawo.gigglemusicpiano.viewmodel.OnBoardingIemModel
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class MainActivity : AppCompatActivity() {

    var adapter: OnBoardingAdapter? = null
    var list:ArrayList<OnBoardingIemModel>? = ArrayList()
    lateinit var wormIndicator: WormDotsIndicator



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list!!.add(OnBoardingIemModel(
            R.drawable.gittar,
            "Welcome to Giggle School Of Music And Dance.",
            "Develop talents in Music and Dance."
        ))

        list!!.add(OnBoardingIemModel(
            R.drawable.one,
            "Socialize ,make new friends while learning from each other.",
            "Participate in social activities such as competitions, performances and more. Giggle School Of Music And Dance is committed for your career progress."
        ))

        list!!.add(OnBoardingIemModel(
            R.drawable.gifty,
            "Contact us now to start your journey with GIGGLE.",
            "With Giggle School Of Music And Dance, you are at the right place for a good start in your career. Quick Answer to inquiries. Call or WhatsApp 0553 592 014 / 0593155232"
        ))


        adapter = OnBoardingAdapter(this,list!!)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter
        wormIndicator = findViewById(R.id.indicator)
        wormIndicator.setViewPager2(viewPager)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val btnSkip = findViewById<TextView>(R.id.tv_skip)
        btnNext.setOnClickListener {
            if (viewPager.currentItem+1 < adapter!!.itemCount){
                viewPager.currentItem +=1
            }else{
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        btnSkip.setOnClickListener {
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}