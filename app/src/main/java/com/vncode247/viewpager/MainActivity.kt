package com.vncode247.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

    class MainActivity : AppCompatActivity(), ViewPagerInterface {
    override fun goNext() {
        viewPager.currentItem = viewPager.currentItem + 1
    }

    override fun goBack() {
        viewPager.currentItem = viewPager.currentItem - 1
    }

    private lateinit var adapter: ViewPagerAdapter
    private var fragments: List<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments = getFragments()
        adapter = ViewPagerAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    private fun getFragments(): List<Fragment> {
        val fList = ArrayList<Fragment>()
        fList.add(ViewPagerItemFragment.newInstance(1))
        fList.add(ViewPagerItemFragment.newInstance(2))
        fList.add(ViewPagerItemFragment.newInstance(3))
        fList.add(ViewPagerItemFragment.newInstance(4))
        return fList
    }

}
