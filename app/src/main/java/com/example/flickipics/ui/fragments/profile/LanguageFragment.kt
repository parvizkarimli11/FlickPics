package com.example.flickipics.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentLanguageBinding


class LanguageFragment : Fragment() {

    var binding:FragmentLanguageBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentLanguageBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textViewEnglish=binding?.textViewEnglish
        var textViewFrench=binding?.textViewFrench
        var textViewSpanish=binding?.textViewSpanish
        var textViewTurkish=binding?.textViewTurkish
        var textViewRussian=binding?.textViewRussian

        var languages= listOf(textViewEnglish,textViewTurkish,textViewFrench,textViewSpanish,textViewRussian)

        languages.forEach{textView->

            textView?.setOnClickListener {

                languages.forEach{
                    it?.isSelected=false
                }
                textView.isSelected=true
            }

        }

        binding?.arrowBackImageView?.setOnClickListener {

            findNavController().popBackStack()

        }
    }

}