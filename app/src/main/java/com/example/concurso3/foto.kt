package com.example.concurso3

import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class foto : AppCompatActivity()
{
    private lateinit var nombre:String
    private lateinit var puntos:String
    private var guardado = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)

        nombre = intent.getStringExtra("nombre").toString()
        puntos = intent.getStringExtra("helado").toString()

        val boton = findViewById<Button>(R.id.foto)

        boton.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

    private val startForResult = registerForActivityResult(
                                    ActivityResultContracts.StartActivityForResult())
    {
        result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK)
        {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.verFoto)
            imageView.setImageBitmap(imageBitmap)

            val fos = openFileOutput(nombre(), Context.MODE_PRIVATE)
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.close()
            guardado = true
        }
    }


    fun nombre():String
    {
        return nombre + "-" + puntos +".jpg";
    }


    fun home(view: View)
    {
        if(guardado == true)
        {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "Necesito una foto", Toast.LENGTH_SHORT).show()
        }
    }
}