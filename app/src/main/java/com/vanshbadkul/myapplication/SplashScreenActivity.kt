package com.vanshbadkul.myapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
import com.airbnb.lottie.value.ScaleXY
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val filter = SimpleColorFilter(resources.getColor(R.color.white))
        val keyPath = KeyPath("**")
        val callback = LottieValueCallback<ColorFilter>(filter)
        crossanim.addValueCallback<ColorFilter>(keyPath, LottieProperty.COLOR_FILTER, callback)
        zeroanim.addValueCallback<ColorFilter>(keyPath, LottieProperty.COLOR_FILTER, callback)
        zeroanim.setMinAndMaxFrame(0, 36)

        Handler().postDelayed({
            crossanim.playAnimation()
        }, 500)


        Handler().postDelayed({
            zeroanim.playAnimation()
        }, 500)

        start.setOnClickListener {
            val animDown = ValueAnimator.ofFloat(1f, 0.8f)
            animDown.duration = 100
            animDown.addUpdateListener {
                val value = it.animatedValue as Float
                start.scaleX = value
                start.scaleY = value
            }

            val animUp = ValueAnimator.ofFloat(0.8f, 1f)
            animUp.duration = 100
            animUp.addUpdateListener {
                val value = it.animatedValue as Float
                start.scaleX = value
                start.scaleY = value
            }

            val set = AnimatorSet()
            set.playSequentially(animDown, animUp)
            set.start()
            Handler().postDelayed({
                val intent = Intent(this, GameDetailsActivity::class.java)
                startActivity(intent)
            }, 200)


        }

    }
}