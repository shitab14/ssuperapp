package smir.shitab.shitabssuperapp.pages.homelanding.settingspage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.fragment.BaseFragment
import smir.shitab.shitabssuperapp.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

//    private var _binding : FragmentSettingsBinding? = null
//    private val binding get() = _binding!!

    override val layoutResourceId: Int
        get() = R.layout.fragment_settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding/*binding*/.tvText.text = "Settings Fragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

}