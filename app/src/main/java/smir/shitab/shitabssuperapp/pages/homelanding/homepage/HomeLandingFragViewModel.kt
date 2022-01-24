package smir.shitab.shitabssuperapp.pages.homelanding.homepage

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import smir.shitab.shitabssuperapp.common.NetworkUtil

class HomeLandingFragViewModel: ViewModel() {

    var uploadSpeedInMbps: MutableLiveData<Double> = MutableLiveData(0.0)
    val downloadSpeedInMbps: MutableLiveData<Double> = MutableLiveData(0.0)

    fun getBandwidthInKbps(context: Context) {
        if(NetworkUtil.isNetworkConnected(context)) {
            uploadSpeedInMbps.value = NetworkUtil.getUploadSpeedInKbps(context).toDouble()/8000
            downloadSpeedInMbps.value = NetworkUtil.getDownloadSpeedInKbps(context).toDouble()/8000
        } else {
            uploadSpeedInMbps.value = 0.0
            downloadSpeedInMbps.value = 0.0
        }
    }
}