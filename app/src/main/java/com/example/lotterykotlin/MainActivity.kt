package com.example.lotterykotlin

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import android.content.res.Resources;

class MainActivity : AppCompatActivity() {
    private var fullNumber: EditText? = null
    private var fullNumberString: String = ""
    private var buttonCheckNumber: Button? = null
    private var message:TextView? = null
    private var bulb: ImageView? = null
    private var circle: Drawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCheckNumber = findViewById((R.id.buttonCheckNumberTicket))
        fullNumber = findViewById(R.id.inputNumberTicket)
        message = findViewById(R.id.message)
        bulb = findViewById(R.id.bulb)
        circle = getDrawable(R.drawable.circle)

        calculation()
    }

    fun calculation() {
        var textInvalidTicket = getString(R.string.invalidLotteryTicket)
        var textEmptyMessage = getString(R.string.emptyMessage)

        buttonCheckNumber?.setOnClickListener(View.OnClickListener () {
            fullNumberString = fullNumber?.text.toString()
            var firstPartNumber: Int = 0
            var secondPartNumber: Int = 0

            if (fullNumberString.length != 6) {
                message?.setText(textInvalidTicket)
            } else {
                message?.setText(textEmptyMessage)

                for (char in fullNumberString.indices){
                    if (char < 3) {
                        firstPartNumber = firstPartNumber + fullNumberString[char].toString().toInt()
                    } else {
                        secondPartNumber = secondPartNumber + fullNumberString[char].toString().toInt()
                    }
                }

                if (firstPartNumber == secondPartNumber) {
                    bulb?.background?.setTint(ContextCompat.getColor(this, R.color.green))
                } else {
                    bulb?.background?.setTint(ContextCompat.getColor(this, R.color.red))
                }
            }
        });
    }
}