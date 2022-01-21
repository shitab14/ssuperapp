package smir.shitab.shitabssuperapp.pages.homelanding.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.databinding.FragmentHomeLandingBinding

class HomeLandingFragment : Fragment(R.layout.fragment_home_landing) {

    private var _binding : FragmentHomeLandingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentHomeLandingBinding.inflate(inflater, container, false)

        binding.tvText.text = "Home Landing Fragment"

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}