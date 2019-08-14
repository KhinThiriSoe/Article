package com.khinthirisoe.cararticle.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khinthirisoe.cararticle.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val articleContent = DetailsFragmentArgs.fromBundle(arguments!!).selectedContent
        val viewModelFactory = DetailViewModelFactory(articleContent, application)
        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(DetailsViewModel::class.java)
        return binding.root
    }
}
