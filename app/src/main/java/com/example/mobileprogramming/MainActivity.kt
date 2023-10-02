package com.example.mobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var btn: Button
    private lateinit var result: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputPanjang= findViewById(R.id.edt_length)
        inputLebar= findViewById(R.id.edt_width)
        inputTinggi= findViewById(R.id.edt_height)
        result= findViewById(R.id.result)
        btn = findViewById(R.id.btn_result)

        btn.setOnClickListener(this)

        if (savedInstanceState != null){
            result.text = savedInstanceState.getString(STATE_RESULT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id==R.id.btn_result){
            var Panjang = inputPanjang.text.toString().trim()
            var Lebar = inputLebar.text.toString().trim()
            var Tinggi = inputTinggi.text.toString().trim()
            var Volume = Panjang.toDouble() * Lebar.toDouble() * Tinggi.toDouble()
            result.text = Volume.toString()
        }
    }
}