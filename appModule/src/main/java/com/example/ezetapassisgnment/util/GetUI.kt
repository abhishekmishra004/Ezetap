package com.example.ezetapassisgnment.util

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginTop
import androidx.core.widget.addTextChangedListener
import com.example.ezetapassisgnment.MainActivity
import com.example.ezetapassisgnment.R
import com.example.ezetapassisgnment.SecondActivity
import com.example.networkmodule.Model.ResponseModel
import com.example.networkmodule.Model.UiData
import com.google.gson.Gson


object GetUI {
    private const val TAG = "getui";
    fun getView(type: UiData, context: Context, llLayout: LinearLayout, uidata: ResponseModel) {
        when (type.uitype) {
            "label" -> {
                val text = TextView(context)
                text.text = type.value
                val typeface = ResourcesCompat.getFont(context, R.font.robotocondensedlight)
                text.typeface = typeface
                text.textSize = 18f
                val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0,20,0,0)
                }
                text.layoutParams = param
                llLayout.addView(text)
            }
            "edittext" -> {
                val edit = EditText(context)
                edit.hint = type.hint
                llLayout.addView(edit)
                edit.addTextChangedListener {
                    type.value = it.toString()
                    Log.d(TAG, "getView: "+type.value)
                }
            }
            "button" -> {
                val button = Button(context)
                button.text = type.value
                button.setOnClickListener{
                    Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, SecondActivity::class.java).putExtra("data", Gson().toJson(uidata)))
                    (context as MainActivity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }
                val typeface = ResourcesCompat.getFont(context, R.font.roboto_condensed_regular)
                button.typeface = typeface
                val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                    weight = 1.0f
                    gravity = Gravity.CENTER_HORIZONTAL
                    setMargins(0,100,0,0)
                }
                button.layoutParams = param
                llLayout.addView(button)
            }
        }
    }

    fun getResultView(type: UiData, context: SecondActivity, llLayout: LinearLayout) {
        when (type.uitype) {
            "label" -> {
                val text = TextView(context)
                text.text = type.value
                llLayout.addView(text)
                val typeface = ResourcesCompat.getFont(context, R.font.robotocondensedlight)
                text.typeface = typeface
                val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0,0,0,0)
                }
                text.layoutParams = param
            }
            "edittext" -> {
                val text = TextView(context)
                text.text = type.value
                llLayout.addView(text)
                val typeface = ResourcesCompat.getFont(context, R.font.robotocondensedlight)
                text.typeface = typeface
                val param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0,20,0,50)
                }
                text.layoutParams = param
            }

        }
    }
}