package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str1 : EditText = findViewById(R.id.editTextWeight)
        val str2 : EditText = findViewById(R.id.editTextHeight)
        val bmiResult : TextView = findViewById(R.id.bmiResult)
        val bCalculate : Button = findViewById(R.id.buttonCalculate)


        bCalculate.setOnClickListener{
            val weight : Double = str1.text.toString().toDouble()
            val height : Double = str2.text.toString().toDouble()
            val bmi : Double = weight / (height/100).pow(2)


            bmiResult.text = bmi.toString()

            if(bmi <18.5){
                imageViewProfile.setImageResource(R.drawable.under)
                bodyType.text = "Underweight"
            }
            else if(bmi<24.9){
                imageViewProfile.setImageResource(R.drawable.normal)
                bodyType.text = "Normal"
            }
            else{
                imageViewProfile.setImageResource(R.drawable.over)
                bodyType.text = "Overweight"

            }
        }

        buttonReset.setOnClickListener{
            str1.setText("")
            str2.setText("")
            bmiResult.text= ""
            bodyType.text = ""
            imageViewProfile.setImageResource(R.drawable.empty)

        }
    }
}
