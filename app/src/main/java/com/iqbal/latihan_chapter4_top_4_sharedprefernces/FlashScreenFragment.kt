package com.iqbal.latihan_chapter4_top_4_sharedprefernces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.iqbal.latihan_chapter4_top_4_sharedprefernces.databinding.FragmentFlashScreenBinding


class FlashScreenFragment : Fragment() {

    lateinit var binding : FragmentFlashScreenBinding
    lateinit var sharedPreferces : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_flash_screen, container, false)
        binding  = FragmentFlashScreenBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Untuk memanggil SharedP
        sharedPreferces = requireActivity().getSharedPreferences("Userdata", Context.MODE_PRIVATE)
        var datauser = sharedPreferces.getString("username","")

        if (datauser !=  ""){
        var namalengkap = sharedPreferces.getString("namaLengkap","anda")
        var bundle = Bundle()
        bundle.putString("namaLengkpa",namalengkap)

            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.action_flashScreenFragment_to_homeFragment, bundle)
            }, 3000)
        }
        else {
            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.action_flashScreenFragment_to_loginFragment)
            }, 3000)
        }
    }

}