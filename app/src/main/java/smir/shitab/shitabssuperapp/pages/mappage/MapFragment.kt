package smir.shitab.shitabssuperapp.pages.mappage

import MapUtil
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.fragment.BaseFragment
import smir.shitab.shitabssuperapp.databinding.FragmentConversionBinding

class MapFragment : BaseFragment<FragmentConversionBinding>() {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var viewModel: MapViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[MapViewModel::class.java]

//        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
//        MapUtil.setupMapView(lat = 23.8, lng = 90.0, parentFragment = this,  mapFragment = mapFragment)
    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_map

}