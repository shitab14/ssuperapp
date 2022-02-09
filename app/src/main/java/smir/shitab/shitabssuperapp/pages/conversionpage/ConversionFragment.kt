package smir.shitab.shitabssuperapp.pages.conversionpage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import smir.shitab.shitabssuperapp.R

class ConversionFragment : Fragment() {

    companion object {
        fun newInstance() = ConversionFragment()
    }

    private lateinit var viewModel: ConversionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.conversion_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ConversionViewModel::class.java]
        // TODO: Use the ViewModel
    }

}