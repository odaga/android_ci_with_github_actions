package com.example.lottietest

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.androidadvance.topsnackbar.TSnackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val lottieControlButton = findViewById<Button>(R.id.controlButton)
        val animationView = findViewById<LottieAnimationView>(R.id.animationView)

        button.setOnClickListener {

            val snackbar = TSnackbar.make(
                findViewById(android.R.id.content),
                "Success",
                TSnackbar.LENGTH_LONG
            )
            snackbar.setActionTextColor(Color.WHITE)
            val snackbarView: View = snackbar.view
            snackbarView.setBackgroundColor(Color.parseColor("#c22a0c"))

            snackbarView.findViewById<TextView>(com.androidadvance.topsnackbar.R.id.snackbar_text)
                .setTextColor(Color.WHITE)
            snackbar.show()

        }

        lottieControlButton.setOnClickListener {
            if (animationView.isAnimating) {
                animationView.pauseAnimation()
                lottieControlButton.text = "Play"
            } else {
                animationView.playAnimation()
                lottieControlButton.text = "Pause"
            }
        }
    }
}