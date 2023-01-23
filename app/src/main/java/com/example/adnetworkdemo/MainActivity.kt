package com.example.adnetworkdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.allnetworkads.Ads
import com.example.allnetworkads.admob.ENUMS
import com.example.allnetworkads.adslib.TestAds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Example of library usage

        val button = findViewById<Button>(R.id.button)
        //val adFrame = findViewById<FrameLayout>(R.id.native_ad_layout)

        val text = findViewById<TextView>(R.id.title_text_view)
        text.isSelected = true

        /*to show admob ads save true
        to show applovin ads save false*/
        TestAds.getTestAds(this, ENUMS.ADMOB, packageName)

        Ads.loadNative(this, this, null, getString(R.string.ads_lib_app_name), packageName,
               ENUMS.LARGE_ADS, ENUMS.WHITE, false)

        Ads.loadInter(this, this)

        button.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            Ads.showInter(this, this, intent, false)
        }

        Ads.showActivityBanner(this, this)

    }

}