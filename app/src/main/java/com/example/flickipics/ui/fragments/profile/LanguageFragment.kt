package com.example.flickipics.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.flickipics.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {

    private var binding: FragmentLanguageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewEnglish = binding?.textViewEnglish
        val textViewFrench = binding?.textViewFrench
        val textViewSpanish = binding?.textViewSpanish
        val textViewTurkish = binding?.textViewTurkish
        val textViewRussian = binding?.textViewRussian

        val languages = listOf(
            textViewEnglish,
            textViewTurkish,
            textViewFrench,
            textViewSpanish,
            textViewRussian
        )

        languages.forEach { textView ->
            textView?.setOnClickListener {
                languages.forEach {
                    it?.isSelected = false
                }
                textView.isSelected = true
            }
        }

        binding?.arrowBackImageView?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}