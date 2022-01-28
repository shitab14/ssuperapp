package smir.shitab.shitabssuperapp.pages.homelanding.homepage

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import smir.shitab.shitabssuperapp.common.NavigationUtil
import smir.shitab.shitabssuperapp.common.NetworkUtil
import smir.shitab.shitabssuperapp.pages.pokedexpage.PokeDexHomeActivity

class HomeLandingFragViewModel: ViewModel() {

    private var _uploadSpeedInMbps: MutableLiveData<Double> = MutableLiveData(0.0)
    private val _downloadSpeedInMbps: MutableLiveData<Double> = MutableLiveData(0.0)

    val uploadSpeedInMbps: LiveData<Double>
        get() = _uploadSpeedInMbps
    val downloadSpeedInMbps: LiveData<Double>
        get() = _downloadSpeedInMbps

    fun getBandwidthInKbps(context: Context) {
        if(NetworkUtil.isNetworkConnected(context)) {
            _uploadSpeedInMbps.value = NetworkUtil.getUploadSpeedInKbps(context).toDouble()/8000
            _downloadSpeedInMbps.value = NetworkUtil.getDownloadSpeedInKbps(context).toDouble()/8000
        } else {
            _uploadSpeedInMbps.value = 0.0
            _downloadSpeedInMbps.value = 0.0
        }
    }

    fun goToPokedex(context: Context) {
        NavigationUtil.goToNextActivity(context, PokeDexHomeActivity::class.java)
    }

}