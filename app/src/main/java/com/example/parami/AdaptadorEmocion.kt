package com.example.parami

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorEmocion (private val listaremociones:List<EntidadEmocion>):
    RecyclerView.Adapter<AdaptadorEmocion.EmocionViewHolder>() {
    class EmocionViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val img_Emocion: ImageView =itemView.findViewById(R.id.imgEmocion)
        val tv_Uno: TextView =itemView.findViewById(R.id.tvUno)
        val tv_Dos: TextView =itemView.findViewById(R.id.tvDos)
        val btnQueHago : Button = itemView.findViewById(R.id.btnQueHago)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmocionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_emociones,parent,false)
        return EmocionViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaremociones.size
    }

    override fun onBindViewHolder(holder: EmocionViewHolder, position: Int) {
        val emocionesActuales=listaremociones[position]
        holder.img_Emocion.setImageResource(emocionesActuales.imagenEmocion)
        holder.tv_Uno.text=emocionesActuales.textoEmocion
        holder.tv_Dos.text=emocionesActuales.descripEmocion

        holder.btnQueHago.setOnClickListener {
            val context = holder.itemView.context
            val intent = when (emocionesActuales.descripEmocion) {
                "Feliz" -> Intent(context, ActivityFeliz::class.java)
                "Ansiosa" -> Intent(context, ActivityAnsiosa::class.java)
                "Enojada" -> Intent(context, ActivityEnojada::class.java)
                "Triste" -> Intent(context, ActivityTriste::class.java)
                "Aburrida" -> Intent(context, ActivityAburrida::class.java)
                "Miedo" -> Intent(context, ActivityMiedo::class.java)
                else -> null
            }
            intent?.let { context.startActivity(it) }
        }


    }

}