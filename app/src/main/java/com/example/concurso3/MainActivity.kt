package com.example.concurso3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import org.w3c.dom.Text
import java.io.File

public var nombre:String = ""

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<EditText>(R.id.getNombre)

        texto.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && !texto.text.toString().equals(""))
            {
                nombre = texto.text.toString()
                intent = Intent(this, pregunta1::class.java).apply{
                    putExtra("nombre", nombre)
                }
                startActivity(intent)
                true
            }
            false
        })
    }


    fun comprobarNombre(view:View)
    {
        var campo = findViewById<EditText>(R.id.getNombre)
        nombre = campo.text.toString()

        if(nombre.isEmpty())
        {
            campo.setError("El nombre no puede estar vacio")
        }
        else
        {
            nombre = campo.text.toString()
            intent = Intent(this, pregunta1::class.java).apply{
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }

    fun verPuntuaciones(view: View)
    {
        intent = Intent(this, puntuaciones::class.java)
        startActivity(intent)
    }
}