package com.example.concurso3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concurso3.R

class PlayerAdapter(private val playerList:ArrayList<Player>) : RecyclerView.Adapter<PlayerViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)

        return PlayerViewHolder(layoutInflater.inflate(R.layout.puntuacion, parent, false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int)
    {
        val item = playerList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int
    {
        return playerList.size
    }

}