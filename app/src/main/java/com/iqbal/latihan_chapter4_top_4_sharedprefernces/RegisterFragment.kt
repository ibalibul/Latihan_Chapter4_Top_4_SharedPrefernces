package com.iqbal.latihan_chapter4_top_4_sharedprefernces

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.iqbal.latihan_chapter4_top_4_sharedprefernces.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("Userdata",Context.MODE_PRIVATE)

        btnRegister.setOnClickListener{
            var getUsername = binding.etUserName.text.toString()
            var getFullname = binding.etFullname.text.toString()
            var getPassword = binding.etPassword.text.toString()
            var getReapeatpass = binding.etRepeatPassword.text.toString()

            if(getPassword.equals(getReapeatpass)){
                var addUser = sharedPref.edit()
                addUser.putString("username", getUsername)
                addUser.putString("fullname", getFullname)
                addUser.putString("password", getPassword)
                addUser.apply()
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
            }

            else Toast.makeText(context, "Password Invalid!", Toast.LENGTH_SHORT).show()
        }
        tvregister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}