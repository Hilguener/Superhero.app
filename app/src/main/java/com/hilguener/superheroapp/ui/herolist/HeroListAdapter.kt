package com.hilguener.superheroapp.ui.herolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.hilguener.superheroapp.R
import com.hilguener.superheroapp.model.api.HeroesResponseItem
import kotlinx.android.synthetic.main.card_hero_search.view.*

class HeroListAdapter (val heroClick: (Int) -> Unit): RecyclerView.Adapter<HeroListAdapter.SearchViewHolder>(){
    var heroList : List<HeroesResponseItem> = emptyList<HeroesResponseItem>()

    fun setData(list : List <HeroesResponseItem>){
        heroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_hero_search, parent, false))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int){

        val hero = heroList[position]
        holder.itemView.heroText.text = "${hero.name}"

        holder.itemView.setOnClickListener {heroClick(hero.id)}
    }
    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}

