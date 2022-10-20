package com.example.concurso3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.concurso3.adapter.PlayerProvider
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException
import java.io.OutputStreamWriter

class fin : AppCompatActivity()
{
    private lateinit var nombre:String
    private lateinit var puntos:String
    private lateinit var player:String
    private lateinit var hel:String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin)

        var imagen = findViewById<ImageView>(R.id.imageView)

        nombre = intent.getStringExtra("nombre").toString()
        puntos = intent.getStringExtra("puntos").toString()

        var text: TextView = findViewById<TextView>(R.id.textView6)

        when(puntos)
        {
            "1" -> {
                hel = "cono"
                imagen.setImageResource(R.drawable.cono)}
            "2" -> {
                hel = "cucurucho"
                imagen.setImageResource(R.drawable.cucurucho)
            }
            "3" -> {
                hel = "palo"
                imagen.setImageResource(R.drawable.palo)
            }
            "4" -> {
                hel = "tarrina"
                imagen.setImageResource(R.drawable.tarrina)
            }
            "5" -> {
                hel = "sandwich"
                imagen.setImageResource(R.drawable.sandwich)
            }
            else -> {
                hel = "polo"
                imagen.setImageResource(R.drawable.polo)
            }
        }

        text.setText("Enhorabuena $nombre \n eres un $hel")

        player = "$nombre,$hel\n"
    }


    fun guardar(view: View)
    {
        val arc = "puntuaciones.csv"

        try
        {
            val escritor = OutputStreamWriter(openFileOutput(arc, Context.MODE_APPEND))

            escritor.write(player)

            escritor.flush()
            escritor.close()

            Toast.makeText(this, "Puntuación grabada", Toast.LENGTH_SHORT).show()
        }
            catch (e:IOException)
        {
            e.stackTrace
        }

        intent = Intent(this, foto::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("helado", hel)
        }
        startActivity(intent)
    }
}