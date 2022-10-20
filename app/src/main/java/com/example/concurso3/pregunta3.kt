package com.example.concurso3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class pregunta3 : AppCompatActivity() {
    private lateinit var punto: String
    private lateinit var nombre: String
    private var puntos = 0
    private var bebidas: Array<String> = arrayOf("Café", "Té", "Agua", "Coca-Cola")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta3)

        var text = findViewById<TextView>(R.id.textView7)

        nombre = intent.getStringExtra("nombre").toString()

        var punt = intent.getStringExtra("puntos").toString()

        puntos = Integer.parseInt(punt)

        text.setText("¿$nombre cual es tu bebida prefereida?")
    }


    fun comprobarPreg3() {
        var spin = findViewById<Spinner>(R.id.spinner)

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bebidas)

        spin.adapter = adapter

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == 0) {
                    puntos = puntos + 1
                    fin()
                } else if (p2 == 1) {
                    puntos = puntos + 2
                    fin()
                } else if (p2 == 2) {
                    puntos = puntos + 3
                    fin()
                } else if (p2 == 3) {
                    puntos = puntos + 4
                    fin()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                print("")
            }

        }
    }


    fun fin(view: View)
    {
        comprobarPreg3()

        punto = "" + puntos

        intent = Intent(this, fin::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("puntos", punto)
        }
        startActivity(intent)
    }
}