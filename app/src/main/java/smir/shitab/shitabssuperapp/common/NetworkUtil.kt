package smir.shitab.shitabssuperapp.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.content.Context.CONNECTIVITY_SERVICE
import android.os.Build


class NetworkUtil {

    fun isNetworkConnected(context: Context): Boolean {
        val conMgr = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        /** to get info of WIFI N/W :  */
        val wifi = conMgr
            .getNetworkInfo(ConnectivityManager.TYPE_WIFI)

        /** to get info of mobile N/W :  */
        val mobile = conMgr
            .getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (wifi!!.isAvailable && wifi.isConnected) {
            Log.e(
                "Is Net work? 1", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED
            )
            return true
        } else if (mobile != null && mobile.isAvailable && mobile.isConnected) {
            Log.e(
                "Is Net work? 2", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED
            )
            return true
        } else if (conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo!!.isAvailable
            && conMgr.activeNetworkInfo!!.isConnected
        ) {
            Log.e(
                "Is Net work? 3", "isNetWork:in 'isNetWork_if' is N/W Connected:"
                        + NetworkInfo.State.CONNECTED
            )
            return true
        }
        return false
    }

    fun getUploadSpeed(context: Context): Int? {
        try {
            val cm : ConnectivityManager? = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
            val nc = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cm?.getNetworkCapabilities(cm.activeNetwork)
            } else {
                // TODO("VERSION.SDK_INT < M")
                return null
            }
            val downSpeed : Int? = nc?.linkDownstreamBandwidthKbps
            val upSpeed : Int? = nc?.linkUpstreamBandwidthKbps
            return upSpeed
        } catch (e: Exception) {
            return null
        }
    }

    fun getDownloadSpeed(context: Context): Int? {
        try {
            val cm : ConnectivityManager? = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
            val nc = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cm?.getNetworkCapabilities(cm.activeNetwork)
            } else {
                // TODO("VERSION.SDK_INT < M")
                return null
            }
            val downSpeed : Int? = nc?.linkDownstreamBandwidthKbps
            val upSpeed : Int? = nc?.linkUpstreamBandwidthKbps
            return downSpeed
        } catch (e: Exception) {
            return null
        }
    }

}