package com.example.viewmodelexample


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    var scoreCounterA = 0

    private lateinit var viewModel: MainActivtyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonCounterA  = findViewById<View>(R.id.buttonCounterA)
        buttonCounterA.setOnClickListener { incrementCounterA(it) }
        val buttonCounterB = findViewById<View>(R.id.buttonCounterB)
        buttonCounterB.setOnClickListener { incrementCounterB(it) }
        // viewModel = MainActivityViewModel() // todo: Так не делать !!!!
        viewModel = ViewModelProvider(this).get(MainActivtyViewModel::class.java)
        displayForCounterA(scoreCounterA)
        displayForCounterB(viewModel.scoreCounterB)
    }

    private fun incrementCounterA(v: View?) {
        scoreCounterA += 1
       displayForCounterA(scoreCounterA)
    }

    private fun displayForCounterA(score: Int) {
        val scoreView = findViewById<View>(R.id.counterA) as TextView
        scoreView.text = score.toString()
    }

    private fun incrementCounterB(v: View?) {
        viewModel.scoreCounterB += 1
        displayForCounterB(viewModel.scoreCounterB)
    }

    private fun displayForCounterB(score: Int) {
        val scoreView = findViewById<View>(R.id.counterB) as TextView
        scoreView.text = score.toString()
    }
}