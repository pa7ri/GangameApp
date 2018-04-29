package com.example.gangame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.commons.BaseFragment
import com.example.gangame.deals.DealsFragment
import com.example.gangame.owned.TopOwnedFragment
import com.example.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val DEAFULT_OPTION =  R.id.action_deals
    }

    val fragments : HashMap<Int, BaseFragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.selectedItemId = DEAFULT_OPTION
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment : BaseFragment? = fragments[item.itemId]
            true
        }
    }

    fun initView(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(currentFragment == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEAFULT_OPTION] as Fragment)
                    .commit()
        }
    }
}
