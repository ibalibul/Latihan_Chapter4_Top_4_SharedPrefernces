package com.iqbal.latihan_chapter4_top_4_sharedprefernces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.iqbal.latihan_chapter4_top_4_sharedprefernces.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPreferces : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferces =  requireActivity().getSharedPreferences("Userdata",Context.MODE_PRIVATE)
        textuserName.setText(sharedPreferces.getString("namaLengkap","anda"))

        btnlogout.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}