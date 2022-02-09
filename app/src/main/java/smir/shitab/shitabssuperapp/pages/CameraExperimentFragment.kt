package smir.shitab.shitabssuperapp.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import smir.shitab.shitabssuperapp.R

class CameraExperimentFragment : Fragment() {

    companion object {
        fun newInstance() = CameraExperimentFragment()
    }

    private lateinit var viewModel: CameraExperimentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.camera_experiment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CameraExperimentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}