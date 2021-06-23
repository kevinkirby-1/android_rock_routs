package com.example.rockrouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.routlistitem.view.*

class routAdapter(
    private val routs: MutableList<rout>
) : RecyclerView.Adapter<routAdapter.RoutViewHolder>() {

    class RoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutViewHolder {
        return RoutViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.routlistitem,
                parent,
                false
            )
        )
    }

    fun addRout(rout: rout) {
        routs.add(rout)
        notifyItemInserted(routs.size - 1)
    }


    override fun onBindViewHolder(holder: RoutViewHolder, position: Int) {
        val curRout = routs[position]
        holder.itemView.apply {
            tvRoutName.text = curRout.name
            tvRoutGrade.text = curRout.grade
            tvSetter.text = "Setter: " + curRout.setter
        }
    }

    override fun getItemCount(): Int {
        return  routs.size
    }
}