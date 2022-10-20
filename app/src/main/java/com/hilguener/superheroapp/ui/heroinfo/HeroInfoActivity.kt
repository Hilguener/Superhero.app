package com.hilguener.superheroapp.ui.heroinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hilguener.superheroapp.R
import kotlinx.android.synthetic.main.card_hero_search.*

class HeroInfoActivity: AppCompatActivity() {

    lateinit var viewModel: HeroInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_info)

        viewModel = ViewModelProvider(this).get(HeroInfoViewModel::class.java)

        initUI()
    }
    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        viewModel.getHeroInfo(id)

        viewModel.heroInfo.observe(this, Observer{ hero ->
            heroText.text = hero.name


            Glide.with(this).load(hero.image).into(imageView)

        })
    }
}