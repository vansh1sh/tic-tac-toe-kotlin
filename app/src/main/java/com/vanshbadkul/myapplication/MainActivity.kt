package com.vanshbadkul.myapplication


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    private var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    private var activePlayer = 1
    private var setPlayer = 1
    private var playerMode = "comp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent != null) {
            playerMode= intent.getStringExtra("mode")
        }

        if (playerMode == "comp")
            setPlayer = 1
        else
            setPlayer = 2
    }

    fun buttonClick(view: View)
    {
        val buSelected:TextView = view as TextView
        var cellId = 0
        when(buSelected.id)
        {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3

            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6

            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        playGame(cellId,buSelected)

    }

    fun playGame(cellId:Int, buSelected:TextView)
    {
        if (activePlayer == 1)
        {
            buSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
            if (setPlayer == 1)
            {}
            else
            {
                try {
                    autoPlay()
                }catch (ex:Exception)
                {
                    showDialog("Game Over")
                }

            }
        }
        else
        {
            buSelected.text = "O"
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner()
    {
        var winner = -1

        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        //cross1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        //cross2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }

        if (winner != -1)
        {
            if (winner == 1)
            {
                if(setPlayer == 1) {
                    showDialog("Player 1 Wins!!")
                }
                else
                {
                    showDialog("You Won!!")
                }
            }
            else
            {
                if (setPlayer == 1) {
                    showDialog("Player 2 Wins!!")
                }
                else
                {
                    showDialog("CPU 1 Wins!!")
                }
            }
        }

    }

    private fun autoPlay()
    {
        val emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (player1.contains(cellId) || player2.contains(cellId))
            {}
            else
            {
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells[randomIndex]

        val buSelect:TextView?
        when(cellId)
        {
            1 -> buSelect = button1
            2 -> buSelect = button2
            3 -> buSelect = button3
            4 -> buSelect = button4
            5 -> buSelect = button5
            6 -> buSelect = button6
            7 -> buSelect = button7
            8 -> buSelect = button8
            9 -> buSelect = button9
            else -> buSelect = button1
        }

        playGame(cellId,buSelect)
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_dialog)
        val body = dialog.findViewById(R.id.resultString) as TextView
        body.text = title
        val newGame = dialog.findViewById(R.id.startNew) as TextView
        val rematch = dialog.findViewById(R.id.rematch) as TextView
        newGame.setOnClickListener {
            dialog.dismiss()
            finish()
            val intent = Intent(this, GameDetailsActivity::class.java)
            startActivity(intent)
        }
        rematch.setOnClickListener {
            dialog.dismiss()
            finish()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("mode", playerMode)
            startActivity(intent)}
        dialog.show()
    }
}