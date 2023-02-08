package com.example.myapplication6_1

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication6.OneFragment
import com.example.myapplication6.ThreeFragment
import com.example.myapplication6.TwoFragment

class MainVPAdapter(fragmentActivity: SearchFragment): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }

}