package com.example.concurso3.adapter

import android.content.Context
import java.io.BufferedReader
import java.io.File
import android.os.Environment
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*

class PlayerProvider
{
    companion object{
        private lateinit var context:Context

        fun setContext(contexto:Context)
        {
            context=contexto
        }

        fun fillList(): ArrayList<Player>
        {
            val listaPuntuacion: ArrayList<Player> = ArrayList<Player>()
            val ficheroCsv = File("/data/data/com.example.concurso3/files/puntuaciones.csv")

            val bufferedReader = BufferedReader(FileReader(ficheroCsv))
            val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
            for (csvRecord in csvParser)
            {
                val nombre = csvRecord[0]
                val nombre_fichero = csvRecord[1]
                listaPuntuacion.add(Player(nombre, nombre_fichero))
            }

            return listaPuntuacion
        }
    }
}