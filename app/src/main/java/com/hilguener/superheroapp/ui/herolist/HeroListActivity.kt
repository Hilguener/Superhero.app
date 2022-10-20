package com.hilguener.superheroapp.ui.herolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hilguener.superheroapp.R
import com.hilguener.superheroapp.ui.heroinfo.HeroInfoActivity
import kotlinx.android.synthetic.main.activity_hero_list.*

class HeroListActivity : AppCompatActivity(){

    private lateinit var viewModel: HeroListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_list)

        viewModel = ViewModelProvider(this).get(HeroListViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        heroListRecyclerView.layoutManager = GridLayoutManager(this,2)
        heroListRecyclerView.adapter = HeroListAdapter{
            val intent = Intent(this, HeroInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.getHeroList()

        viewModel.heroList.observe(this, Observer { list ->
            (heroListRecyclerView.adapter as HeroListAdapter).setData(list) })
    }

}