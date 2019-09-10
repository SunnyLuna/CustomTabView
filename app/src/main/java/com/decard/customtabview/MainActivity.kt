package com.decard.customtabview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.decard.customtabview.fragment.FindFragment
import com.decard.customtabview.fragment.HomeFragment
import com.decard.customtabview.fragment.MainFragment
import com.decard.customtabview.fragment.MallFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentList: ArrayList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        fragmentList = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(FindFragment())
        fragmentList.add(MallFragment())
        fragmentList.add(MainFragment())
        custom_tab.init(supportFragmentManager, fragmentList)
    }
}
