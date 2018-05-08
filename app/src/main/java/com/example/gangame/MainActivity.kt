package com.example.gangame

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.example.gangame.deals.DealsFragment
import com.example.gangame.owned.TopOwnedFragment
import com.example.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ActionMenuView
import android.widget.FrameLayout


class MainActivity : AppCompatActivity() {
    companion object {
        const val DEFAULT_OPTION =  R.id.action_deals
    }

    private val fragments : HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setListeners()

        navigationView.selectedItemId = DEFAULT_OPTION
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment : Fragment? = fragments[item.itemId]

            if(fragment != null){
                replaceFragment(fragment)
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment?){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    private fun initView(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if(currentFragment == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                    .commit()
        }
    }

    private fun setListeners(){
        credentialsButton.setOnClickListener {
            Toast.makeText(baseContext, resources.getString(R.string.credentials), Toast.LENGTH_SHORT).show()
        }
    }
}
