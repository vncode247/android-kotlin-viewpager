package com.vncode247.viewpager

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_viewpager_item.view.*

class ViewPagerItemFragment : Fragment() {
    private var delegate: ViewPagerInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_viewpager_item, container, false)

        val index = arguments!!.getInt(EXTRA_ITEM_INDEX)
        v.indicator1.setImageResource(R.drawable.indicator)
        v.indicator2.setImageResource(R.drawable.indicator)
        v.indicator3.setImageResource(R.drawable.indicator)
        v.indicator4.setImageResource(R.drawable.indicator)
        v.btnPrevious.alpha = 1f
        v.btnPrevious.alpha = 1f
        when (index) {
            1 -> {
                v.img.setImageResource(R.drawable.demo_img_1)
                v.indicator1.setImageResource(R.drawable.indicator_active)
                v.btnPrevious.alpha = 0.3f
            }
            2 -> {
                v.img.setImageResource(R.drawable.demo_img_2)
                v.indicator2.setImageResource(R.drawable.indicator_active)
            }
            3 -> {
                v.img.setImageResource(R.drawable.demo_img_3)
                v.indicator3.setImageResource(R.drawable.indicator_active)
            }
            4 -> {
                v.img.setImageResource(R.drawable.demo_img_4)
                v.indicator4.setImageResource(R.drawable.indicator_active)
                v.btnNext.alpha = 0.3f
            }
        }

        v.btnPrevious.setOnClickListener {
            delegate?.goBack()
        }

        v.btnNext.setOnClickListener {
            delegate?.goNext()
        }

        return v
    }

    override fun onAttach(p_Context: Context?) {
        super.onAttach(p_Context)
        try {
            delegate = p_Context as ViewPagerInterface
        } catch (e: ClassCastException) {
            Log.e("Error", e.message)
        }
    }

    companion object {
        val EXTRA_ITEM_INDEX = "EXTRA_ITEM_INDEX"

        fun newInstance(index: Int): ViewPagerItemFragment {
            val f = ViewPagerItemFragment()
            val bdl = Bundle()
            bdl.putInt(EXTRA_ITEM_INDEX, index)
            f.arguments = bdl

            return f
        }
    }
}