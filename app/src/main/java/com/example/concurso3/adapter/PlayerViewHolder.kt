package com.example.concurso3.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.concurso3.R
import com.squareup.picasso.Picasso
import java.io.File

class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view)
{
    val foto = view.findViewById<ImageView>(R.id.fotoJugador)
    val nombre = view.findViewById<TextView>(R.id.nombreJugador)
    val helado = view.findViewById<TextView>(R.id.heladoJugador)

    fun render(playerModel: Player)
    {
        nombre.text = playerModel.nombre
        helado.text = playerModel.helado

        val route = playerModel.nombre + "-" + playerModel.helado + ".jpg"

        val uri = File("/data/data/com.example.concurso3/files/$route")

        val uriImage = Uri.fromFile(uri)

        Picasso.with(foto.context).load(uriImage).fit().centerCrop().into(foto)
    }
}