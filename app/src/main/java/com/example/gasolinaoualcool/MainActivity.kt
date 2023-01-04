package com.example.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        val decorView = window.decorView
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        decorView.systemUiVisibility = uiOptions

    }

    fun btCalcular (view:View){
        //val precoAlcool = findViewById<EditText>(R.id.edit_preco_alcool)
        //val textoRecuperado = precoAlcool.text.toString()

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos( precoAlcool, precoGasolina )
        if (validaCampos){
        calcularMelhorPreco( precoAlcool, precoGasolina )}
        else{
            text_resultado.setText("Preencha os campos corretamente")
        }

    }

    fun validarCampos( precoAlcool: String, precoGasolina: String) : Boolean{
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularMelhorPreco( precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorGasolina * 0.7

        if(resultadoPreco < valorAlcool){
           text_resultado.setText("Abasteça com Gasolina")
        }else if(resultadoPreco == valorAlcool){
            text_resultado.setText("Valores equivalentes, escolha qual lhe agrada mais")
        }
        else {
                text_resultado.setText("Abasteça com Álcool")
            }
        }
    }