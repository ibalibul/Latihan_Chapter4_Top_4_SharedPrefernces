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
import com.iqbal.latihan_chapter4_top_4_sharedprefernces.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var sharedpfre : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedpfre =  requireActivity().getSharedPreferences("Userdata", Context.MODE_PRIVATE)


        btnlogin.setOnClickListener{
            var inputUsername = binding.etName.text.toString()
            var inputPass = binding.etPassword.text.toString()


            var userName = sharedpfre.getString("username","")
            var password = sharedpfre.getString("password","")

            if(inputUsername.equals("") || inputPass.equals("")){
                Toast.makeText(context, "Fill In Username and Password!", Toast.LENGTH_SHORT).show()
            }
            else {
                if(inputUsername.equals(userName)){
                    if(inputPass.equals(password)){
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                    else Toast.makeText(context, "Password Invalid!", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(context, "Username Invalid!", Toast.LENGTH_SHORT).show()
            }
        }

        tvregister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}