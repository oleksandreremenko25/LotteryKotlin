package com.example.lotterykotlin

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var firstPartNumber: Int = 0
    private var secondPartNumber: Int = 0
    private var fullNumber: EditText? = null
    private var fullNumberString: String = ""
    private var buttonCheckNumber: Button? = null
    private var message:TextView? = null
    private var bulb: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCheckNumber = findViewById((R.id.buttonCheckNumberTicket))
        fullNumber = findViewById(R.id.inputNumberTicket)
        message = findViewById(R.id.message)
        bulb = findViewById(R.id.bulb)

        calculation()
    }

    fun calculation() {
        buttonCheckNumber?.setOnClickListener(View.OnClickListener () {
            fullNumberString = fullNumber?.text.toString()

            if (fullNumberString.length != 6) {
                message?.setText("Не коректний номер білету")
            } else {
                message?.setText("")

                for (char in fullNumberString.indices){
                    if (char < 3) {
                        firstPartNumber = firstPartNumber + fullNumberString[char].toString().toInt()
                    } else {
                        secondPartNumber = secondPartNumber + fullNumberString[char].toString().toInt()
                    }
                }

                if (firstPartNumber == secondPartNumber) {
                    bulb?.getBackground()?.setColorFilter(ContextCompat.getColor(this, R.color.green), PorterDuff.Mode.MULTIPLY)
                } else {
                    bulb?.getBackground()?.setColorFilter(ContextCompat.getColor(this, R.color.red), PorterDuff.Mode.MULTIPLY)
                }
            }
        });
    }
}