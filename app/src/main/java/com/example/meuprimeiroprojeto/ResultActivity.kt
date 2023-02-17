package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1F)

        tvResult.text = result.toString()

        /* 	MENOR QUE 18,5		MAGREZA			0
		ENTRE 18,5 E 24,9	    NORMAL			0
		ENTRE 25,0 E 29,9	    SOBREPESO		I
		ENTRE 30,0 E 39,9	    OBESIDADE		II
		MAIOR QUE 40,0		    OBESIDADE GRAVE	 III
     */
        val classificacao = if(result < 18.5f){
            "MAGREZA"
        }else if(result in 18.5f..24.9f){
            "NORMAL"
        }else if(result in 25.0f..29.9f){
            "SOBREPESO"
        }else if(result in 30.0f..39.9f){
            "OBESIDADE"
        }else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classfificacao, classificacao)


        }

    }

