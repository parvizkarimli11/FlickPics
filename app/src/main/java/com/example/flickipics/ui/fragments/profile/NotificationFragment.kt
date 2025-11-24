package com.example.flickipics.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.flickipics.ThemeManager
import com.example.flickipics.databinding.FragmentDarkModeBinding

class NotificationFragment : Fragment() {

    private var binding: FragmentDarkModeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDarkModeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.switchNotification?.setOnCheckedChangeListener { _, isChecked ->
            ThemeManager.setDarkMode(requireContext(), isChecked)
        }

        binding?.arrowBackImageView?.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}






