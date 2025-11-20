package com.example.flickipics.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

  var binding:FragmentProfileBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.textViewProfile?.setOnClickListener{

            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        binding?.textViewPassword?.setOnClickListener {

            findNavController().navigate(R.id.action_profileFragment_to_changePasswordFragment)

        }

        binding?.textViewLanguage?.setOnClickListener {

            findNavController().navigate(R.id.action_profileFragment_to_languageFragment)

        }

        binding?.textViewNotifaction?.setOnClickListener {

            findNavController().navigate(R.id.action_profileFragment_to_notifactionFragment)
        }

        binding?.arrowBackImageView?.setOnClickListener{

            findNavController().popBackStack()

        }



    }

}