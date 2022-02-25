package com.example.ezetapassisgnment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import com.example.ezetapassisgnment.ViewModel.RetrofitViewModel
import com.example.ezetapassisgnment.databinding.ActivityMainBinding
import com.example.ezetapassisgnment.util.GetUI
import com.example.networkmodule.Model.ResponseModel
import com.example.networkmodule.Model.UiData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val retrofitViewModel : RetrofitViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    val path = "/mobileapps/android_assignment.json"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitViewModel.fetchCustomUI(path);

        retrofitViewModel.getData.observe(this){
            it?.let {
                binding.tvHeading.text = it.heading
                updateUI(it.uidata,it)
                retrofitViewModel.fetchImage(it.logo)
            }
        }

        retrofitViewModel.getImage.observe(this){
            it?.let {
                binding.ivImage.setImageBitmap(it)
            }
        }
    }

    private fun updateUI(uidata: List<UiData>, responseModel: ResponseModel) {
        binding.llInsert.removeAllViews()
        val ll = LinearLayout(this)
        ll.orientation = LinearLayout.VERTICAL
        for(data in uidata){
            GetUI.getView(data,this,ll,responseModel)
        }
        binding.llInsert.addView(ll)
    }

}