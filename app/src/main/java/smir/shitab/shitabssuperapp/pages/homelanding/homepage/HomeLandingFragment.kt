package smir.shitab.shitabssuperapp.pages.homelanding.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.databinding.FragmentHomeLandingBinding

class HomeLandingFragment() : Fragment(R.layout.fragment_home_landing) {

    private var _binding : FragmentHomeLandingBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeLandingFragViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentHomeLandingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[HomeLandingFragViewModel::class.java]
        viewModel.getBandwidthInKbps(requireContext())
        /*viewModel.uploadSpeedInMbps.observe(requireActivity(),
            androidx.lifecycle.Observer {

            })*/

        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}