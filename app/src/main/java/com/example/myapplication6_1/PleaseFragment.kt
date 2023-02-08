package com.example.myapplication6_1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication6_1.databinding.FragmentPleaseBinding
import com.example.myapplication6_1.databinding.FragmentSettingBinding

class PleaseFragment: Fragment() {

    lateinit var viewBinding : FragmentPleaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPleaseBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.backbtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_setting, SettingFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}