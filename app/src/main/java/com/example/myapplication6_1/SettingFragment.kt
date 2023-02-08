package com.example.myapplication6_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication6_1.databinding.FragmentSettingBinding

class SettingFragment: Fragment() {

    lateinit var viewBinding : FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSettingBinding.inflate(layoutInflater)

        viewBinding.btn.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.frame_setting, PleaseFragment())
                .commit()
        }

        return viewBinding.root
    }
}