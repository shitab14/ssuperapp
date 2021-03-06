package smir.shitab.shitabssuperapp.pages.homelanding.homepage

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tbruyelle.rxpermissions3.RxPermissions
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.fragment.BaseFragment
import smir.shitab.shitabssuperapp.databinding.FragmentHomeLandingBinding

class HomeLandingFragment : BaseFragment<FragmentHomeLandingBinding>() {

//    private var _binding : FragmentHomeLandingBinding? = null
//    private val binding get() = _binding!!

    private lateinit var viewModel: HomeLandingFragViewModel
    private lateinit var rxPermissions: RxPermissions


    override val layoutResourceId: Int
        get() = R.layout.fragment_home_landing

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rxPermissions = RxPermissions(this) // where this is an Activity or Fragment instance

        viewModel = ViewModelProvider(this)[HomeLandingFragViewModel::class.java]
        viewModel.getBandwidthInKbps(requireContext())

        dataBinding/*binding*/.viewmodel = viewModel

        setupOnClick(dataBinding/*binding*/, activity as Context)
    }

    private fun setupOnClick(binding: FragmentHomeLandingBinding, context: Context) {
        binding.buttonGoToPokeDex.setOnClickListener {
            viewModel.goToPokedex(context)
        }

        binding.buttonGoToConversionPage.setOnClickListener {
            findNavController().navigate(R.id.action_homeLandingFragment_to_conversionFragment)
        }

        binding.buttonGoToExperimentalCameraPage.setOnClickListener {
            rxPermissions.requestEach(
                    Manifest.permission.CAMERA,
                )
                .subscribe { permission ->  // will emit 2 Permission objects
                    when {
                        permission.granted -> {
                            // `permission.name` is granted !
                            findNavController().navigate(R.id.action_homeLandingFragment_to_cameraExperimentFragment)

                        }
                        permission.shouldShowRequestPermissionRationale -> {
                            // Denied permission without ask never again
                        }
                        else -> {
                            // Denied permission with ask never again
                            // Need to go to the settings
                        }
                    }
                }
        }

        binding.buttonGoToMapPage.setOnClickListener {
            findNavController().navigate(R.id.action_homeLandingFragment_to_mapFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

}