package smir.shitab.shitabssuperapp.pages.conversionpage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.fragment.BaseFragment
import smir.shitab.shitabssuperapp.databinding.FragmentConversionBinding

class ConversionFragment : BaseFragment<FragmentConversionBinding>() {

    private lateinit var viewModel: ConversionViewModel

    override val layoutResourceId: Int
        get() = R.layout.fragment_conversion

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ConversionViewModel::class.java]
        // TODO: Use the ViewModel
    }


}