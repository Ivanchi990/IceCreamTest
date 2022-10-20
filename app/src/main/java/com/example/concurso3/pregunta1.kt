package com.example.concurso3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class pregunta1 : AppCompatActivity() {

    private lateinit var nombre:String
    private var puntos:Int = 0
    private lateinit var punto:String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta1)

        var pre:String = " cual es tu estación favorita?"
        nombre = intent.getStringExtra("nombre").toString()

        var textView = findViewById<TextView>(R.id.preg1)

        textView.setText("¿ $nombre$pre")
    }

    fun comprobarPreg1(view: View)
    {
        var b1: RadioButton = findViewById(R.id.res1)
        var b2: RadioButton = findViewById(R.id.res2)
        var b3: RadioButton = findViewById(R.id.res3)
        var b4: RadioButton = findViewById(R.id.res4)

        if(b1.isChecked)
        {
            puntos = puntos + 1
            llevar()
        }
        else if(b2.isChecked)
        {
            puntos = puntos + 2
            llevar()
        }
        else if(b3.isChecked)
        {
            puntos = puntos + 3
            llevar()
        }
        else if(b4.isChecked)
        {
            puntos = puntos + 4
            llevar()
        }
        else
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error selección")
                .setMessage("Tienes que seleccionar un campo")
                .setCancelable(true)
                .show()
        }
    }


    fun llevar()
    {
        punto = "" + puntos
        intent = Intent(this, pregunta2::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("puntos", punto)
        }
        startActivity(intent)
    }
}