package com.example.ezetapassisgnment

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.ezetapassisgnment.databinding.ActivitySecond2Binding
import com.example.ezetapassisgnment.util.GetUI
import com.example.networkmodule.Model.ResponseModel
import com.google.gson.Gson

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecond2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra("data")
        val uiData: ResponseModel = Gson().fromJson(data,ResponseModel::class.java)
        updateUI(uiData)
    }

    private fun updateUI(uiData: ResponseModel) {
        val uidata = uiData.uidata
        binding.llLayout.removeAllViews()
        val ll = LinearLayout(this)
        ll.orientation = LinearLayout.VERTICAL
        for(data in uidata){
            GetUI.getResultView(data,this,ll)
        }
        binding.llLayout.addView(ll)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}