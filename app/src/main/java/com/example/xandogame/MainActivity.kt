package com.example.xandogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isPlayerOne = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button00.setOnClickListener { playturn(button00) }
        button01.setOnClickListener { playturn(button01) }
        button02.setOnClickListener { playturn(button02) }
        button10.setOnClickListener { playturn(button10) }
        button11.setOnClickListener { playturn(button11) }
        button12.setOnClickListener { playturn(button12) }
        button20.setOnClickListener { playturn(button20) }
        button21.setOnClickListener { playturn(button21) }
        button22.setOnClickListener { playturn(button22) }
        buttonTryAgain.setOnClickListener {
            reNew(button00)
            reNew(button01)
            reNew(button02)
            reNew(button10)
            reNew(button11)
            reNew(button12)
            reNew(button20)
            reNew(button21)
            reNew(button22)
            isPlayerOne = true
        }
    }
    private fun playturn (botton: Button){
        if (isPlayerOne){
            botton.text = "X"
        }else {
            botton.text = "O"
        }
        botton.isClickable = false
        isPlayerOne = !isPlayerOne
        checkWinner()
    }
    private fun checkWinner() {
        if (button00.text.toString().isNotEmpty() &&
            button00.text.toString() == button01.text.toString() &&
            button00.text.toString() == button02.text.toString()
            ) { showWinnerToast(button00.text.toString())
        }else if (button10.text.toString().isNotEmpty() &&
                button10.text.toString() == button11.text.toString() &&
                button10.text.toString() == button12.text.toString()
                ) {showWinnerToast(button10.text.toString())
        }else if (button20.text.toString().isNotEmpty() &&
            button20.text.toString() == button21.text.toString() &&
            button20.text.toString() == button22.text.toString()
        ) {showWinnerToast(button20.text.toString())
        }


        else if (button00.text.toString().isNotEmpty() &&
            button00.text.toString() == button10.text.toString() &&
            button00.text.toString() == button20.text.toString()
        ) { showWinnerToast(button00.text.toString())
        }else if (button01.text.toString().isNotEmpty() &&
            button01.text.toString() == button11.text.toString() &&
            button01.text.toString() == button12.text.toString()
        ) {showWinnerToast(button10.text.toString())
        }else if (button02.text.toString().isNotEmpty() &&
            button02.text.toString() == button12.text.toString() &&
            button02.text.toString() == button22.text.toString()
        ) {showWinnerToast(button20.text.toString())
        }


        else if (button00.text.toString().isNotEmpty() &&
            button00.text.toString() == button11.text.toString() &&
            button00.text.toString() == button22.text.toString()
        ) {showWinnerToast(button20.text.toString())
        }else if (button02.text.toString().isNotEmpty() &&
            button02.text.toString() == button11.text.toString() &&
            button02.text.toString() == button20.text.toString()
        ) {showWinnerToast(button20.text.toString())
        }


        else if (isFree()) Toast.makeText(this, "Free", Toast.LENGTH_SHORT).show()

    }
    private fun isFree(): Boolean {
        if (!button00.isClickable &&
            !button01.isClickable &&
            !button02.isClickable &&
            !button10.isClickable &&
            !button11.isClickable &&
            !button12.isClickable &&
            !button20.isClickable &&
            !button21.isClickable &&
            !button22.isClickable
                ){return true}
    }
    private fun showWinnerToast(winnerSymbol:String){
        Toast.makeText(this, "Winner is $winnerSymbol", Toast.LENGTH_SHORT).show()
            }
    private fun reNew(button: Button){
        button.text = ""
        button.isClickable = true
    }

}
