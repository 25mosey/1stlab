package com.example.a1stlab.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a1stlab.R
import com.example.a1stlab.SiteActivity
import com.example.a1stlab.models.University

class UniversitiesAdapter(var c:Context) : RecyclerView.Adapter<UniversitiesAdapter.UniversityViewHolder>() {

    private var universities: List<University> = emptyList()
    private var context:Context = c
    fun setUniversities(newUniversities: List<University>) {
        universities = newUniversities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return UniversityViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val university = universities[position]
        holder.bind(university)
        holder.itemView.setOnClickListener{
            var intent=Intent(context,SiteActivity::class.java)
            intent.putExtra("site",university.webPages[0])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    class UniversityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(university: University) {
            itemView.findViewById<TextView>(R.id.nameTextView).text = university.name
            itemView.findViewById<TextView>(R.id.countryTextView).text = university.webPages[0]

        }
    }

}

