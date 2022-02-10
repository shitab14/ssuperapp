package smir.shitab.shitabssuperapp.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.fragment.BaseFragment
import smir.shitab.shitabssuperapp.databinding.FragmentCameraExperimentBinding

class CameraExperimentFragment : BaseFragment<FragmentCameraExperimentBinding>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_camera_experiment

    private lateinit var viewModel: CameraExperimentViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CameraExperimentViewModel::class.java]
        // TODO: Use the ViewModel
    }

}