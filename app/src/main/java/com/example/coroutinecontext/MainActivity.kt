package com.example.coroutinecontext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tv = findViewById<TextView>(R.id.tv_title)

        GlobalScope.launch {
            tv.text = sum().toString()
        }

    }
    private suspend fun sum() : Int{
        var result = 0
        var coroutineResult = GlobalScope.launch {
            for (i in 1..1000) {
                result += i
            }
        }
        coroutineResult.join()
        return result
    }

}