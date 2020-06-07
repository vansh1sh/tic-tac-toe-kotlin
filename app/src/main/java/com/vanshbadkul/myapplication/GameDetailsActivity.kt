package com.vanshbadkul.myapplication

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game_details.*

class GameDetailsActivity : AppCompatActivity() {

    private var playerMode = "comp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)

        start_game.setOnClickListener {
            val animDown = ValueAnimator.ofFloat(1f, 0.8f)
            animDown.duration = 100
            animDown.addUpdateListener {
                val value = it.animatedValue as Float
                start_game.scaleX = value
                start_game.scaleY = value
            }

            val animUp = ValueAnimator.ofFloat(0.8f, 1f)
            animUp.duration = 100
            animUp.addUpdateListener {
                val value = it.animatedValue as Float
                start_game.scaleX = value
                start_game.scaleY = value
            }

            playerMode = if (vscomp.isChecked)
                "comp"
            else
                "player"

            val set = AnimatorSet()
            set.playSequentially(animDown, animUp)
            set.start()
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("mode", playerMode)
                startActivity(intent)
            }, 200)
        }
    }
}