package com.cat.newhope

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { _ ->
        }
        pesoEDT?.doOnTextChanged { _, _, _, _ ->
        }
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }
    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            Log.d("PITU","Oi Faustão")
            val imc = peso / (altura * altura)
            imcTXT.text = "Seu IMC É:\n%.2f".format(imc)
        }
    }
}
