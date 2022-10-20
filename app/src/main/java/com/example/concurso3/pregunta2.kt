package com.example.concurso3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class pregunta2 : AppCompatActivity()
{
    private lateinit var nombre: String
    private var puntos: Int = 0
    private lateinit var punto: String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta2)

        var punt:String = intent.getStringExtra("puntos").toString()

        puntos = Integer.parseInt(punt)

        nombre = intent.getStringExtra("nombre").toString()

        var pre:String = " te enfadas rápidamente?"

        var text:TextView = findViewById<TextView>(R.id.preg2)

        text.setText("¿$nombre $pre")
    }


    fun comprobarPreg2(view: View)
    {
        var b1 = findViewById<CheckBox>(R.id.checkBox)
        var b2 = findViewById<CheckBox>(R.id.checkBox2)

        if(b1.isChecked && b2.isChecked)
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error selección")
                .setMessage("No puedes seleccionar dos opciones")
                .setCancelable(true)
                .show()
        }
        else if(!b1.isChecked && !b2.isChecked)
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error selección")
                .setMessage("Tienes que seleccionar un campo")
                .setCancelable(true)
                .show()
        }
        else
        {
            if(b1.isChecked)
            {
                puntos = puntos + 1
                sig()
            }
            else if(b2.isChecked)
            {
                puntos = puntos + 2
                sig()
            }
        }
    }


    fun sig()
    {
        punto = "" + puntos

        intent = Intent(this, pregunta3::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("puntos", punto)
        }
        startActivity(intent)
    }
}

